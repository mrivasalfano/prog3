package ej3;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int num = 15;
        int[] conjunto = {3,7,5,8,2,1,4};

        System.out.print("Encontrar los subconjuntos que sumen " + num + " teniendo en cuenta el conjunto: ");

        for (int i = 0; i < conjunto.length; i++) {
            System.out.print("[" + conjunto[i] + "]");
        }

        Backtraking backtraking = new Backtraking();
        LinkedList<LinkedList<Integer>> soluciones = backtraking.resolve(num, conjunto);

        System.out.println("");
        System.out.println("Soluciones:");

        for (LinkedList<Integer> sol : soluciones) {
            System.out.println("   ");

            for (Integer val : sol) {
                System.out.print("[" + val + "]");
            }
        }
    }
}
