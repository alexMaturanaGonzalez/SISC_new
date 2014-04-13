/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Color extends Imagen {

    private ArrayList<Double> vectores;

    public Color() {
    }

    @SuppressWarnings("static-access")
    public Color(ArrayList<Double> vectores, String ruta) {
        this.vectores = vectores;
        //this.ruta = ruta;
        System.out.println("Ruta ruta Ruta ryta " + ruta);
        setRuta(ruta);
    }

    public ArrayList<Double> getVectores() {
        return vectores;
    }

    public void setVectores(ArrayList<Double> vectores) {
        this.vectores = vectores;
    }
}
