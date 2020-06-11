package tp1;
import classes.MySimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        //------------- EJ 1 ----------------
//        MySimpleLinkedList lista = new MySimpleLinkedList();
//        System.out.println("--- Imprimo lista: ");
//        System.out.print("   ");
//        lista.print();
//        System.out.println("--- Pregunto si está vacía: " + lista.isEmpty());
//        System.out.println("--- Inserto 1,2,3");
//        lista.insertFront(1);
//        lista.insertFront(2);
//        lista.insertFront(3);
//        System.out.println("--- Imprimo lista: ");
//        System.out.print("   ");
//        lista.print();
//        System.out.println("");
//        System.out.println("--- Llamo al método extract e imprimo lista: ");
//        lista.extractFront();
//        lista.print();
//        System.out.println("");
//        System.out.println("--- Pido el elemento 1: " + lista.get(1));
//        System.out.println("--- Pido el elemento 5 que no existe: " + lista.get(5));
//        System.out.println("--- Pido el tamaño de la lista: " + lista.size());
//        System.out.println("--- Pregunto si está vacía: " + lista.isEmpty());

        //-------------- EJ 3 ---------------
//        MyStack pila = new MyStack();
//        System.out.println("--- Agrego 5 números a la pila y la imprimo: ");
//        pila.push(1);
//        pila.push(2);
//        pila.push(3);
//        pila.push(4);
//        pila.push(5);
//        System.out.print("   ");
//        pila.print();
//        System.out.println("");
//        System.out.println("--- Llamo al método top() e imprimo el resultado: ");
//        System.out.println("   " + pila.top());
//        System.out.println("--- Llamo al método pop() e imprimo lo que devuelve: ");
//        System.out.println("   " + pila.pop());
//        System.out.println("--- Imprimo la pila para verificar el borrado: ");
//        System.out.print("   ");
//        pila.print();
//        System.out.println("");
//        System.out.println("--- Llamo al método reverse() e imprimo la lista para ver el cambio: ");
//        pila.reverse();
//        System.out.print("   ");
//        pila.print();
//        System.out.println("");
        //-------------- EJ 4 ---------------
//        MySimpleLinkedList lista = new MySimpleLinkedList();
//        System.out.println("--- Agrego 3 números a la lista y la imprimo: ");
//        lista.insertFront(1);
//        lista.insertFront(2);
//        lista.insertFront(3);
//        System.out.print("   ");
//        lista.print();
//        System.out.println("");
//        System.out.println("--- Llamo al método indexOf('2') e imprimo el resultado: ");
//        System.out.println("   El elemento 'Manuel' está en la posición: " + lista.indexOf(2));
        //-------------- EJ 5 ---------------
//        MySimpleLinkedList lista = new MySimpleLinkedList();
//        System.out.println("--- Agrego 3 números a la lista y la itero: ");
//        lista.insertFront(1);
//        lista.insertFront((2));
//        lista.insertFront((3));
//        for (Integer num : lista)
//            System.out.println(num);
        //-------------- EJ 6 ---------------
//        -------------- Punto a) ---------------
//        //creo dos listas desordenadas
//        MySimpleLinkedList lista1 = new MySimpleLinkedList();
//        MySimpleLinkedList lista2 = new MySimpleLinkedList();
//        //cargo datos a la lista 1
//        lista1.insertFront(25);
//        lista1.insertFront(2);
//        lista1.insertFront(87);
//        lista1.insertFront(3);
//        lista1.insertFront(15);
//        //cargo datos a la lista 2
//        lista2.insertFront(3);
//        lista2.insertFront(25);
//        lista2.insertFront(42);
//        lista2.insertFront(5);
//        lista2.insertFront(12);
//        //llamo al metodo que devuelve una nueva lista con los valores en común
//        MySimpleLinkedList listaResultante = lista1.getCommonElements(lista1, lista2);
//        //imprimo el resultado
//        listaResultante.print();
        //-------------- Punto b) ---------------
//        //creo dos listas ordenadas
//        MySimpleLinkedList lista1 = new MySimpleLinkedList();
//        MySimpleLinkedList lista2 = new MySimpleLinkedList();
//        //cargo datos a la lista 1
//        lista1.insertFront(2);
//        lista1.insertFront(3);
//        lista1.insertFront(15);
//        lista1.insertFront(25);
//        lista1.insertFront(87);
//        //cargo datos a la lista 2
//        lista2.insertFront(3);
//        lista2.insertFront(5);
//        lista2.insertFront(12);
//        lista2.insertFront(25);
//        lista2.insertFront(42);
//        //llamo al metodo que devuelve una nueva lista con los valores en común usando la forma más eficiente y que ya me la devuelve ordenada
//        MySimpleLinkedList listaResultante = lista1.getCommonElementsOrder(lista1, lista2);
//        //imprimo el resultado
//        listaResultante.print();
        //-------------- EJ 7 ---------------
        //creo dos listas desordenadas
//        MySimpleLinkedList lista1 = new MySimpleLinkedList();
//        MySimpleLinkedList lista2 = new MySimpleLinkedList();
//        //cargo datos a la lista 1
//        lista1.insertFront(25);
//        lista1.insertFront(2);
//        lista1.insertFront(87);
//        lista1.insertFront(3);
//        lista1.insertFront(15);
//        //cargo datos a la lista 2
//        lista2.insertFront(3);
//        lista2.insertFront(25);
//        lista2.insertFront(42);
//        lista2.insertFront(5);
//        lista2.insertFront(12);
//        //llamo al metodo que devuelve una nueva lista con los valores distintos
//        MySimpleLinkedList listaResultante = lista1.getDifferentElements(lista1, lista2);
//        //imprimo el resultado
//        listaResultante.print();

        //creo dos listas ordenadas
//        MySimpleLinkedList lista1 = new MySimpleLinkedList();
//        MySimpleLinkedList lista2 = new MySimpleLinkedList();
//        //cargo datos a la lista 1
//        lista1.insertFront(87);
//        lista1.insertFront(25);
//        lista1.insertFront(15);
//        lista1.insertFront(3);
//        lista1.insertFront(2);
//        //cargo datos a la lista 2
//        lista2.insertFront(42);
//        lista2.insertFront(25);
//        lista2.insertFront(12);
//        lista2.insertFront(5);
//        lista2.insertFront(3);
//        //llamo al metodo que devuelve una nueva lista con los valores en común usando la forma más eficiente y que ya me la devuelve ordenada
//        MySimpleLinkedList listaResultante = lista1.getDifferentElementsOrder(lista1, lista2);
//        //imprimo el resultado
//        listaResultante.print();
        //-------------- EJ 9 ---------------
//        String texto = "";
//        int contador = 0;
//        boolean coincide = true;
//
//        for (int i = texto.length()-1; i > 0; i--) {
//            if (texto.charAt(i) != texto.charAt(contador)) {
//                coincide = false;
//                break;
//            }
//            contador++;
//        }
//
//        if(coincide)
//            System.out.println("El texto '" + texto + "' es palíndromo.");
//        else
//            System.out.println("El texto '" + texto + "' no es palíndromo.");
    }
}
