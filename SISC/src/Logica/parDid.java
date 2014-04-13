package Logica;

public class parDid implements Comparable {

    double d;
    String ruta;

    public parDid(double _d, String _ruta) {
        d = _d;
        ruta = _ruta;
    }

    public int compareTo(Object o) {
        if (!(o instanceof parDid)) {

            return -1;
        }
        if (d < ((parDid) o).d) {

            return -1;
        }
        if (d > ((parDid) o).d) {

            return 1;
        }
        
        return 0;
    }
}
