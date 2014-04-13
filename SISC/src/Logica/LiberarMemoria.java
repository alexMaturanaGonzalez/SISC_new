/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Alex
 */
public class LiberarMemoria {

    public LiberarMemoria() {

        Runtime garbage = Runtime.getRuntime();
        garbage.gc();
        System.out.println("Memoria Liberada!");
    }
}
