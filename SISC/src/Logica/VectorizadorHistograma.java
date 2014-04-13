/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.Color;
import Interfaces.InterfaceVectorizacion;
import Entidades.Imagen;
import java.awt.image.renderable.ParameterBlock;
import java.util.ArrayList;
import javax.media.jai.Histogram;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Alex
 */
public class VectorizadorHistograma implements InterfaceVectorizacion {

    private static int numeroBandasPermitido = 3;
    private static int numeroBinsPermitidos = 32;
    private PlanarImage imagen = null;
    private ParameterBlock pb = null;
    private int numeroBandas = 0;
    private int[] numeroBins = null;
    private double[] minimo = null;
    private double[] maximo = null;
    private int bitsBanda = 0;
    private Histogram histograma = null;
    private boolean[] sonImagenes = null;

    @Override
    public ArrayList<Imagen> vectorizarListaImagenes(ArrayList<String> listPathImagenes) throws Exception {

        ArrayList<Imagen> imagenesVector = new ArrayList<Imagen>();

        sonImagenes = new boolean[listPathImagenes.size()];

        for (int i = 0; i < listPathImagenes.size(); i++) {

            System.out.println("Imagen " + listPathImagenes.get(i));
            sonImagenes[i] = verificarEsImagen(listPathImagenes.get(i));
            System.out.println("Es imagen: " + sonImagenes[i]);

            if (sonImagenes[i]) {

                imagen = JAI.create("fileload", listPathImagenes.get(i));
                numeroBandas = imagen.getNumBands();
                System.out.println("Numero de Bandas: " + numeroBandas);

                if (numeroBandas == numeroBandasPermitido) {

                    bitsBanda = imagen.getColorModel().getComponentSize(0);
                    numeroBins = new int[numeroBandas];
                    minimo = new double[numeroBandas];
                    maximo = new double[numeroBandas];

                    for (int j = 0; j < numeroBandas; j++) {

                        numeroBins[j] = numeroBinsPermitidos;
                        minimo[j] = 0.0;
                        maximo[j] = Math.pow(2, bitsBanda);
                    }//Fin for numeroBandas
                } else {

                    System.out.println("Numero de bandas no permitido!");
                    return null;
                }

                pb = new ParameterBlock();
                pb.addSource(imagen);
                pb.add(null);
                pb.add(1);
                pb.add(1);
                pb.add(numeroBins);
                pb.add(minimo);
                pb.add(maximo);
                histograma = (Histogram) (((PlanarImage) JAI.create("histogram", pb, null)).getProperty("histogram"));

                System.out.println("Muesta Bins del histograma almacenado!!!");
                for (int j = 0; j < histograma.getNumBins(0); j++) {
                    /*System.out.println("Bin[" + j + "] "
                    + (histograma.getBins(0))[j] + " "
                    + (histograma.getBins(1))[j] + " "
                    + (histograma.getBins(2))[j] + " ");*/
                }

                imagenesVector.add(new Color(almacenarVectoresHistograma(histograma, listPathImagenes.get(i)), listPathImagenes.get(i)));

                new LiberarMemoria();
            }//Se sabe que es de una extensión permitida
            System.out.println("terminoOoOo");
        }//Inspeccionar extensión de Imagenes

        return imagenesVector;
    }//Fin metodo Vectorizar Lista Imagenes

    @Override
    public Imagen vectorizarImagen(String pathImagen) throws Exception {

        Imagen imagenVector = new Imagen();
        Color colorImagenVector = new Color();

        System.out.println("Imagen " + pathImagen);
        boolean esImagen = verificarEsImagen(pathImagen);
        System.out.println("Es imagen: " + esImagen);

        if (esImagen) {

            imagen = JAI.create("fileload", pathImagen);
            numeroBandas = imagen.getNumBands();
            System.out.println("Numero de Bandas: " + numeroBandas);

            if (numeroBandas == numeroBandasPermitido) {

                bitsBanda = imagen.getColorModel().getComponentSize(0);
                numeroBins = new int[numeroBandas];
                minimo = new double[numeroBandas];
                maximo = new double[numeroBandas];

                for (int j = 0; j < numeroBandas; j++) {

                    numeroBins[j] = numeroBinsPermitidos;
                    minimo[j] = 0.0;
                    maximo[j] = Math.pow(2, bitsBanda);
                }//Fin for numeroBandas
            } else {

                System.out.println("Numero de bandas no permitido!");
                return null;
            }

            pb = new ParameterBlock();
            pb.addSource(imagen);
            pb.add(null);
            pb.add(1);
            pb.add(1);
            pb.add(numeroBins);
            pb.add(minimo);
            pb.add(maximo);
            histograma = (Histogram) (((PlanarImage) JAI.create("histogram", pb, null)).getProperty("histogram"));

            System.out.println("Muesta Bins del histograma almacenado!!!");
            for (int j = 0; j < histograma.getNumBins(0); j++) {
                /*System.out.println("Bin[" + j + "] "
                + (histograma.getBins(0))[j] + " "
                + (histograma.getBins(1))[j] + " "
                + (histograma.getBins(2))[j] + " ");*/
            }

            colorImagenVector = new Color(almacenarVectoresHistograma(histograma, pathImagen), pathImagen);
            imagenVector = colorImagenVector;
        }//Se sabe que es de una extensión permitida

        return imagenVector;
    }//Fin metodo

    private boolean verificarEsImagen(String dirImagen) {

        if (dirImagen.endsWith(".jpg") || dirImagen.endsWith(".JPG")) {
            return true;
        } else {
            return false;
        }
    }//Fin verificar Si es Imagen

    private ArrayList<Double> almacenarVectoresHistograma(Histogram histograma, String rutaImagen) {

        ArrayList<Double> arrayVectores = new ArrayList<Double>();

        try {
            int max = 0;
            for (int i = 0; i < histograma.getNumBins(0); i++) {
                for (int j = 0; j < histograma.getNumBands(); j++) {
                    if ((histograma.getBins(j)[i]) > max) {

                        max = (histograma.getBins(j))[i];
                    }
                }
            }

            for (int i = 0; i < histograma.getNumBins(0); i++) {
                for (int j = 0; j < histograma.getNumBands(); j++) {

                    System.out.println("num" + " - " + (double) (histograma.getBins(j)[i]) / max);
                    arrayVectores.add((double) (histograma.getBins(j)[i]) / max);
                }
            }
        } catch (Exception e) {

            System.err.println("Error!!!");
            return null;
        }

        return arrayVectores;
    }//Fin almacenar Histograma
}
