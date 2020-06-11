package ej1;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> monedas = new LinkedList<>();
        monedas.add(50);
        monedas.add(100);
        monedas.add(10);
        monedas.add(20);
        monedas.add(5);
        int pago = 275;

        LinkedList<Integer> billetes = greedy(monedas, pago);

        System.out.println("Para pagar " + pago + " pesos necesita los siguientes billetes: ");

        if (!billetes.isEmpty()) {
            for (Integer i : billetes) {
                System.out.print("   [" + i + "]");
            }
        }
        else
            System.out.print("   No hay cambio para ese monto.");
    }

    //asume que las monedas están ordenadas descendente
    public static LinkedList<Integer> greedy(LinkedList<Integer> monedas, int pago) {
        LinkedList<Integer> seleccionados = new LinkedList<>();
        int resto = pago;
        
        Collections.sort(monedas);
        Collections.reverse(monedas);

        while (!monedas.isEmpty() && !solucion(seleccionados, pago)) {
            Integer x = seleccionar(monedas);
            monedas.remove(x);

            if (factible(x, resto)) {
                int cant = resto / x;

                for (int i = 0; i < cant; i++) {
                    seleccionados.add(x);
                }

                resto -= x*cant;
            }
        }

        if (solucion(seleccionados, pago))
            return seleccionados;
        else {
            LinkedList<Integer> tmp = new LinkedList<>();
            return tmp;
        }
    }

    private static boolean factible(int x, int resto) {
        return x <= resto;
    }

    private static int seleccionar(LinkedList<Integer> monedas) {
        return monedas.getFirst();
    }

    private static boolean solucion(LinkedList<Integer> seleccionados, int pago) {
        int suma = 0;

        for (Integer i : seleccionados) {
            suma += i;
        }

        return suma == pago;
    }
}
