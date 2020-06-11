package classes;

public class MyStack {
    MySimpleLinkedList lista;

    public MyStack() {
        this.lista = new MySimpleLinkedList();
    }

    public void push(Integer i) {
        this.lista.insertFront(i);
    }

    public Integer pop() {
        return this.lista.extractFront();
    }

    public Integer top() {
        return this.lista.top();
    }

    public int size() {
        return this.lista.size();
    }

    public void print() {
        this.lista.print();
    }

    public void reverse() {
        if (this.size() > 1) {
            //NO ME SALIO PERO SE PUEDE HACER DE ESTA FORMA CON MAS VARIABLES O PUNTEROS
//			Node puntero = this.first.getNext();
//			Node nextTmp = puntero.getNext();
//			this.first.setNext(null);
//
//			while (puntero != null) {
//				if (nextTmp == null) {
//					puntero.setNext(puntero);
//					break;
//				}
//				else {
//					nextTmp = puntero.getNext().getNext();
//					puntero.getNext().setNext(puntero);
//					puntero = puntero.getNext();
//				}
//			}
            //crear lista nueva

            MySimpleLinkedList listaTmp = new MySimpleLinkedList();
            int limit = this.size();

            for (int i = 0; i < limit; i++) {
                listaTmp.insertFront(this.lista.extractFront());
            }

            this.lista = listaTmp;
        }
    }
}
