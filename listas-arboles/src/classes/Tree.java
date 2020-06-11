package classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(int value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    //Complejidad O(n) donde n es la altura del arbol
    //En el peor de los casos el número a insertar deberá
    //ir al final del arbol debajo de la hoja más
    //alejada de la raíz
    private void add(TreeNode actual, int value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public int getHeight() {
        if (this.root == null)
            return 0;
        else
            return this.getHeight(this.root);
    }

    //Complejidad O(n) donde n es el la cantidad de nodos
    //Siempre se pregunta recursivamente a todos los nodos
    //hasta llegar a la hoja
    private int getHeight(TreeNode node) {
        if (node.esHoja())
            return 0;
        else {
            int izq = 0;
            int der = 0;

            if (node.getLeft() != null)
                izq = this.getHeight(node.getLeft()) + 1;

            if (node.getRight() != null)
                der = this.getHeight(node.getRight()) + 1;

            if (izq > der)
                return izq;
            else
                return der;
        }
    }

    public boolean hasElement(int x) {
        return this.hasElement(x, this.root);
    }

    //Complejidad O(n) donde n es la altura
    //En el peor de los casos mi número va a estar
    //al final (o sea es una hoja) o no está en el árbol
    private boolean hasElement(int x, TreeNode node) {
        if (node == null)
            return false;
        else {
            if (node.getValue() == x)
                return true;
            else if (node.getValue() > x)
                return this.hasElement(x, node.getLeft());
            else
                return this.hasElement(x, node.getRight());
        }
    }

    public void delete(int x) {
        if (this.root == null)
            return;
        else if (this.root.getValue() == x) {
            if (this.root.esHoja())
                this.root = null;
            else if (this.root.getLeft() == null)
                this.root = this.root.getRight();
            else if (this.root.getRight() == null)
                this.root = this.root.getLeft();
            else {
                int min = getMin(this.root.getRight());
                this.root.setValue(min);
                this.delete(min, this.root);
            }
        }
        else this.delete(x, this.root);
    }

    //Complejidad O(n) donde n es la altura
    //En el peor de los casos tengo que buscar
    //hasta la hoja más al fondo
    private void delete(int x, TreeNode node) {
        if (x < node.getValue()) { //si el valor es menor busco a mi izquierda
            if (node.getLeft() == null) //si no tengo izquierda termina
                return;
            else if (node.getLeft().getValue() != x) //si mi izquierda es distinto me meto recursivamente a la izquierda
                this.delete(x, node.getLeft());
            else { //entra si se encuentra el valor
                if (node.getLeft().esHoja()) //si es hoja
                    node.setLeft(null);
                else if (node.getLeft().getLeft() == null) // si solo tiene derecha
                    node.setLeft(node.getLeft().getRight());
                else if (node.getLeft().getRight() == null) //si solo tiene izquierda
                    node.setLeft(node.getLeft().getLeft());
                else { //si tiene ambas
                    int min = getMin(node.getLeft().getRight());
                    node.getLeft().setValue(min);
                    this.delete(min, node.getLeft());
                }
            }
        }
        else {
            if (node.getRight() == null)
                return;
            else if (node.getRight().getValue() != x)
                this.delete(x, node.getRight());
            else {
                if (node.getRight().esHoja())
                    node.setRight(null);
                else if (node.getRight().getLeft() == null)
                    node.setRight(node.getRight().getRight());
                else if (node.getRight().getRight() == null)
                    node.setRight(node.getRight().getLeft());
                else {
                    int min = getMin(node.getRight().getRight());
                    node.getRight().setValue(min);
                    this.delete(min, node.getRight());
                }
            }
        }
    }

    public ArrayList<Integer> getFrontera() {
        return this.getFrontera(this.root);
    }

    //Complejidad O(n) donde n es la cantidad de nodos
    //Se llama recursivamente a todos los nodos hasta llegar
    //a las hojas
    private ArrayList<Integer> getFrontera(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();

        if (node.esHoja()) {
            list.add(node.getValue());
        }
        else {
            if (node.getLeft() != null) {
                list.addAll(this.getFrontera(node.getLeft()));
            }

            if (node.getRight() != null) {
                list.addAll(this.getFrontera(node.getRight()));
            }
        }

        return list;
    }

    public ArrayList<Integer> getElementsAtLevel(int level) {
        return this.getElementsAtLevel(0, level, this.root);
    }

    //Complejidad O(n) donde n es la cantidad de nodos
    //En el peor de los casos nos van a pedir la altura
    //mas alta, por lo tanto llegamos al final y recorremos
    //todos los nodos
    private ArrayList<Integer> getElementsAtLevel(int index, int level, TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();

        if (index == level) {
            list.add(node.getValue());
        }
        else {
            index++;

            if (node.getLeft() != null) {
                list.addAll(this.getElementsAtLevel(index, level, node.getLeft()));
            }

            if (node.getRight() != null) {
                list.addAll(this.getElementsAtLevel(index, level, node.getRight()));
            }
        }

        return list;
    }

    public ArrayList<Integer> getLongestBranch() {
        return this.getLongestBranch(this.root);
    }

    //Complejidad O(n) donde n es la cantidad de nodos
    //Se llama recursivamente hasta llegar a las hojas
    private ArrayList<Integer> getLongestBranch(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();

        if (node.esHoja()) {
            list.add(node.getValue());
        }
        else {
            ArrayList<Integer> izq = new ArrayList<>();
            ArrayList<Integer> der = new ArrayList<>();

            if (node.getLeft() != null)
                izq.addAll(this.getLongestBranch(node.getLeft()));

            if (node.getRight() != null)
                der.addAll(this.getLongestBranch(node.getRight()));

            list.add(node.getValue());

            if (izq.size() > der.size()) {
                list.addAll(izq);
            }
            else {
                list.addAll(der);
            }
        }

        return list;
    }

    //Complejidad O(n) donde n es la altura
    //Siempre se va lo más a la derecha posible
    //por lo tanto depende de la altura
    public int getMaxElement() {
        TreeNode node = this.root;

        while (node.getRight() != null)
            node = node.getRight();

        return node.getValue();
    }

    //Complejidad O(n) donde n es la altura
    //Siempre se va lo más a la izquierda posible
    //por lo tanto depende de la altura
    private int getMin(TreeNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node.getValue();
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        if (this.root == null)
            return true;
        else
            return false;
    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode node) {
        if (node == null) {
            System.out.print("[-]");
            return;
        }
        System.out.print("[" + node.getValue() + "]");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printPostOrder() {
        this.printPostOrder(this.root);
    }

    private void printPostOrder(TreeNode node) {
        if (node == null)
            return;

        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print("[" + node.getValue() + "]");
    }

    public void printInOrder() {
        this.printInOrder(this.root);
    }

    private void printInOrder(TreeNode node) {
        if (node == null)
            return;

        printInOrder(node.getLeft());
        System.out.print("[" + node.getValue() + "]");
        printInOrder(node.getRight());
    }
}
