package ej2;

public class Objeto implements Comparable<Objeto>{
    private String nombre;
    private float valor;
    private float peso;

    public Objeto (String nombre, int valor, int peso) {
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPeso() {
        return peso;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public int compareTo(Objeto o) {
        return  Math.round((this.valor / this.peso) - (o.getValor() / o.getPeso()));
    }
}
