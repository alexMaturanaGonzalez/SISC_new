/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.Color;
import Entidades.Imagen;
import Interfaces.InterfaceVectorizacion;
import java.awt.Rectangle;
import java.awt.image.renderable.ParameterBlock;
import java.util.ArrayList;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.ROI;
import javax.media.jai.ROIShape;

/**
 *
 * @author Alex
 */
public class VectorizadorAverageColor implements InterfaceVectorizacion {


    private PlanarImage imagen = null;
    ROI roi = null;
    ParameterBlock pb;
    private boolean[] sonImagenes = null;
    private int segmentosPermitidos = 3;

    @Override
    public ArrayList<Imagen> vectorizarListaImagenes(ArrayList<String> listPathImagenes) throws Exception {

        ArrayList<Imagen> imagenesVector = new ArrayList<Imagen>();
        Imagen imagenVectorEncap = null;

        sonImagenes = new boolean[listPathImagenes.size()];

        for (int i = 0; i < listPathImagenes.size(); i++) {

            System.out.println("Imagen " + listPathImagenes.get(i));
            sonImagenes[i] = verificarEsImagen(listPathImagenes.get(i));
            System.out.println("Es imagen: " + sonImagenes[i]);

            if (sonImagenes[i]) {

                imagen = JAI.create("fileload", listPathImagenes.get(i));
                imagenVectorEncap = vectorizarImagen(listPathImagenes.get(i));
                imagenesVector.add(imagenVectorEncap);
                new LiberarMemoria();
            }//fin for es Imagen
        }//Fin for

        return imagenesVector;
    } //Fin metodo vectorizar con Average Color

    @Override
    public Imagen vectorizarImagen(String pathImagen) throws Exception {

        Imagen imagenVector = null;
        //imagen = null;
        int x, y, width, height;
        roi = null;
        imagen = JAI.create("fileload", pathImagen);
        int bandasImagen = imagen.getNumBands();
        double[][] resultado = new double[segmentosPermitidos * segmentosPermitidos][bandasImagen];

        System.out.println("Ancho Imagen " + imagen.getWidth() + " Altura Imagen " + imagen.getHeight());
        int anchoSegmento = imagen.getWidth() / segmentosPermitidos;
        int altoSegmento = imagen.getHeight() / segmentosPermitidos;

        for (int j = 0; j < segmentosPermitidos; j++) {

            y = j * altoSegmento;
            if (j != (segmentosPermitidos - 1)) {

                height = altoSegmento;
            } else {

                height = imagen.getHeight() - (j) * altoSegmento;
            }

            for (int i = 0; i < segmentosPermitidos; i++) {

                x = i * anchoSegmento;
                System.out.println("**************************************************");
                System.out.println("rectangulo numero " + ((i + (segmentosPermitidos * j)) + 1));
                System.out.println("posision de x = " + x);
                System.out.println("posision de y = " + y);

                if (i != (segmentosPermitidos - 1)) {

                    width = anchoSegmento;
                } else {

                    width = imagen.getWidth() - (i * anchoSegmento);
                }

                System.out.println("ancho del segmento = " + width);
                System.out.println("alto del segmento = " + height);

                //Crear el rectangulo y calgular la media
                roi = new ROIShape(new Rectangle(x, y, anchoSegmento, altoSegmento));

                pb = new ParameterBlock();
                pb.addSource(imagen); // The source image
                pb.add(roi); // null ROI means whole image
                pb.add(1); // check every pixel horizontally
                pb.add(1); // check every pixel vertically

                //Retrieve and report the mean pixel value.
                double[] media = (double[]) (JAI.create("mean", pb, null).getProperty("mean"));
                System.out.println("largo de la media " + media.length);

                for (int k = 0; k < bandasImagen; k++) {

                    System.out.println("valor de la media[" + k + "] =" + media[k]);
                }
                //	agregar la media al arreglo resultado

                for (int l = 0; l < imagen.getNumBands(); l++) {

                    resultado[(i + (segmentosPermitidos * j))][l] = media[l];
                }

                System.out.println("**************************************************");
            }
        }//Fin for Segmentos

        imagenVector = new Color(almacenarVectoresAverageColor(resultado), pathImagen);

        return imagenVector;
    }//Fin metodo

    private ArrayList<Double> almacenarVectoresAverageColor(double[][] resultado) {

        ArrayList<Double> arrayVectores = new ArrayList<Double>();
        int cont = 0;
        int largo = resultado.length;
        int ancho = resultado[0].length;

        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {

                System.out.println("NUM_" + i + "__" + resultado[i][j]);
                arrayVectores.add(resultado[i][j]);
            }
        }

        return arrayVectores;
    }//Fin almacenar AverageColor

    private boolean verificarEsImagen(String dirImagen) {

        if (dirImagen.endsWith(".jpg") || dirImagen.endsWith(".JPG")) {
            return true;
        } else {
            return false;
        }
    }//Fin verificar Si es Imagen
}
