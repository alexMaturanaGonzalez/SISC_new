/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ProcesarImagen {

    //private BufferedImage imagenModificada = null;
    //private EdgeDetector edgeDetector = new EdgeDetector();
    //private FiltroImagen filtroImagen = new FiltroImagen();
    public BufferedImage reducirRuidoImagen(String rutaImagen) {

        try {

            BufferedImage bufferedImage = ImageIO.read(new File(rutaImagen));
            BufferedImage imagenEscala = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);

            Graphics g = imagenEscala.getGraphics();
            g.drawImage(bufferedImage, 0, 0, 300, 300, null);

            FiltroImagen filtroImagen = new FiltroImagen();

            filtroImagen.setImagen(bufferedImage);
            BufferedImage imagenMediana = null;

            imagenMediana = filtroImagen.get_Imagen_Mediana();
            filtroImagen.setImagen(imagenMediana);
            imagenMediana = filtroImagen.get_Imagen_Mediana();

            BufferedImage imagenModificada = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            Graphics graficoModif = imagenModificada.getGraphics();
            graficoModif.drawImage(imagenMediana, 0, 0, 300, 300, null);

            try {

                ImageIO.write(imagenModificada, "jpg", new File("01.jpg"));
            } catch (Exception e) {

                System.out.println("Error de Escritura en Imagen");
            }

            BufferedImage asdruido = ImageIO.read(new File("01.jpg"));
            return asdruido;
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "No se puede abrir la imagen");
            return null;
        }

    }//Fin metodo reducir Imagen

    public BufferedImage extraerContornoImagen(BufferedImage imagenSinRuido) {

        try {

            ImageIcon icon = new ImageIcon(imagenSinRuido);
            Image image = icon.getImage();

            // Create empty BufferedImage, sized to Image
            BufferedImage frame = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // Draw Image into BufferedImage
            Graphics g = frame.getGraphics();
            g.drawImage(image, 0, 0, null);


            EdgeDetector edgeDetector = new EdgeDetector();

            edgeDetector.setSourceImage(frame);
            edgeDetector.process();
            BufferedImage edges = edgeDetector.getEdgesImage();

            //Color(0, 0, 0) ==> NEGRO.
            //Color(255, 255, 255) ==> BLANCO.
            //Color(255, 51, 51) ==> ROJO.

            System.out.println("Cambio de Color 1");
            //Cambiar de Negro a Rojo
            edges = edgeDetector.cambiarColor(new Color(255, 51, 51), edges, new Color(0, 0, 0));

            System.out.println("Cambio de Color 2");
            //Cambiar el Blanco a Negro
            edges = edgeDetector.cambiarColor(new Color(0, 0, 0), edges, new Color(255, 255, 255));

            System.out.println("Cambio de Color 3");
            //Cambiar el Rojo a Blanco
            edges = edgeDetector.cambiarColor(new Color(255, 255, 255), edges, new Color(255, 51, 51));

            try {

                ImageIO.write(edges, "jpg", new File("02.jpg"));
            } catch (Exception e) {

                System.out.println("Error de Escritura en Imagen");
            }

            BufferedImage asd = ImageIO.read(new File("02.jpg"));
            return asd;
        } catch (Exception e) {

            return null;
        }
    }//Fin metodo extraer Contorno de Imagen
}
