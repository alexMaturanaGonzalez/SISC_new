/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.awt.Color;

/**
 *
 * @author Alex
 */
public class Forma extends Imagen {

    private Color[][] colorPromedio = new Color[4][4];

    public Forma() {
    }

    @SuppressWarnings("static-access")
    public Forma(String ruta, Color[][] colorPromedio) {
        //this.ruta = ruta;
        this.colorPromedio = colorPromedio;
        setRuta(ruta);
    }

    public Color[][] getColorPromedio() {
        return colorPromedio;
    }

    public void setColorPromedio(Color[][] colorPromedio) {
        this.colorPromedio = colorPromedio;
    }
}
