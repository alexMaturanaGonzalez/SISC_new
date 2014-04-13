/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Comparator;

/**
 *
 * @author Alex
 */
public class Imagen implements Comparator<Imagen>{

    private String nombre;
    private String ruta;
    private double distancia;
    private String dimensiones;
    private long tamano;
    private String formato;
    private String fechaModif;
    private String descrip;
    private boolean check;

    public Imagen() {
    }

    public Imagen(String nombre, String ruta, String dimensiones, long tamano, String formato, String fechaModif, String descrip, Boolean check) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.dimensiones = dimensiones;
        this.tamano = tamano;
        this.formato = formato;
        this.fechaModif = fechaModif;
        this.descrip = descrip;
        this.check = check;
    }

    public Imagen(String nombre, String ruta, Double distancia, String dimensiones, long tamano, String formato, String fechaModif, String descrip, Boolean check) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.distancia = distancia;
        this.dimensiones = dimensiones;
        this.tamano = tamano;
        this.formato = formato;
        this.fechaModif = fechaModif;
        this.descrip = descrip;
        this.check = check;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(String fechaModif) {
        this.fechaModif = fechaModif;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public long getTamano() {
        return tamano;
    }

    public void setTamano(long tamano) {
        this.tamano = tamano;
    }

    public int compareTo(Object other) {

        Double distanc_1 = ((Imagen) other).getDistancia();
        Double distanc_2 = this.getDistancia();

        if (distanc_1 < distanc_2) {

            return -1;
        } else if (distanc_1.equals(distanc_2)) {

            return 0;
        } else {

            return 1;
        }
    }//Fin metodo comparable

    public int compare(Imagen o1, Imagen o2) {

        return o1.getDistancia().compareTo(o2.getDistancia());
    }
}
