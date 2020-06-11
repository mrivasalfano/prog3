import ej1.CaminoLargo;
import ej1.GrafoDirigido;
import ej1.Tarea;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //contenedor de tareas
        HashMap<Integer, Tarea> tareas = new HashMap<>();

        //tareas
        Tarea t0 = new Tarea("Tarea 0", "inicio", 0);
        Tarea t1 = new Tarea("Tarea 1", "Lavar",4);
        Tarea t2 = new Tarea("Tarea 2", "Cocinar", 18);
        Tarea t3 = new Tarea("Tarea 3", "Limpiar",4);
        Tarea t4 = new Tarea("Tarea 4", "Correr",13);
        Tarea t5 = new Tarea("Tarea 5", "Dormir",22);
        Tarea t6 = new Tarea("Tarea 6", "Compras",18);
        Tarea t7 = new Tarea("Tarea 7", "Paseo",12);
        Tarea t8 = new Tarea("Tarea 8", "Estudiar",3);
        Tarea t9 = new Tarea("Tarea 9", "Visitar",2);
        Tarea t10 = new Tarea("Tarea 10", "Leer",3);
        Tarea t11 = new Tarea("Tarea 11", "Resumir",1);
        Tarea t12 = new Tarea("Tarea 12", "Escribir",5);

        //agrego tareas a su contenedor
        tareas.put(0, t0);
        tareas.put(1, t1);
        tareas.put(2, t2);
        tareas.put(3, t3);
        tareas.put(4, t4);
        tareas.put(5, t5);
        tareas.put(6, t6);
        tareas.put(7, t7);
        tareas.put(8, t8);
        tareas.put(9, t9);
        tareas.put(10, t10);
        tareas.put(11, t11);
        tareas.put(12, t12);

        //creo el grafo y le agrego los vértices
        GrafoDirigido grafo = new GrafoDirigido();
        grafo.addVertice(0);
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addVertice(5);
        grafo.addVertice(6);
        grafo.addVertice(7);
        grafo.addVertice(8);
        grafo.addVertice(9);
        grafo.addVertice(10);
        grafo.addVertice(11);
        grafo.addVertice(12);

        //creo los arcos entre los vértices
        grafo.addArco(0, 1, 0);
        grafo.addArco(0, 2, 0);
        grafo.addArco(1, 3, 3);
        grafo.addArco(2, 7, 18);
        grafo.addArco(2, 5, 1);
        grafo.addArco(3, 4, 5);
        grafo.addArco(3, 6, 8);
        grafo.addArco(7, 8, 7);
        grafo.addArco(5, 6, 2);
        grafo.addArco(8, 9, 4);
        grafo.addArco(4, 11, 3);
        grafo.addArco(9, 10, 1);
        grafo.addArco(11, 12, 9);
        grafo.addArco(6, 12, 2);
        grafo.addArco(6, 10, 6);

        System.out.println("Backtraking para encontrar el camino más largo hacia tarea 12: ");
        CaminoLargo problema = new CaminoLargo(grafo, tareas);
        LinkedList<Integer> resultado = problema.getCaminoLargo(12);

        System.out.print("   ");

        for (Integer i : resultado) {
            System.out.print("[" + tareas.get(i).getName() + "] ");
        }
    }
}
