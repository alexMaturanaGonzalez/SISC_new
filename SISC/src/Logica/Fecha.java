package Logica;

import java.util.*;

public class Fecha {

    private Date actual = new Date();
    private StringTokenizer parametros;
    private String dia;
    private String mes;
    private String fecha;
    private String hora;
    private String gmt;
    private String año;
    private int H;  //  Hora
    private int M;  //  Minuto
    private int S;  //  Segundos
    private String fechaCompleta;

    public Fecha() {
        parametros = new StringTokenizer("" + actual);
        dia = parametros.nextToken();
        mes = parametros.nextToken();
        fecha = parametros.nextToken();
        hora = parametros.nextToken();
        gmt = parametros.nextToken();
        año = parametros.nextToken();
        if (dia.equals("Mon")) {
            dia = "Lunes";
        } else if (dia.equals("Tue")) {
            dia = "Martes";
        } else if (dia.equals("Wed")) {
            dia = "Miércoles";
        } else if (dia.equals("Thu")) {
            dia = "Jueves";
        } else if (dia.equals("Fri")) {
            dia = "Viernes";
        } else if (dia.equals("Sat")) {
            dia = "Sábado";
        } else {
            dia = "Domingo";
        }
        obtenerHora();

    }

    public Fecha(Date nueva) {
        this.parametros = new StringTokenizer("" + actual);
        dia = parametros.nextToken();
        mes = parametros.nextToken();
        fecha = parametros.nextToken();
        hora = parametros.nextToken();
        gmt = parametros.nextToken();
        año = parametros.nextToken();
        if (dia.equals("Mon")) {
            dia = "Lunes";
        } else if (dia.equals("Tue")) {
            dia = "Martes";
        } else if (dia.equals("Wed")) {
            dia = "Miércoles";
        } else if (dia.equals("Thu")) {
            dia = "Jueves";
        } else if (dia.equals("Fri")) {
            dia = "Viernes";
        } else if (dia.equals("Sat")) {
            dia = "Sábado";
        } else {
            dia = "Domingo";
        }

        obtenerHora();

    }

    public String obtenerFechaCompleta() {
        fechaCompleta = dia + ", " + fecha + " de " + mes + " de " + año;
        return fechaCompleta;
    }

    //  Método para obtener la fecha reducida:
    public String obtenerFecha(String X, String Y, String Z) {
        X = X.toUpperCase();
        Y = Y.toUpperCase();
        Z = Z.toUpperCase();

        if (X.equals("D") && Y.equals("M") && Z.equals("A")) {
            //  dd-mm-aaaa
            return (fecha + "-" + mes + "-" + año);
        } else if (X.equals("A") && Y.equals("D") && Z.equals("M")) {
            //   aaaa-dd-mm
            return (año + "-" + fecha + "-" + mes);
        } else if (X.equals("A") && Y.equals("M") && Z.equals("D")) {
            //   aaaa-mm-dd
            return (año + "-" + mes + "-" + fecha);
        } else if (X.equals("D") && Y.equals("A") && Z.equals("M")) {
            //  dd-aaaa-mm
            return (fecha + "-" + año + "-" + mes);
        } else if (X.equals("M") && Y.equals("D") && Z.equals("A")) {
            //   mm-dd-aaaa
            return (mes + "-" + fecha + "-" + año);
        } else {																		//  mm-aaaa-dd
            return (mes + "-" + año + "-" + fecha);
        }
    }

    //  Método para obtener el día:
    public String obtenerDia() {
        return dia;
    }

    //  Método para obtener los parámetros de la hora:
    public void obtenerHora() {
        StringBuffer Hora = new StringBuffer(hora);
        char decenaHora = Hora.charAt(0);
        char unidadHora = Hora.charAt(1);
        char decenaMin = Hora.charAt(3);
        char unidadMin = Hora.charAt(4);
        char decenaSeg = Hora.charAt(6);
        char unidadSeg = Hora.charAt(7);

        H = (Integer.parseInt("" + decenaHora) * 10) + (Integer.parseInt(
                "" + unidadHora));
        M = (Integer.parseInt("" + decenaMin) * 10) + (Integer.parseInt(
                "" + unidadMin));
        S = (Integer.parseInt("" + decenaSeg) * 10) + (Integer.parseInt(
                "" + unidadSeg));

    }

    //  Métodos para retornar la hora:
    public String verHoraTotal() {

        if (H < 10 && M < 10 && S < 10) {
            return ("0" + H + ":" + "0" + M + ":" + "0" + S);
        } else if (H < 10 && M < 10 && S > 10) {
            return ("0" + H + ":" + "0" + M + ":" + S);
        } else if (H < 10 && M > 10 && S > 10) {
            return ("0" + H + ":" + M + ":" + S);
        } else if (H > 10 && M > 10 && S < 10) {
            return (H + ":" + M + ":" + "0" + S);
        } else if (H < 10 && M > 10 && S < 10) {
            return ("0" + H + ":" + M + ":" + "0" + S);
        } else if (H > 10 && M < 10 && S < 10) {
            return (H + ":" + M + ":" + "0" + S);
        } else if (H > 10 && M < 10 && S > 10) {
            return (H + ":" + "0" + M + ":" + S);
        } else {
            return (H + ":" + M + ":" + S);
        }
    }

    public String verHora() {
        return (H + ":" + M);
    }
}
