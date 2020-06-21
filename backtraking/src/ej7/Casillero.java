package ej7;

public class Casillero {
    private int fil;
    private int col;
    private int valor;

    public Casillero(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }

    public void setValor(int x) {
        this.valor = x;
    }

    public int getValor() {
        return this.valor;
    }

    public int getFil() {
        return this.fil;
    }

    public int getCol() {
        return this.col;
    }


}
