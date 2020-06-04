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


    public int getLugares() {
        return lugares;
    }

    public int cantFamilias() {
        return this.invitados.size();
    }

    public boolean addFamilia(Familia fam) {
        if (this.lugares - fam.getMiembros() >= 0) {
            this.invitados.add(fam);
            return true;
        }
        else
            return false;
    }

    public int getDia() {
        return dia;
    }

    @Override
    public Iterator<Familia> iterator() {
        return this.invitados.iterator();
    }
}
