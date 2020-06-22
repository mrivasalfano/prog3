package entregable;

import java.util.LinkedList;

public class Visita {
    private int dia;
    private int lugares;
    private LinkedList<Familia> familias;

    public Visita(int dia, int lugares) {
        this.dia = dia;
        this.lugares = lugares;
        this.familias = new LinkedList<>();
    }

    public int getLugares() {
        return lugares;
    }

    public int getDia() {
        return dia;
    }

    public boolean addFamilia(Familia fam) {
        if((this.lugares - fam.miembros()) >= 0) {
            this.familias.add(fam);
            this.lugares -= fam.miembros();
            return true;
        }

        return false;
    }

    public Visita clone() {
        Visita vis = new Visita(this.dia, this.lugares);
        vis.addFamilias(this.familias);
        return vis;
    }

    public void addFamilias(LinkedList<Familia> familias) {
        this.familias.addAll(familias);
    }

    public void removeFamilia() {
        this.lugares += this.familias.getLast().miembros();
        this.familias.removeLast();
    }
}
