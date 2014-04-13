/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class RutaFavorita implements Serializable {

    private String id;
    private String nombre;
    private ArrayList<String> rutas;
    private int cantImagenes;
    private String fechaCreacion;

    public RutaFavorita(String id, String nombre, ArrayList<String> rutas, int cantImagenes, String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.rutas = rutas;
        this.cantImagenes = cantImagenes;
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantImagenes() {
        return cantImagenes;
    }

    public void setCantImagenes(int cantImagenes) {
        this.cantImagenes = cantImagenes;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<String> rutas) {
        this.rutas = rutas;
    }
}
