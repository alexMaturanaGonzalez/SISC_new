/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Controlador.ControladorVectorizacion;
import Entidades.Forma;
import Entidades.Imagen;
import Interfaces.InterfaceBuscador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Alex
 */
public class BuscadorReconocFiguras implements InterfaceBuscador {

    private Color[][] colorImagen;

    @Override
    public ArrayList<Imagen> busqueda(ArrayList<String> listPathImagenes, String fileName, String typeDistance, String distanceValue, double num, int numResult, boolean aplicarFiltro) throws Exception {

        Imagen vectorImagen = new ControladorVectorizacion().getVectorRecocForma().vectorizarImagen(fileName);

        ArrayList<Imagen> vectorListImage = new ControladorVectorizacion().getVectorRecocForma().vectorizarListaImagenes(listPathImagenes);

        Forma f = new Forma();
        f = (Forma) vectorImagen;
        colorImagen = f.getColorPromedio();


        //Aplicar filtro o no
        if (aplicarFiltro == true) {

            System.out.println("XXXXX cant vectorLista ANTES FILTRAR==> " + vectorListImage.size());
            vectorListImage = filtrarImagenes(vectorListImage);
            System.out.println("XXXXX cant vectorLista DPS FILTRAR==> " + vectorListImage.size());
        }



        for (int i = 0; i < vectorListImage.size(); i++) {

            Forma formaLista = (Forma) vectorListImage.get(i);
            vectorListImage.get(i).setDistancia(calcDistancia(formaLista.getColorPromedio()));
            
        }

        System.out.println("Ya calculo toda la distancia");

        vectorListImage = comparar(vectorListImage);

        int size = 0;
        if (numResult < vectorListImage.size() && numResult != 0) {

            size = numResult;
        } else {

            size = vectorListImage.size();
        }

        ArrayList<Imagen> arrayImagenResult = new ArrayList<Imagen>();

        for (int i = 0; i < size; i++) {

            arrayImagenResult.add(new Imagen(null, vectorListImage.get(i).getRuta(), vectorListImage.get(i).getDistancia(), null, 0, null, null, null, false));
        }

        for (int i = 0; i < arrayImagenResult.size(); i++) {

            System.out.println(arrayImagenResult.get(i).getRuta() + " Distancia " + arrayImagenResult.get(i).getDistancia() + " Name " + arrayImagenResult.get(i).getNombre());
        }

        return arrayImagenResult;
    }//Fin metodo busqueda

    public ArrayList<Imagen> comparar(ArrayList<Imagen> vectorListImage) {

        Imagen compare = new Imagen();
        Collections.sort(vectorListImage, compare);

        return vectorListImage;
    }//Fin metodo comparar

    private double calcDistancia(Color[][] colorListImagenes) {

        //System.out.println("Color Seleccionado > " + colorImagen.toString());
        //System.out.println("Color de imagen a comparar > " + colorListImagenes.toString());
        Color[][] colorImagenLista = new Color[4][4];
        colorImagenLista = colorListImagenes;
        double dist = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                int r1 = colorImagen[x][y].getRed();
                int g1 = colorImagen[x][y].getGreen();
                int b1 = colorImagen[x][y].getBlue();
                int r2 = colorImagenLista[x][y].getRed();
                int g2 = colorImagenLista[x][y].getGreen();
                int b2 = colorImagenLista[x][y].getBlue();
                double tempDist = Math.sqrt((r1 - r2) * (r1 - r2) + (g1 - g2)
                        * (g1 - g2) + (b1 - b2) * (b1 - b2));
                dist += tempDist;
            }
        }
        return dist;
    }//Fin metodo calcular Distancia

    private ArrayList<Imagen> filtrarImagenes(ArrayList<Imagen> vectorListImage) {

        int cont = 0;
        ArrayList<Imagen> vectorListImageNoElim = new ArrayList<Imagen>();
        Color[][] colorImagenLista = new Color[4][4];
        Forma form = new Forma();

        for (int i = 0; i < vectorListImage.size(); i++) {

            cont = 0;
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {

                    form = (Forma) vectorListImage.get(i);
                    colorImagenLista = form.getColorPromedio();

                    System.out.println("Color Imagen a Comparar ====> " + colorImagen[x][y].getRed());
                    System.out.println("Color Imagen de Lista a Comparar ====> " + colorImagenLista[x][y].getRed());

                    if (colorImagen[x][y].getRed() == colorImagenLista[x][y].getRed()) {

                        System.out.println("Tiene un dato igual que es ... " + colorImagenLista[x][y].getRed());
                        cont++;
                    }//Fin condicional

                }//Fin for Y
            }//Fin for X

            if (cont <= 3) {

                System.out.println("Se eliminaaa! " + vectorListImage.get(i).getRuta() + "-----------------------------");
                System.out.println("Valor de Cont -----> " + cont);
                //vectorListImage.remove(form);
            } else {

                System.out.println("Valor de Cont -----> " + cont);
                System.out.println("NOOO Se eliminaaa -- Se guarda" + vectorListImage.get(i).getRuta() + "-----------------------------");
                vectorListImageNoElim.add(form);
            }

            System.out.println("=========================================== > Valor i : " + i);
        }//Fin for


        return vectorListImageNoElim;
    }//Fin metodo filtrar Imágenes
}
