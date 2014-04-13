/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interfaces.InterfaceDistancia;
import Controlador.ControladorVectorizacion;
import Entidades.Color;
import Interfaces.InterfaceBuscador;
import Entidades.Imagen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Alex
 */
public class BuscadorHistograma extends Thread implements InterfaceBuscador {


    //No modificar
    private static int porcentajeDPF = 30;


    @Override
    public ArrayList<Imagen> busqueda(ArrayList<String> listPathImagenes, String fileName, String typeDistance, String distanceValue, double num, int numResult, boolean aplicarFiltro) throws Exception {

        double value = 1;
        InterfaceDistancia distancia = null;
        if (typeDistance.compareTo("DPF") == 0) {

            distancia = new DistanciaDPF(1, ((double) porcentajeDPF) / 100);
        } else if (typeDistance.compareTo("L") == 0) {

            if (distanceValue.compareTo("Manhattan") == 0) {

                value = 1;
            } else if (distanceValue.compareTo("Euclidean") == 0) {

                value = 2;
            } else if ((distanceValue.compareTo("n") == 0) || (distanceValue.compareTo("Fractional")) == 0) {

                value = num;
                System.out.println("\n\t" + value);
            } else {

                value = Integer.MAX_VALUE;
            }
            distancia = new DistanciaL(value);
        }

        Imagen vectorImage = new ControladorVectorizacion().getVectorHistograma().vectorizarImagen(fileName);
        ArrayList<Imagen> vectorListImage = new ControladorVectorizacion().getVectorHistograma().vectorizarListaImagenes(listPathImagenes);

        Color colorImage = new Color();
        colorImage = (Color) vectorImage;

        ArrayList<Color> listColorImage = new ArrayList<Color>();

        for (int i = 0; i < vectorListImage.size(); i++) {

            listColorImage.add((Color) vectorListImage.get(i));
        }

        parDid[] ids = comparar(colorImage, listColorImage, distancia);

        int size = 0;
        if (numResult < ids.length && numResult != 0) {

            size = numResult;
        } else {

            size = ids.length;
        }

        ArrayList<Imagen> arrayImagenResult = new ArrayList<Imagen>();

        for (int i = 0; i < size; i++) {

            System.out.println("Ruta " + ids[i].ruta + " Distancia " + ids[i].d);
            arrayImagenResult.add(new Imagen(null, ids[i].ruta, ids[i].d, null, 0, null, null, null, false));
        }

        for (int i = 0; i < arrayImagenResult.size(); i++) {

            System.out.println(arrayImagenResult.get(i).getRuta() + " Distancia " + arrayImagenResult.get(i).getDistancia() + " Name " + arrayImagenResult.get(i).getNombre());
        }

        return arrayImagenResult;
    }

    public parDid[] comparar(Color vectorImage, ArrayList<Color> vectorListImage, InterfaceDistancia distancia) {

        parDid[] ids2 = new parDid[vectorListImage.size()];
        for (int i = 0; i < vectorListImage.size(); i++) {

            ids2[i] = new parDid((distancia).d(vectorImage, vectorListImage.get(i)), vectorListImage.get(i).getRuta());
        }

        Arrays.sort(ids2);
        for (int i = 0; i < ids2.length; i++) {

            System.out.println(ids2[i].ruta + "--" + ids2[i].d + " ");
        }
        return ids2;
    }//Fin metodo Comparar

}//Fin clase

