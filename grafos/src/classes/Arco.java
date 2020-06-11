package classes;

import java.util.Iterator;

public class Arco<T> {
    //puede variar el tipo
    private T etiqueta;
    private int v1;
    private int v2;

    public Arco(int v1, int v2, T etiqueta) {
        this.v1 = v1;
        this.v2 = v2;
        this.etiqueta = etiqueta;
    }

    public Arco(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.etiqueta = null;
    }

    public int getDestino() {
        return v2;
    }
}
