/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Imagen;
import Entidades.RutaFavorita;
import Logica.GestionRutasFavoritas;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class ControladorRutasFavoritas {

    private RutaFavorita rutaFavorita;
    private GestionRutasFavoritas gestionSerializacion = new GestionRutasFavoritas();
    private static ArrayList<RutaFavorita> arrayRutaFavorita;

    public RutaFavorita encapsularRutaFavorita(String id, String nameRutaFavorita, ArrayList<String> arrayRutasFavoritas, int cantImagenes, String fechaCreacion) {

        id = Integer.toString(asignarID());
        rutaFavorita = new RutaFavorita(id, nameRutaFavorita, arrayRutasFavoritas, cantImagenes, fechaCreacion);
        return rutaFavorita;
    }//Fin metodo encapsularRutaFavorita

    private int asignarID() {

        int cantRutasFav = Integer.parseInt(gestionSerializacion.ultimoID());
        System.out.println(cantRutasFav);
        int id = cantRutasFav + 1;
        return id;
    }//Fin metodo asigarID

    public boolean archivoExiste() {

        String nombreArchivoRutas = "ArchivoRutasFavoritas.scs";
        File archivoRutasFav = new File(nombreArchivoRutas);

        if (archivoRutasFav.exists()) {
            //El archivo existe.
            return true;
        } else {
            //El archivo no existe.
            return false;
        }
    }//Fin Metodo archivoExiste

    public boolean crearArchivo() {

        if (gestionSerializacion.crearArchivo()) {

            return true;
        } else {

            return false;
        }
    }//Fin metodo crear archivo

    public boolean escribirRutasFavoritas(ArrayList<RutaFavorita> rutaFavorita) {

        if (gestionSerializacion.escribirRutas(rutaFavorita)) {

            return true;
        } else {

            return false;
        }

    }//Fin metodo Escribir RutasFavoriutas

    public boolean anadirRutaFavorita(RutaFavorita rutaFav) {

        if (gestionSerializacion.anadirRuta(rutaFav)) {

            return true;
        } else {

            return false;
        }
    }//Fin metodo añadir Rutas Favoritas

    public ArrayList<RutaFavorita> leerRutasFavoritas() {

        if (archivoExiste()) {

            arrayRutaFavorita = gestionSerializacion.leerArchivo();
            return arrayRutaFavorita;
        } else {

            return null;
        }
    }//Fin metodo leerRutasFavoritas()

    public ArrayList<RutaFavorita> modificarRutaFavorita(ArrayList<RutaFavorita> arrayRutasFavoritas, RutaFavorita rutaFavModificada) {

        ArrayList<RutaFavorita> arrayRutasFavModif = gestionSerializacion.modificarRuta(arrayRutasFavoritas, rutaFavModificada);

        if (escribirRutasFavoritas(arrayRutasFavModif)) {
            //modificado y escrito con exito
            return arrayRutasFavModif;
        }
        return null;
    }//Fin metodo añadir Rutas Favoritas

    public ArrayList<RutaFavorita> eliminarRuta(ArrayList<RutaFavorita> arrayRutaFavorita, int rutaFavSeleccionada) {

        arrayRutaFavorita.remove(rutaFavSeleccionada);
        if (escribirRutasFavoritas(arrayRutaFavorita)) {
            //modificado y escrito con exito
            return arrayRutaFavorita;
        }

        return arrayRutaFavorita;
    }//Fin metodo eliminarRuta

    public boolean verificarRutaFavorita(String nameRutaFavorita) {

        ArrayList<RutaFavorita> arrayRutaFavoritaVerif = leerRutasFavoritas();
        for (int i = 0; i < arrayRutaFavoritaVerif.size(); i++) {

            if (arrayRutaFavoritaVerif.get(i).getNombre().equalsIgnoreCase(nameRutaFavorita)) {
                //existe otra ruta con ese nombre
                return true;
            }
        }
        //no existe ninguna ruta con ese nombre
        return false;
    } //Fin metododo de verificación
}
