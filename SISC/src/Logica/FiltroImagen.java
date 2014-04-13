package Logica;

import java.awt.Color;
import java.awt.image.BufferedImage;

/*
 * Fuente: @author Hugo Muñoz García
 */
public class FiltroImagen {

    private BufferedImage imagen;

    public FiltroImagen() {
    }

    public FiltroImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public BufferedImage getImagen_Original() {
        BufferedImage imagen_original = this.imagen;
        return imagen_original;
    }

    public BufferedImage get_Imagen_Mediana() {

        BufferedImage imagen_original = this.imagen;
        BufferedImage imagen_mediana = new BufferedImage(imagen_original.getWidth(), imagen_original.getHeight(), BufferedImage.TYPE_INT_RGB);

        int[][] es_valido = new int[imagen_original.getWidth()][imagen_original.getHeight()];

        for (int i = 0; i < imagen_original.getWidth(); i++) {

            for (int j = 0; j < imagen_original.getHeight(); j++) {

                es_valido[i][j] = 0;

                if (i - 1 >= 0 && j - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (i - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (i - 1 >= 0 && j + 1 < imagen_original.getHeight()) {
                    es_valido[i][j]++;
                }
                if (j - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (j + 1 < imagen_original.getHeight()) {
                    es_valido[i][j]++;
                }
                if (i + 1 < imagen_original.getWidth() && j - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (i + 1 < imagen_original.getWidth()) {
                    es_valido[i][j]++;
                }
                if (i + 1 < imagen_original.getWidth() && j + 1 < imagen_original.getHeight()) {
                    es_valido[i][j]++;
                }
            }
        }
        for (int i = 0; i < imagen_original.getWidth(); i++) {
            for (int j = 0; j < imagen_original.getHeight(); j++) {
                int contador = 0;
                Color[] colores = new Color[es_valido[i][j]];
                Color color_original = new Color(imagen_original.getRGB(i, j));
                int rojo = color_original.getRed();
                int verde = color_original.getGreen();
                int azul = color_original.getBlue();
                if (i - 1 >= 0 && j - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i - 1, j - 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i - 1, j));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i - 1 >= 0 && j + 1 < imagen_original.getHeight()) {
                    Color color_1 = new Color(imagen_original.getRGB(i - 1, j + 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (j - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i, j - 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (j + 1 < imagen_original.getHeight()) {
                    Color color_1 = new Color(imagen_original.getRGB(i, j + 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i + 1 < imagen_original.getWidth() && j - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i + 1, j - 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i + 1 < imagen_original.getWidth()) {
                    Color color_1 = new Color(imagen_original.getRGB(i + 1, j));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i + 1 < imagen_original.getWidth() && j + 1 < imagen_original.getHeight()) {
                    Color color_1 = new Color(imagen_original.getRGB(i + 1, j + 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                colores = getOrdenAcendente(colores);
                //int color=colores[colores.length-1].getRGB();
                int color = colores[colores.length / 2].getRGB();
                Color color_mediana = new Color(color);
                imagen_mediana.setRGB(i, j, color_mediana.getRGB());
            }

        }

        return imagen_mediana;
    }

    public BufferedImage get_Imagen_Media() {

        BufferedImage imagen_original = this.imagen;
        BufferedImage imagen_mediana = new BufferedImage(imagen_original.getWidth(), imagen_original.getHeight(), BufferedImage.TYPE_INT_RGB);

        int[][] es_valido = new int[imagen_original.getWidth()][imagen_original.getHeight()];
        for (int i = 0; i < imagen_original.getWidth(); i++) {
            for (int j = 0; j < imagen_original.getHeight(); j++) {
                es_valido[i][j] = 0;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (i - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (i - 1 >= 0 && j + 1 < imagen_original.getHeight()) {
                    es_valido[i][j]++;
                }
                if (j - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (j + 1 < imagen_original.getHeight()) {
                    es_valido[i][j]++;
                }
                if (i + 1 < imagen_original.getWidth() && j - 1 >= 0) {
                    es_valido[i][j]++;
                }
                if (i + 1 < imagen_original.getWidth()) {
                    es_valido[i][j]++;
                }
                if (i + 1 < imagen_original.getWidth() && j + 1 < imagen_original.getHeight()) {
                    es_valido[i][j]++;
                }
            }
        }
        for (int i = 0; i < imagen_original.getWidth(); i++) {
            for (int j = 0; j < imagen_original.getHeight(); j++) {
                int contador = 0;
                Color[] colores = new Color[es_valido[i][j]];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i - 1, j - 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i - 1, j));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i - 1 >= 0 && j + 1 < imagen_original.getHeight()) {
                    Color color_1 = new Color(imagen_original.getRGB(i - 1, j + 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (j - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i, j - 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (j + 1 < imagen_original.getHeight()) {
                    Color color_1 = new Color(imagen_original.getRGB(i, j + 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i + 1 < imagen_original.getWidth() && j - 1 >= 0) {
                    Color color_1 = new Color(imagen_original.getRGB(i + 1, j - 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i + 1 < imagen_original.getWidth()) {
                    Color color_1 = new Color(imagen_original.getRGB(i + 1, j));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                if (i + 1 < imagen_original.getWidth() && j + 1 < imagen_original.getHeight()) {
                    Color color_1 = new Color(imagen_original.getRGB(i + 1, j + 1));
                    int rojo1 = color_1.getRed();
                    int verde1 = color_1.getGreen();
                    int azul1 = color_1.getBlue();
                    colores[contador] = new Color(rojo1, verde1, azul1);
                    contador++;
                }
                Color color_mediana = getMedia(colores);
                imagen_mediana.setRGB(i, j, color_mediana.getRGB());
            }

        }

        return imagen_mediana;
    }

    public Color getMedia(Color m[]) {

        int rojo = 0;
        int verde = 0;
        int azul = 0;
        for (int i = 0; i < m.length; i++) {
            rojo += m[i].getRed();
            verde += m[i].getGreen();
            azul += m[i].getBlue();
        }
        rojo = rojo / m.length;
        verde = verde / m.length;
        azul = azul / m.length;

        return new Color(rojo, verde, azul);
    }

    public Color[] getOrdenAcendente(Color m[]) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length - 1; j++) {
                int color1 = m[j].getRed() + m[j].getGreen() + m[j].getBlue();
                int color2 = m[j + 1].getRed() + m[j + 1].getGreen() + m[j + 1].getBlue();
                if (color1 > color2) {
                    Color temp = m[j + 1];
                    m[j + 1] = m[j];
                    m[j] = temp;
                }
            }
        }
        return m;
    }
}
