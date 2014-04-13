package Logica;

import Entidades.Color;
import Interfaces.InterfaceDistancia;
import java.util.Arrays;

public class DistanciaDPF implements InterfaceDistancia {

    public static int k;
    public static double f;

    public DistanciaDPF(int _k, double _f) {

        System.out.println("Creando Distancia con DPF...");
        k = _k;
        f = _f;
    }

    public double d(Color imagen1, Color imagen2) {

        if (imagen1.getVectores().size() != imagen2.getVectores().size()) {

            System.err.println("[DistanciaL.d(...)]> Objetos de distinta dimension");
            return -1.0;
        }

        double[] dif = new double[imagen1.getVectores().size()];

        for (int i = 0; i < imagen1.getVectores().size(); i++) {
            dif[i] = diferencia(imagen1.getVectores().get(i),
                    imagen2.getVectores().get(i));
        }

        Arrays.sort(dif);
        int m = (int) ((imagen1.getVectores().size()) * f);
        if (m < 1) {

            m = 1;
        }

        double resultado = 0.0;
        if (k == 1) {
            for (int i = 0; i < m; i++) {
                resultado += dif[i];
            }

        } else if (k == Integer.MAX_VALUE) {
            double resta;

            for (int i = 0; i < m; i++) {
                resta = dif[i];
                if (resta > resultado) {
                    resultado = resta;
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                resultado += Math.pow(Math.pow(dif[i], k), 1.0 / k);
            }
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
