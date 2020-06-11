package ejEntregable;
import classes.MySimpleLinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList lista = new MySimpleLinkedList();
        //NOTA: LO INSERTO AL REVES YA QUE LA LISTA INSERTA AL PRINCIPIO Y ME LO DA VUELTA
        lista.insertFront(28);
        lista.insertFront(14);
        lista.insertFront(19);
        lista.insertFront(7);
        lista.insertFront(2);
        lista.insertFront(2);
        lista.insertFront(5);
        lista.insertFront(3);
        System.out.println("--- Creo una lista con los siguientes valores: [3, 5, 2, 2, 7, 19, 14, 28]");
        System.out.println("--- Llamo al método que busca las subsecuencias e imprimo el resultado:");
        ArrayList<MySimpleLinkedList> result = lista.getSubSecuencias(lista);

        int contador = 1;
        for (MySimpleLinkedList list : result) {
            System.out.print("   Sub-secuencia número " + contador + ": ");
            for (Integer num : list) {
                System.out.print("[" + num + "]");
            }
            System.out.println("");
            contador++;
        }
    }
}