package ejEntregable2;

import classes.Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //creo el arbol
        Tree arbol = new Tree();
        //le agrego valores para probar
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
        //imprimo de las 3 maneras (en la pre order tiene guiones para poder armarlo en papel)
        System.out.print("Imprimo pre order: ");
        arbol.printPreOrder();
        System.out.println();
        System.out.print("Imprimo post order: ");
        arbol.printPostOrder();
        System.out.println();
        System.out.print("Imprimo in order: ");
        arbol.printInOrder();
        System.out.println();
        //pruebo los métodos
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
        //llamo a la función que crea un arbol random con altura máxima de 4
        Tree arbolRandom = randomTree(4);
        System.out.print("Creo un arbol random y lo imprimo: ");
        arbolRandom.printPreOrder();
        System.out.println();
    }

    private static Tree randomTree(int maxHeight) {
        Tree arbol = null;
        int altura = 0;

        while (altura > maxHeight || altura == 0) {
            arbol = new Tree();
            ArrayList<Integer> valores = new ArrayList<>();

            while (valores.size() < 15) {
                int random = (int) Math.ceil(Math.random() * 100);

                while (valores.contains(random))
                    random = (int) Math.ceil(Math.random() * 100);

                valores.add(random);
            }

            for (Integer num : valores) {
                arbol.add(num);
            }

            altura = arbol.getHeight();
        }

        return arbol;
    }
}