package ej3;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Activity> activities = new LinkedList<>();
        activities.add(new Activity("Cursar", 8, 12));
        activities.add(new Activity("Desayunar", 9, 10));
        activities.add(new Activity("Entrenar", 14, 16));
        activities.add(new Activity("Cenar", 21, 22));

        System.out.println("Mayor conjunto de actividades consecutivas posibles:");
        LinkedList<Activity> response = greedy(activities);

        for (Activity act : response) {
            System.out.println("   | Nombre: " + act.getResource() + " | Comienzo: " + act.getStart() + " | Fin: " + act.getEnd() + " |");
        }
    }

    public static LinkedList<Activity> greedy(LinkedList<Activity> activities) {
        LinkedList<Activity> seleccionados = new LinkedList<>();
        Collections.sort(activities);

        while (!activities.isEmpty() && !solucion(activities)) {
            Activity x = seleccionar(activities);
            activities.remove(x);

            if (factible(x, seleccionados)) {
                seleccionados.add(x);
            }
        }

        return seleccionados;
    }

    private static boolean factible(Activity x, LinkedList<Activity> seleccionados) {
//        boolean factible = true;
//
//        for (Activity act : seleccionados) {
//            if (x.getStart() < act.getEnd())
//                factible = false;
//        }
//
//        return factible;

        return x.getStart() < seleccionados.getLast().getEnd();
    }

    private static Activity seleccionar(LinkedList<Activity> activities) {
        return activities.getFirst();
    }

    private static boolean solucion(LinkedList<Activity> activities) {
        return activities.isEmpty();
    }
}
