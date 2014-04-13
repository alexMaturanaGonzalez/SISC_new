/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.RutaFavorita;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class GestionRutasFavoritas {

    private static ObjectOutputStream escribirObjeto;
    private static MiObjectOutputStream anadirObjeto;
    private static ObjectInputStream lectorObjeto;
    private ArrayList<String> nameImage = new ArrayList<String>();
    private int cont = 0;

    public boolean crearArchivo() {

        try {

            escribirObjeto = new ObjectOutputStream(new FileOutputStream("ArchivoRutasFavoritas.scs"));
            escribirObjeto.close();
            return true;
        } catch (Exception e) {

            System.err.println("No se pudo crear el archivo!");
            return false;
        }
    }//Fin metodo crearArchivo

    public boolean escribirRutas(ArrayList<RutaFavorita> rutaFav) {
        try {
            escribirObjeto = new ObjectOutputStream(new FileOutputStream("ArchivoRutasFavoritas.scs"));

            for (int i = 0; i < rutaFav.size(); i++) {

                escribirObjeto.writeObject(rutaFav.get(i));
            }

            escribirObjeto.close();
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }//Fin Metodo escribirArchivo

    public boolean anadirRuta(RutaFavorita rutaFav) {

        try {
            anadirObjeto = new MiObjectOutputStream(new FileOutputStream("ArchivoRutasFavoritas.scs", true));

            anadirObjeto.writeUnshared(rutaFav);
            anadirObjeto.close();
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }//Fin Metodo anadirArchivo

    public ArrayList<RutaFavorita> leerArchivo() {

        ArrayList<RutaFavorita> arrayRutaFav = new ArrayList<RutaFavorita>();
        RutaFavorita retorno = null;

        try {
            lectorObjeto = new ObjectInputStream(new FileInputStream("ArchivoRutasFavoritas.scs"));
            retorno = (RutaFavorita) lectorObjeto.readObject();

            while (retorno != null) {

                //System.out.println(retorno.getNombre() + "  " + retorno.getId());
                arrayRutaFav.add(retorno);
                retorno = (RutaFavorita) lectorObjeto.readObject();
            }

        } catch (EOFException e1) {
            //System.out.println("Fin de fichero");
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return arrayRutaFav;
    }//Fin metodo leerArchivo

    public ArrayList<RutaFavorita> modificarRuta(ArrayList<RutaFavorita> arrayRutasFavoritas, RutaFavorita rutaFavModificada) {

        for (int i = 0; i < arrayRutasFavoritas.size(); i++) {

            if (arrayRutasFavoritas.get(i).getId().equals(rutaFavModificada.getId())) {

                arrayRutasFavoritas.get(i).setNombre(rutaFavModificada.getNombre());
                arrayRutasFavoritas.get(i).setRutas(rutaFavModificada.getRutas());
                arrayRutasFavoritas.get(i).setCantImagenes(rutaFavModificada.getCantImagenes());
            }
        }

        return arrayRutasFavoritas;
    }//Fin metodo modificarRuta

    public int contadorImagenesRuta(String rutaDirectorio) {

        File file = new File(rutaDirectorio);

        File[] ficheros = file.listFiles();
        for (int x = 0; x < ficheros.length; x++) {

            if (ficheros[x].getName().endsWith(".jpg") || ficheros[x].getName().endsWith(".JPG")) {
                nameImage.add(ficheros[x].getPath());
                cont++;
            }

            if (ficheros[x].isDirectory()) {

                System.out.println(ficheros[x].getPath());
                contadorImagenesRuta(ficheros[x].getPath());
            }
        }
        return cont;
    }//FIN metodo contadorImagenesRuta

    public String ultimoID() {

        ArrayList<RutaFavorita> arrayRutaFav = new ArrayList<RutaFavorita>();
        arrayRutaFav = leerArchivo();
        String ultID;

        if (arrayRutaFav.isEmpty() || arrayRutaFav.size() == 0) {

            ultID = "0";
        } else {

            ultID = arrayRutaFav.get((arrayRutaFav.size() - 1)).getId();
        }

        return ultID;
    }
}
