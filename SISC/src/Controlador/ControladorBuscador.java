/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Imagen;
import Entidades.RutaFavorita;
import Interfaces.InterfaceBuscador;
import Logica.BuscadorAverageColor;
import Logica.BuscadorHistograma;
import Logica.BuscadorReconocFiguras;
import busqlocalimage.Vista.BuscarImagen.InterfazBarraLoading;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class ControladorBuscador {

    private ControladorImagen controladorImagen = new ControladorImagen();
    private ControladorRutasFavoritas controladorRutasFavoritas = new ControladorRutasFavoritas();
    private ArrayList<Imagen> arrayImagenResult = new ArrayList<Imagen>();

    public InterfaceBuscador getBuscadorHistograma() {
        return new BuscadorHistograma();
    }

    public InterfaceBuscador getBuscadorAverageColor() {
        return new BuscadorAverageColor();
    }

    public InterfaceBuscador getReconocimientoFormas() {
        return new BuscadorReconocFiguras();
    }

    public ArrayList<Imagen> gestionBuscador(Boolean checkRutaFav, String algoritmoSelect, String dondeBuscarRutaFav, String dondeBuscar, String fileName, String typeDistance, String distanceValue, double num, int numResult, boolean aplicarFiltro) {

        try {

            ArrayList<String> listPathImagenes = new ArrayList<String>();
            RutaFavorita rf;

            if (checkRutaFav) {

                System.out.println("Si ocupa Rutas Favoritas");
                rf = rutaFavSelect(dondeBuscarRutaFav);
                listPathImagenes = extrRutasImagen(rf);
            } else {

                System.out.println("No ocupa");
                listPathImagenes = controladorImagen.extraerRutaImagenes(dondeBuscar);
            }

            /*System.out.println("A");
            asd();
            System.out.println("B");*/

            if (algoritmoSelect.compareTo("Histograma de Colores") == 0) {

                aplicarFiltro = false;
                arrayImagenResult = controladorImagen.encapsularInformacionImagen(getBuscadorHistograma().busqueda(listPathImagenes, fileName, typeDistance, distanceValue, num, numResult, aplicarFiltro));
                System.out.println(arrayImagenResult.get(0).getNombre() + " Dist " + arrayImagenResult.get(0).getDistancia() + " Exten " + arrayImagenResult.get(0).getFormato());
            } else if (algoritmoSelect.compareTo("Promedio de Colores") == 0) {

                aplicarFiltro = false;
                arrayImagenResult = controladorImagen.encapsularInformacionImagen(getBuscadorAverageColor().busqueda(listPathImagenes, fileName, typeDistance, distanceValue, num, numResult, aplicarFiltro));
                System.out.println(arrayImagenResult.get(0).getNombre() + " Dist " + arrayImagenResult.get(0).getDistancia() + " Exten " + arrayImagenResult.get(0).getFormato());
            } else if (algoritmoSelect.compareTo("Reconocimiento de Formas") == 0) {

                System.out.println("Busqueda por Formas!");
                arrayImagenResult = controladorImagen.encapsularInformacionImagen(getReconocimientoFormas().busqueda(listPathImagenes, fileName, typeDistance, distanceValue, num, numResult, aplicarFiltro));
            }
        } catch (Exception ex) {

            Logger.getLogger(ControladorBuscador.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRORAZO!");
        }

        return arrayImagenResult;
    }//Fin metodo gestionBuscador

    private RutaFavorita rutaFavSelect(String dondeBuscarRutaFav) {

        ArrayList<RutaFavorita> arrayRutaFavorita = controladorRutasFavoritas.leerRutasFavoritas();
        RutaFavorita rutaFavorita = null;

        for (int i = 0; i < arrayRutaFavorita.size(); i++) {

            if ((arrayRutaFavorita.get(i).getNombre().compareTo(dondeBuscarRutaFav)) == 0) {

                rutaFavorita = arrayRutaFavorita.get(i);
            }
        }

        return rutaFavorita;
    }//Fin metodo extraerListaImagenRT

    private ArrayList<String> extrRutasImagen(RutaFavorita rf) {

        ArrayList<String> listPathImagenes = new ArrayList<String>();
        ArrayList<ArrayList<String>> tempListImagenes = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < rf.getRutas().size(); i++) {

            tempListImagenes.add(controladorImagen.extraerRutaImagenes(rf.getRutas().get(i)));
        }

        for (int i = 0; i < tempListImagenes.size(); i++) {
            for (int j = 0; j < tempListImagenes.get(i).size(); j++) {

                listPathImagenes.add(tempListImagenes.get(i).get(j));
            }
        }

        return listPathImagenes;
    }//Fin metoddo

    private void asd() {

        Runnable miRunnable = new Runnable() {

            public void run() {
                InterfazBarraLoading barraProgreso = new InterfazBarraLoading(100);
                barraProgreso.setVisible(true);

            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
    }
}
