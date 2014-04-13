/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Imagen;
import Logica.ExtraerInfoImagen;
import Logica.GestionResultados;
import Logica.GestionRutasFavoritas;
import Logica.ProcesarImagen;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class ControladorImagen {

    private ExtraerInfoImagen gestionImagen = new ExtraerInfoImagen();
    private GestionResultados gestionResultados = new GestionResultados();
    private ArrayList<String> listPathImagenes = new ArrayList<String>();
    private ProcesarImagen procesarImagen = new ProcesarImagen();
    private GestionRutasFavoritas gestionRutasFavoritas = new GestionRutasFavoritas();

    public ArrayList<String> extraerRutaImagenes(String rutaCarpeta) {

        try {

            listPathImagenes = new ExtraerInfoImagen().obtenerImagenesRuta(rutaCarpeta);
        } catch (Exception ex) {

            Logger.getLogger(ControladorImagen.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ErrorExtraerImagenes");
        }

        return listPathImagenes;
    }//Fin metodo extraerRutaImagenes

    public ArrayList<Imagen> encapsularInformacionImagen(ArrayList<Imagen> arrayImagenResult) {

        ArrayList<Imagen> arrayImagenInfo = new ArrayList<Imagen>();

        for (int i = 0; i < arrayImagenResult.size(); i++) {

            arrayImagenInfo.add(gestionImagen.extraerInfoImagen(arrayImagenResult.get(i)));
        }
        return arrayImagenInfo;
    }//Fin encapsular

    public ArrayList<String> separaRutas(String rutas) {

        return gestionImagen.separarRutas(rutas);
    }//Fin metodo separarRutas

    public boolean setearCheckImagen(Imagen imagenSelec, boolean checkValor) {

        gestionResultados.setCheckImagen(imagenSelec, checkValor);
        return true;

    }//Fin metodo set Check Imagen

    public boolean setearAllCheckImagen(ArrayList<Imagen> arrayImagenSelec, boolean checkValor) {

        gestionResultados.setAllCheckImagen(arrayImagenSelec, checkValor);
        return true;
    }//Fin metodo set Check Imagen

    public boolean almacenarImagenes(ArrayList<Imagen> imageResult, String folderDestino) {


        gestionResultados.copiarImagenes(imageResult, folderDestino);
        return true;
    }//Fin metodo almacenar Imagenes

    public boolean eliminarImagenes(ArrayList<Imagen> imageResult) {

        gestionResultados.eliminarImagenes(imageResult);
        return true;
    }//Fin metodo almacenar Imagenes

    public boolean renombrarImagen(String rutaImagenOrig, String nombreImagen, String ImagenNueva, String extensImagen) {

        String nameImagenCompleta = ImagenNueva.concat(extensImagen);
        System.out.println("ImagenCompleta Nueva : " + nameImagenCompleta);

        String rutaImagenCompleta = rutaImagenOrig.replace(nombreImagen, nameImagenCompleta);
        System.out.println("ImagenCompleta : " + rutaImagenCompleta);

        if (gestionResultados.renombrarImagen(rutaImagenOrig, rutaImagenCompleta)) {

            return true;
        } else {

            return false;
        }
    }//Fin metodo renombrar Imagen

    public BufferedImage extraerContornoImagen(BufferedImage imagenSinRuido) {

        BufferedImage imagenContorno;

        imagenContorno = procesarImagen.extraerContornoImagen(imagenSinRuido);

        if (imagenContorno != null) {

            return imagenContorno;
        } else {

            return null;
        }
    }//Fin metodo reducir Ruido de Imagen

    public boolean verificarTamanoImagen(String rutaImagen, long tamanoMax) {

        long tamanoImagen = gestionImagen.tamanoImagen(rutaImagen);

        if (tamanoImagen <= tamanoMax) {

            return true;
        } else {

            return false;
        }
    }//Fin metodo verficiar tamaño de Imagen

    public int verificarCantImageFolder(String rutaFolder) {

        gestionRutasFavoritas = new GestionRutasFavoritas();
        int cantImage = gestionRutasFavoritas.contadorImagenesRuta(rutaFolder);
        System.out.println("CANT imagenes ==> _" + cantImage + "_");

        return cantImage;
    }//Fin metodo verificar cant de imágenes en carpeta
}
