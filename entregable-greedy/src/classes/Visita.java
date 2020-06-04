package classes;

import java.util.Iterator;
import java.util.LinkedList;

public class Visita implements Iterable<Familia>{
    private int dia;
    private int lugares;
    private LinkedList<Familia> invitados;

    public Visita (int dia, int lugares) {
        this.dia = dia;
        this.lugares = lugares;
        this.invitados = new LinkedList<>();
    }

    public boolean aceptaFamilia(Familia fam) {
        return this.lugares - fam.getMiembros() >= 0;
    }

    public int getLugares() {
        return lugares;
    }

    public int cantFamilias() {
        return this.invitados.size();
    }

    public void addFamilia(Familia fam) {
            this.invitados.add(fam);
            this.lugares -= fam.getMiembros();
    }

    public int getDia() {
        return dia;
    }

    @Override
    public Iterator<Familia> iterator() {
        return this.invitados.iterator();
    }
}
