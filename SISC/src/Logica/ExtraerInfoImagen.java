/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.Imagen;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class ExtraerInfoImagen {

    private ArrayList<String> nameImage = new ArrayList<String>();
    private int cont = 0;

    public ArrayList<String> obtenerImagenesRuta(String rutaDirectorio) throws Exception {

        File file = new File(rutaDirectorio);
        if (file.exists()) {
            File[] ficheros = file.listFiles();
            for (int x = 0; x < ficheros.length; x++) {
                //System.out.println(ficheros[x].getName());
                if (ficheros[x].getName().endsWith(".jpg") || ficheros[x].getName().endsWith(".JPG")) {

                    nameImage.add(ficheros[x].getPath());
                }

                if (ficheros[x].isDirectory()) {

                    obtenerImagenesRuta(ficheros[x].getPath());
                }
            }

            //new Histograma().vectorizarHistograma(nameImage);
            //ArrayList<Imagen> asd = new Controlador.ControladorVectorizacion().getVectorHistograma().vectorizarListaImagenes(nameImage);
            System.out.println("NuMaaa: " + nameImage.size());
            return nameImage;
        } else {
            System.out.println("Fichero no Existe!");
            return null;
        }
    }//FIN metodo obtenerImagenesRuta

    public ArrayList<String> separarRutas(String rutas) {

        ArrayList<String> tempArrayRutas = new ArrayList<String>();
        StringTokenizer token;
        token = new StringTokenizer(rutas.trim(), "\n");
        while (token.hasMoreTokens()) {
            tempArrayRutas.add(token.nextToken());
        }

        return tempArrayRutas;
    }// Fin analisisLinea

    public Imagen extraerInfoImagen(Imagen imagenResult) {

        String rutaImagen = imagenResult.getRuta();
        File ficheroImagen = new File(rutaImagen);

        ImageIcon icon = new ImageIcon(rutaImagen);

        String nombreImagen = ficheroImagen.getName();
        String dimensionesImagen = "Altura: " + icon.getIconHeight() + "[px] Ancho: " + icon.getIconWidth() + " [px]";

        long tamanoImagen = ((ficheroImagen.length()) / 1024);
        String formatoImagen = getExtension(ficheroImagen);

        long ms = ficheroImagen.lastModified();
        Date d = new Date(ms);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaModifImagen = dateFormat.format(d);

        String descripImagen = icon.getDescription();

        imagenResult.setNombre(nombreImagen);
        imagenResult.setDimensiones(dimensionesImagen);
        imagenResult.setTamano(tamanoImagen);
        imagenResult.setFormato(formatoImagen);
        imagenResult.setFechaModif(fechaModifImagen);
        imagenResult.setDescrip(descripImagen);

        return imagenResult;
    }//Fin metodo extraer información

    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public long tamanoImagen(String rutaImagen) {

        File fileImage = new File(rutaImagen);
        long tamanoImage = fileImage.length();

        return tamanoImage;
    }//Fin metofdo tamaño de Imagen
}//FIN Clase

