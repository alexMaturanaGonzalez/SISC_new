/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.Imagen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class GestionResultados {

    private ArrayList<Imagen> arrayImagenResult;
    private Imagen imagen;
    private static ArrayList<Imagen> imageResult = new ArrayList<Imagen>();

    public boolean setAllCheckImagen(ArrayList<Imagen> imagenResult, boolean checkValor) {

        arrayImagenResult = imagenResult;
        for (int i = 0; i < arrayImagenResult.size(); i++) {

            arrayImagenResult.get(i).setCheck(checkValor);
        }
        return true;
    }//Fin metodo set todos check Imagen

    public boolean setCheckImagen(Imagen imagenSelec, boolean checkValor) {

        imagen = imagenSelec;
        imagen.setCheck(checkValor);
        return true;
    }//Fin metodo setCheck

    public boolean copiarImagenes(ArrayList<Imagen> imageResult, String destino) {

        ArrayList<Imagen> arrayImageResultCheck = imageResult;

        for (int i = 0; i < arrayImageResultCheck.size(); i++) {

            copyImagen(arrayImageResultCheck.get(i).getRuta(), destino.concat("\\" + arrayImageResultCheck.get(i).getNombre()));
        }
        return true;
    }//Fin metodo copiar imagenes

    public boolean eliminarImagenes(ArrayList<Imagen> imageResult) {

        ArrayList<Imagen> arrayImageResultCheck = imageResult;

        for (int i = 0; i < arrayImageResultCheck.size(); i++) {

            deleteImagen(arrayImageResultCheck.get(i).getRuta());
        }
        return true;
    }//Fin metodo eliminar imagenes

    private boolean copyImagen(String rutaImagen, String folderDest) {
        try {

            FileInputStream fis = new FileInputStream(rutaImagen);
            FileOutputStream fos = new FileOutputStream(folderDest);
            FileChannel input = fis.getChannel();
            FileChannel output = fos.getChannel();
            input.transferTo(0, input.size(), output);
            fis.close();
            fos.close();
            System.out.println("Imagen Copiada");
            return true;
        } catch (IOException i) {

            i.printStackTrace();
            return false;
        }
    }//Fin metodo copiar Imagen

    private boolean deleteImagen(String rutaImagen) {

        try {

            File fichImagen = new File(rutaImagen);
            fichImagen.delete();
            System.out.println("Imagen Eliminada");
            return true;
        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }
    }//Fin metodo eliminar Imagen

    public boolean renombrarImagen(String rutaImagenOrig, String rutaImagenNueva) {

        File fichero = new File(rutaImagenOrig);
        File newFichero = new File(rutaImagenNueva);

        boolean archivoRename = fichero.renameTo(newFichero);

        long ms = System.currentTimeMillis();
        newFichero.setLastModified(ms);

        if (archivoRename) {

            System.out.println("El renombrado ha sido correcto");
            return true;
        } else {

            System.out.println("El renombrado no se ha podido realizar");
            return false;
        }

    }//Fin metodo renombrar Imagen
}
