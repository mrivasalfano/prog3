package ej1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CaminoLargo {
    private GrafoDirigido grafo;
    private HashMap<Integer, Tarea> tareas;

    public CaminoLargo(GrafoDirigido grafo, HashMap<Integer, Tarea> tareas) {
        this.grafo = grafo;
        this.tareas = tareas;
    }

    public LinkedList<Integer> getCaminoLargo(int destino) {
        return this.getCaminoLargo(0, destino);
    }

    private LinkedList<Integer> getCaminoLargo(int actual, int destino) {
        LinkedList<Integer> camino = new LinkedList<>();
        Iterator<Arco> arcos = this.grafo.obtenerArcos(actual);

        //si llegué al destino lo agrego y devuelvo
        if (actual == destino) {
            camino.add(actual);
        }
        else {
            //mientras no sea hoja
            while(arcos.hasNext()) {
                Arco arc = arcos.next();

                if (arc.getDestino() != destino) {
                    LinkedList<Integer> tmp = this.getCaminoLargo(arc.getDestino(), destino);

                    if (tmp.size() > camino.size()) {
                        camino = tmp;
                        camino.addFirst(actual);
                    }

                }
                else {
                    camino.add(actual);
                    camino.add(destino);
                }
            }
        }
        return camino;
    }
}
