package ej4;

import ej4.classes.Arco;
import ej4.classes.GrafoDirigido;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();

        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addVertice(5);
        grafo.addVertice(6);

        grafo.addArco(1, 5, 100);
        grafo.addArco(1, 2, 10);
        grafo.addArco(1, 4, 30);
        grafo.addArco(4, 5, 60);
        grafo.addArco(4, 3, 20);
        grafo.addArco(3, 5, 10);
        grafo.addArco(2, 3, 50);

        LinkedList<HashMap<Integer, Integer>> response = dijkstra(grafo, 1);

        System.out.println(response.toString());
    }

    public static LinkedList<HashMap<Integer, Integer>> dijkstra(GrafoDirigido grafo, int origen) {
        Iterator<Integer> vertices = grafo.obtenerVertices();

        HashMap<Integer, Integer> dist = new HashMap<>();
        HashMap<Integer, Integer> padre = new HashMap<>();

        LinkedList<Integer> visitados = new LinkedList<>();
        int graphSize = grafo.cantidadVertices();

        while (vertices.hasNext()) {
            Integer siguiente = vertices.next();

            dist.put(siguiente, null);
            padre.put(siguiente, null);
        }

        dist.put(origen, 0);

        while (visitados.size() < graphSize) {
            AtomicInteger seleccionado = new AtomicInteger(-1);
            AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);

            dist.forEach((destino, distancia) -> {
                if ((distancia != null) && (distancia < min.get()) && (!visitados.contains(destino))) {
                    seleccionado.set(destino);
                    min.set(distancia);
                }
            });

            if (seleccionado.get() != -1) {
                visitados.add(seleccionado.get());

                Iterator<Arco> arcos = grafo.obtenerArcos(seleccionado.get());

                while (arcos.hasNext()) {
                    Arco a = arcos.next();
                    int v = a.getDestino();

                    if (!visitados.contains(v)) {
                        int suma = (dist.get(seleccionado.get()) + a.getEtiqueta());

                        if ((dist.get(v) == null) || (suma < dist.get(v))) {
                            dist.put(v, suma);
                            padre.put(v, seleccionado.get());
                        }
                    }
                }
            }
            else {
                break;
            }
        }

        LinkedList<HashMap<Integer, Integer>> result = new LinkedList<>();
        result.add(dist);
        result.add(padre);

        return result;
    }
}
