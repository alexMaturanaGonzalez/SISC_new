/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Imagen;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public interface InterfaceBuscador {

    public ArrayList<Imagen> busqueda(ArrayList<String> listPathImagenes, String fileName, String typeDistance, String distanceValue, double num, int numResult, boolean  aplicarFiltro) throws Exception;
}
