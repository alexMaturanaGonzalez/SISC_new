/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.Forma;
import Entidades.Imagen;
import Interfaces.InterfaceVectorizacion;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.jai.iterator.RandomIter;
import javax.media.jai.iterator.RandomIterFactory;

/**
 *
 * @author Alex
 */
public class VectorizarReconocForma implements InterfaceVectorizacion {

    private ProcesarImagen procesarImagen = new ProcesarImagen();
    private static final int baseSize = 300;
    private boolean[] sonImagenes = null;
    private boolean esImagen;

    @Override
    public ArrayList<Imagen> vectorizarListaImagenes(ArrayList<String> listPathImagenes) throws Exception {

        ArrayList<Imagen> imagenesVector = new ArrayList<Imagen>();

        int cantImagenes = listPathImagenes.size();
        sonImagenes = new boolean[cantImagenes];

        for (int i = 0; i < cantImagenes; i++) {

            Color[][] signature = new Color[4][4];
            System.out.println("Imagen " + listPathImagenes.get(i));
            sonImagenes[i] = verificarEsImagen(listPathImagenes.get(i));
            System.out.println("Es imagen: " + sonImagenes[i]);

            if (sonImagenes[i]) {

                //BufferedImage img = ImageIO.read(new File(listPathImagenes.get(i)));
                //BufferedImage reziseImage = getScaledImage(img, 300, 300);

                BufferedImage imageneSinRuido = new ProcesarImagen().reducirRuidoImagen(listPathImagenes.get(i));
                BufferedImage imagenContorno = new ProcesarImagen().extraerContornoImagen(imageneSinRuido);

                signature = calcSignature(imagenContorno);

                imagenesVector.add(new Forma(listPathImagenes.get(i), signature));

                new LiberarMemoria();
            }//Fin condicion Es Imagen

            System.out.println("terminoOoOo");
        }//Fin For

        return imagenesVector;
    }//Fin metodo vectorizarImagenes

    @Override
    public Imagen vectorizarImagen(String pathImagen) throws Exception {

        Imagen imagenVector = new Forma();
        Color[][] signature = new Color[4][4];

        System.out.println("Imagen " + pathImagen);
        esImagen = verificarEsImagen(pathImagen);
        System.out.println("Es imagen: " + esImagen);

        if (esImagen) {

            //BufferedImage img = ImageIO.read(new File(pathImagen));
            //BufferedImage reziseImage = getScaledImage(img, 300, 300);

            BufferedImage imagenSinRuido = new ProcesarImagen().reducirRuidoImagen(pathImagen);
            BufferedImage imagenContorno = new ProcesarImagen().extraerContornoImagen(imagenSinRuido);

            //RenderedImage renderedImage = rescale(imagenContorno);

            signature = calcSignature(imagenContorno);
            System.out.println("Signature > " + signature);

            imagenVector = new Forma(pathImagen, signature);
        }//Fin condicion Es Imagen

        System.out.println("terminoOoOo");

        return imagenVector;
    }//Fin metodo Vectorizar Imagen

    /*
     * This method rescales an image to 300,300 pixels using the JAI scale
     * operator.
     */
    private BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {

        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double) width / imageWidth;
        double scaleY = (double) height / imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        return bilinearScaleOp.filter(
                image, new BufferedImage(width, height, image.getType()));
    }//Fin metodo

    /*
     * This method calculates and returns signature vectors for the input image.
     */
    private Color[][] calcSignature(RenderedImage i) {

        Color[][] sig = new Color[4][4];

        //float[] prop = new float[]{5f / 10f, 9f / 10f};
        float[] prop = new float[]{3f / 10f, 5f / 10f, 7f / 10f, 9f / 10f};
        //float[] prop = new float[]{3f / 10f, 6f / 10f, 9f / 10f};
        //float[] prop = new float[]{1f / 10f, 3f / 10f, 5f / 10f, 7f / 10f, 9f / 10f};
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                sig[x][y] = averageAround(i, prop[x], prop[y]);
                System.out.println("Promedio Color : " + sig[x][y]);
            }
        }
        return sig;
    }//Fin metodo calcular

    private Color averageAround(RenderedImage i, double px, double py) {

        // Get an iterator for the image.
        RandomIter iterator = RandomIterFactory.create(i, null);
        // Get memory for a pixel and for the accumulator.
        double[] pixel = new double[3];
        double[] accum = new double[3];
        // The size of the sampling area.
        //int sampleSize = 30;
        int sampleSize = 20;
        int numPixels = 0;
        // Sample the pixels.
        for (double x = px * baseSize - sampleSize; x < px * baseSize + sampleSize; x++) {
            for (double y = py * baseSize - sampleSize; y < py * baseSize + sampleSize; y++) {

                iterator.getPixel((int) x, (int) y, pixel);
                accum[0] += pixel[0];
                accum[1] += pixel[1];
                accum[2] += pixel[2];
                numPixels++;
            }
        }
        // Average the accumulated values.
        accum[0] /= numPixels;
        accum[1] /= numPixels;
        accum[2] /= numPixels;
        return new Color((int) accum[0], (int) accum[1], (int) accum[2]);
    }//Fin metodo promedio de colores

    private boolean verificarEsImagen(String dirImagen) {

        if (dirImagen.endsWith(".jpg") || dirImagen.endsWith(".JPG")) {
            return true;
        } else {
            return false;
        }
    }//Fin verificar Si es Imagen
}
