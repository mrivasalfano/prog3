package tp3;

import classes.GrafoDirigido;
import classes.Tarea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Tarea> tareas = new HashMap<>();

        Tarea t1 = new Tarea("Limpiar", 20);
        Tarea t2 = new Tarea("Ordenar", 10);
        Tarea t3 = new Tarea("Lavar", 5);
        Tarea t4 = new Tarea("Secar", 3);
        Tarea t5 = new Tarea("Correr", 60);
        Tarea t6 = new Tarea("Bañarse", 15);
        tareas.put(1, t1);
        tareas.put(2, t2);
        tareas.put(3, t3);
        tareas.put(4, t4);
        tareas.put(5, t5);
        tareas.put(6, t6);

        GrafoDirigido grafoDirigido = new GrafoDirigido();
        grafoDirigido.addVertice(1);
        grafoDirigido.addVertice(2);
        grafoDirigido.addVertice(3);
        grafoDirigido.addVertice(4);
        grafoDirigido.addVertice(5);
        grafoDirigido.addVertice(6);
        grafoDirigido.addArco(1, 2);
        grafoDirigido.addArco(2, 3);
        grafoDirigido.addArco(3, 4);
        grafoDirigido.addArco(5, 6);
        grafoDirigido.addArco(1, 5);
        grafoDirigido.addArco(6, 2);
        System.out.println("Existe la tarea 1?: " + grafoDirigido.hasVertice(1));
        System.out.println("Existe la tarea 2?: " + grafoDirigido.hasVertice(2));
        System.out.println("La tarea 1 conoce a la 2?: " + grafoDirigido.hasArco(1, 2));
        System.out.println("La tarea 2 conoce a la 1?: " + grafoDirigido.hasArco(2, 1));
//        grafoDirigido.borrarArco(1, 2);
        System.out.println("La tarea 1 conoce a la 2 si borro su arco?: " + grafoDirigido.hasArco(1, 2));
//        grafoDirigido.borrarVertice(1);
        System.out.println("La tarea 1 conoce a la 2 si borro la tarea 1?: " + grafoDirigido.hasArco(1, 2));
        System.out.println("---Recorrido DFS: ");
        ArrayList<Integer> idTareasDFS = grafoDirigido.DFS();

        for (Integer id : idTareasDFS) {
            System.out.println("   [" + tareas.get(id).getName() + "]");
        }
        System.out.println();

        System.out.println("---Recorrido BFS: ");
        ArrayList<Integer> idTareasBFS = grafoDirigido.BFS();

        for (Integer id : idTareasBFS) {
            System.out.println("   [" + tareas.get(id).getName() + "]");
        }

        System.out.println("El grafo tiene ciclos?: " + grafoDirigido.hasCiclo());
        LinkedList<Integer> camino = grafoDirigido.getCaminoLargo(1, 2);
        System.out.println("Llamo a getCaminoLargo(1, 6) e imprimo: ");

        for (Integer id : camino) {
            System.out.println("   [" + id + "]");
        }
    }
}
