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
public interface InterfaceVectorizacion {

    public ArrayList<Imagen> vectorizarListaImagenes(ArrayList<String> listPathImagenes) throws Exception;

    public Imagen vectorizarImagen(String pathImagen) throws Exception;
}
