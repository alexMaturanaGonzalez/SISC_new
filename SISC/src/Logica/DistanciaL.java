package Logica;

import Entidades.Color;
import Interfaces.InterfaceDistancia;

public class DistanciaL implements InterfaceDistancia {

    public static double k;

    public DistanciaL(double _k) {
        System.out.println("Creando Distancia con L...");
        k = _k;
    }

    public double d(Color imagen1, Color imagen2) {

        if (imagen1.getVectores().size() != imagen2.getVectores().size()) {
            System.err.println("[DistanciaL.d(...)]> Objetos de distinta dimension");
            return -1.0;
        }

        double resultado = 0.0;

        if (k == 1) {
            for (int i = 0; i < imagen1.getVectores().size(); i++) {
                resultado += diferencia(imagen1.getVectores().get(i),
                        imagen2.getVectores().get(i));
            }
        } else if (k == Integer.MAX_VALUE) {
            double resta;
            for (int i = 0; i < imagen1.getVectores().size(); i++) {
                resta = diferencia(imagen1.getVectores().get(i),
                        imagen2.getVectores().get(i));
                if (resta > resultado) {
                    resultado = resta;
                }
            }
        } else {
            for (int i = 0; i < imagen1.getVectores().size(); i++) {
                resultado += Math.pow(diferencia(imagen1.getVectores().get(i),
                        imagen2.getVectores().get(i)), k);
            }
            resultado = Math.pow(resultado, 1.0 / k);
        }
        return resultado;
    }

    private double diferencia(double f1, double f2) {
        if (f1 > f2) {
            return f1 - f2;
        } else {
            return f2 - f1;
        }
    }

}
