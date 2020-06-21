package ej7;

import java.util.LinkedList;

public class Main {
    static int k = 10;
    static int s = 15;
    static LinkedList<Integer> numUsados = new LinkedList<>();

    public static void main(String[] args) {
        int n = 3;
        int[][] tablero = new int[n][n];

        int[][] solucion = backtracking(tablero, new Casillero(0, 0));

        if(solucion != null)
            imprimirMatriz(solucion);
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print("[" + matriz[fil][col] + "]");
            }
            System.out.println();
        }
    }

    public static int[][] backtracking(int[][] tablero, Casillero cas) {
        if(estadoFinal(tablero, cas)) {
            if(solucion(tablero, s))
                return tablero;
        }
        else {
            for (int i = 1; i <= k; i++) {
                if(!numUsados.contains(i)) {
//                    cas.setValor(i);
                    tablero[cas.getFil()][cas.getCol()] = i;
                    numUsados.add(i);
                    int[][] result = backtracking(tablero, casSiguiente(tablero, cas));

                    if (result != null)
                        return result;

                    numUsados.removeLast();
//                    cas.setValor(0);
                    tablero[cas.getFil()][cas.getCol()] = 0;
                }
            }
        }

        return null;
    }

    private static Casillero casSiguiente(int[][] tablero, Casillero cas) {
        int fil = cas.getFil();
        int col = cas.getCol();

        if ((col + 1) < tablero.length)
            return new Casillero(fil, col+1);
        else
            return new Casillero(fil+1, 0);
    }

    private static boolean estadoFinal(int[][] tablero, Casillero cas) {
        return (cas.getFil() == tablero.length);
    }

    private static boolean solucion(int[][] matriz, int x) {
        //si la suma de las filas y columnas son
        //iguales a x significa que encontré una solución
        for (int fil = 0; fil < matriz.length; fil++) {
            int sumaFil = 0;
            int sumaCol = 0;

            for (int col = 0; col < matriz[0].length; col++) {
                sumaFil += matriz[fil][col];
                sumaCol += matriz[col][fil];
            }

            if ((sumaFil != x) || (sumaCol != x))
                return false;
        }

        return true;
    }
}
