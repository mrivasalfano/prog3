package ej1;

import java.util.Iterator;

public class Arco {
    //puede variar el tipo
    private int etiqueta;
    private int v1;
    private int v2;

    public Arco(int v1, int v2, int etiqueta) {
        this.v1 = v1;
        this.v2 = v2;
        this.etiqueta = etiqueta;
    }

    public Arco(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.etiqueta = 0;
    }

    public int getDestino() {
        return v2;
    }

    public int getEtiqueta() {
        return etiqueta;
    }
}
