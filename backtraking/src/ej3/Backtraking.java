package ej3;

import java.util.LinkedList;

public class Backtraking {
    private int num;
    private int[] conjunto;
    private LinkedList<LinkedList<Integer>> soluciones;

    public Backtraking() {
        this.soluciones = new LinkedList<>();
    }

    public LinkedList<LinkedList<Integer>> resolve(int num, int[] conjunto) {
        this.soluciones.clear();
        this.num = num;
        this.conjunto = conjunto;
        LinkedList<Integer> vacio = new LinkedList<>();
        this.backtracking(0, vacio);
        return this.soluciones;
    }

    //idea: ir sumando mientras armo el camino y pasarlo por parámetro
    //preguntar si es mejora o no
    //respuesta: sí porque podemos podar preguntando si ya me pase del numero
    
    private void backtracking(int indice, LinkedList<Integer> caminoActual) {
        //termino cuando recorrí todos los candidatos
        if (indice == this.conjunto.length) {
            //si elejí al menos uno y su suma es igual al número lo agrego como solución
            if (suma(caminoActual) == this.num) {
                LinkedList<Integer> aux = new LinkedList<>(caminoActual);
                this.soluciones.add(aux);
            }
        }
        else {
            //elijo agregar el número y hago backtracking
            caminoActual.add(this.conjunto[indice]);
            this.backtracking((indice+1), caminoActual);

            //remuevo el número que había agregado y pruebo sin agregarlo
            caminoActual.removeLast();
            this.backtracking((indice+1), caminoActual);

        }
    }

    private int suma(LinkedList<Integer> caminoActual) {
        int sum = 0;

        for (Integer val : caminoActual) {
            sum += val;
        }

        return sum;
    }
}


