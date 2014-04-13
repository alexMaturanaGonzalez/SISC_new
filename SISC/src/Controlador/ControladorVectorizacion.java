/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Interfaces.InterfaceVectorizacion;
import Logica.VectorizadorAverageColor;
import Logica.VectorizadorHistograma;
import Logica.VectorizarReconocForma;

/**
 *
 * @author Alex
 */
public class ControladorVectorizacion {

    public InterfaceVectorizacion getVectorHistograma(){
        return new VectorizadorHistograma();
    }

    public InterfaceVectorizacion getVectorAverageColor(){
        return new VectorizadorAverageColor();
    }

    public InterfaceVectorizacion getVectorRecocForma(){
        return new VectorizarReconocForma();
    }

}
