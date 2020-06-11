package ej2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class Main implements Comparator<Objeto> {
    public static void main(String[] args) {
        LinkedList<Objeto> objetos = new LinkedList<>();
        objetos.add(new Objeto("Pan", 200, 2));
        objetos.add(new Objeto("Plata", 10000, 5));
        objetos.add(new Objeto("Yerba", 1000, 3));

        HashMap<Objeto, Float> resultado = greedy(objetos, 0.8f);

        System.out.println("Tengo una mochila que soporta 10 kilos y la puedo llenar con los siguientes objetos para obtener el valor máximo: ");

        resultado.forEach((obj, porcentaje) -> {
            System.out.println("   Del objeto " + obj.getNombre() + " que pesa " + obj.getPeso() + "kg usé el " + porcentaje*100 + "%");
        });
    }

    public static HashMap<Objeto, Float> greedy(LinkedList<Objeto> objetos, float pesoMax) {
        HashMap<Objeto, Float> seleccionados = new HashMap<>();
        float resto = pesoMax;
        Collections.sort(objetos, Collections.reverseOrder());

        while (!objetos.isEmpty() && !solucion(seleccionados, pesoMax)) {
            Objeto x = seleccionar(objetos);
            objetos.remove(0);

            if (factible(resto)) {
                float peso = x.getPeso();
                float porcentaje = 0;

                if (peso < resto)
                    porcentaje = 1;
                else
                    porcentaje = resto / peso;

                resto -= (porcentaje * peso);
                seleccionados.put(x, porcentaje);
            }
        }

        return seleccionados;
    }

    private static boolean factible(float resto) {
        return resto > 0;
    }

    private static Objeto seleccionar(LinkedList<Objeto> objetos) {
        return objetos.getFirst();
    }

    private static boolean solucion(HashMap<Objeto, Float> seleccionados, float resto) {
        AtomicReference<Float> suma = new AtomicReference<>((float) 0);

        seleccionados.forEach((obj, cant) -> {
            suma.updateAndGet(v -> new Float((float) (v + obj.getPeso() * cant)));
        });

        return suma.get() == resto;
    }

    @Override
    public int compare(Objeto o1, Objeto o2) {
        return 0;
    }
}
