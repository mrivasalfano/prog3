package tp2;
import classes.MySimpleLinkedList;
import classes.Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //---------- EJ 1 ---------------
//        int[] array = {1};
//        System.out.println(estaOrdenado(array, 0));

        //---------- EJ 2 ---------------
        //parte 1
//        MySimpleLinkedList list = new MySimpleLinkedList();
//        list.insertFront(5);
//        list.insertFront(3);
//        list.insertFront(65);
//        list.insertFront(99);
//        System.out.println("Llamo al metodo getRecursivo que devuelve la posición del nodo o '-1' si no se encuentra: " + list.getRecursivo(777, list.getFirstNode(), 0));
        //parte 2
//        int[] array = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(getRecursivo(array, 4));
        
        //---------- EJ 3 ---------------
//        int[] array = {8,4,3,6,9,7,5,1};
//        ordenarSeleccion(array);
//        ordenarBurbujeo(array);
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.print("[" + array[i] + "]");
//        }
        //---------- EJ 4 ---------------


        //---------- EJ 5 ---------------


        //---------- EJ 6 ---------------
        Tree arbol = new Tree();
        arbol.add(11);
        arbol.add(6);
        arbol.add(19);
        arbol.add(17);
        arbol.add(43);
        arbol.add(4);
        arbol.add(8);
        arbol.add(5);
        arbol.add(10);
        arbol.add(31);
        arbol.add(49);
        arbol.add(46);
        arbol.add(48);
        arbol.add(55);
        System.out.print("Imprimo pre order: ");
        arbol.printPreOrder();
        System.out.println();
        System.out.print("Imprimo post order: ");
        arbol.printPostOrder();
        System.out.println();
        System.out.print("Imprimo in order: ");
        arbol.printInOrder();
        System.out.println();
        System.out.println("Llamo a hasElement(1): " + arbol.hasElement(1));
        System.out.print("Borro el 11 e imprimo: ");
        arbol.delete(19);
        arbol.printPreOrder();
        System.out.println();
        System.out.println("Llamo al getHeight(): " + arbol.getHeight());
        System.out.println("Llamo al método getMaxElement(): " + arbol.getMaxElement());
        System.out.print("Llamo al método getFrontera() e imprimo la lista: ");
        ArrayList<Integer> listFrontera = arbol.getFrontera();
        for (int elem : listFrontera) {
            System.out.print("[" + elem + "]");
        }
        System.out.println();
        System.out.print("Llamo al método getElementsAtLevel(0) e imprimo la lista: ");
        ArrayList<Integer> listAtLevel = arbol.getElementsAtLevel(3);
        for (int elem : listAtLevel) {
            System.out.print("[" + elem + "]");
        }
        System.out.println();
        System.out.print("Llamo al método getLongestBranch() e imprimo la lista: ");
        ArrayList<Integer> listLongest = arbol.getLongestBranch();
        for (int elem : listLongest) {
            System.out.print("[" + elem + "]");
        }
        System.out.println();
    }

    private static void ordenarBurbujeo(int[] array) {
        boolean huboCambio = true;
        int j = 0;
        int tmp;

        while (huboCambio) {
            huboCambio = false;
            j++;
            for (int i = 0; i < array.length-j; i++) {
                if (array[i] > array[i+1]) {
                    tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    huboCambio = true;
                }
            }
        }
    }

    private static void ordenarSeleccion(int[] array) {
        int i, j, pos, menor, tmp;

        for (i = 0; i < array.length - 1; i++) {
            pos = i;
            menor = array[i];

            for (j = i + 1; j < array.length; j++) {
                if (array[j] < menor) {
                    menor = array[j];
                    pos = j;
                }
            }
            if (pos != i) {
                tmp = array[i];
                array[i] = array[pos];
                array[pos] = tmp;
            }
        }
    }

    private static int getRecursivo(int[] array, int x) {
        return indexOfRecursivo(array, x, 0, array.length-1);
    }


    //algoritmo ej 2
    private static int indexOfRecursivo(int[] array, int x, int inicioRango, int finRango) {
        //la idea es tener un rango de posicion que empieza en la 0 y en la ultima del arreglo
        // siempre comparo con el arreglo en la posicion media y para eso hago inicio+fin/2

        //mas enroscado pero anda
//        if (inicioRango == finRango) {
//            if (array[inicioRango] == x)
//                return inicioRango;
//            else
//                return -1;
//        }
        if (finRango < inicioRango) {
            return -1;
        }
        else {
            int pos = (inicioRango + finRango) / 2;

            //si el arreglo en la pos es el numero que busco, devuelvo la pos
            if (array[pos] == x)
                return pos;
                //si es mayor, significa que mi numero esta entre el iniio y la pos-1
            else if (array[pos] > x)
                return indexOfRecursivo(array, x, inicioRango, pos - 1);
                //si es menor, mi numero esta entre el fin y la pos +1
            else
                return indexOfRecursivo(array, x, pos + 1, finRango);
        }
    }

    //algoritmo ejercicio 1
    public static boolean estaOrdenado(int[] array, int index) {
        if (index == array.length-1)
            return true;
        else {
            //DE ESTA FORMA PREGUNTO DEL FINAL HACIA EL PRINCIPIO. ES LO PRIMERO QUE SE ME OCURRIÓ PERO ES MENOS EFICIENTE EN LOS CASOS PROMEDIOS
//            boolean ordenado = estaOrdenado(array, index+1);
//
//            if (ordenado) {
//                if (array[index] < array[index+1])
//                    return true;
//                else
//                    return false;
//            }
//            else
//                return false;
            //MEJOR MANERA SERÍA ASÍ
            if (array[index] < array[index+1])
                return estaOrdenado(array, index+1);
            else
                return false;
        }
    }
}
