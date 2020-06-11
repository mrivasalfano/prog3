package ej4.classes;
import java.util.LinkedList;
import java.util.Iterator;


public class Vertice implements Iterable<Arco>{
    private LinkedList<Arco> arcos;
    private int status;
    private int id;
    private int i;
    private int f;

    public Vertice(int idObject) {
        this.arcos = new LinkedList<>();
        this.id = idObject;
    }

    public int getId() {
        return id;
    }

    public void addArco(Arco a) {
        if (!this.arcos.contains(a))
            this.arcos.add(a);
    }

    public void deleteArco(int id2) {
        Iterator<Arco> it = this.arcos.iterator();
        boolean sigo = true;

        while(sigo && it.hasNext()) {
            Arco arcoTmp = it.next();

            if (arcoTmp.getDestino() == id2) {
                this.arcos.remove(arcoTmp);
                sigo = false;
            }
        }
    }

    public boolean hasArco(int id2) {
        Iterator<Arco> it = this.arcos.iterator();

        while(it.hasNext()) {
            Arco arcoTmp = it.next();

            if (arcoTmp.getDestino() == id2) {
                return true;
            }
        }

        return false;
    }

    public void setStatus(int s) {
        this.status = s;
    }

    public int getStatus() {
        return status;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setI(int i) {
        this.i = i;
    }

    public LinkedList<Arco> getArcos() {
        return this.arcos;
    }

    @Override
    public Iterator<Arco> iterator() {
        return this.arcos.iterator();
    }

    public int cantidadArcos() {
        return this.arcos.size();
    }
}
