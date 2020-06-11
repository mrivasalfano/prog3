package classes;

import java.util.ArrayList;

public class MySimpleLinkedList implements Iterable<Integer>{

	protected Node first;
	private int size;
	protected Node last;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	private Node getFirstNode() {
		return this.first;
	}

	public void insertFront(Integer o) {
		Node tmp = new Node(o,null);
		tmp.setNext(this.first);
		if (this.isEmpty()) {
			this.last = tmp;
		}
		this.first = tmp;
		this.size++;
	}

	//insertar al final
	public void pushBack(Integer o) {
		if (this.isEmpty()) {
			this.first = new Node(o, null);
			this.last = first;
		}
		else {
//			Node last = this.getLastNode();
			Node tmp = new Node(o, null);
			this.last.setNext(tmp);
			this.last = tmp;
		}
		this.size++;
	}

	public int indexOf(Object elem) {
		if (this.isEmpty()) return -1;
		else {
			int contador = 0;
			Node index = this.first;

			while (contador < this.size) {
				if (index.getInfo() == elem) return contador;
				else {
					contador++;
					index = index.getNext();
				}
			}

			return -1;
		}
	}

	public Integer extractFront() {
		Integer info = this.first.getInfo();
		this.first = this.first.getNext();
		if (this.first == null) this.last = null;
		this.size--;
		return info;
	}

	//borrar al final
//	public Object popBack() {
//		if (!this.isEmpty()) {
//			Node elem = this.first;
//
//			while (elem.hasNext()) {
//				if (!elem.getNext().hasNext()) {
//					Object tmp = elem.getNext().getInfo();
//					elem.setNext(null);
//					this.size--;
//					return tmp;
//				} else elem = elem.getNext();
//			}
//		}
//
//		return null;
//	}

//	private Node getLastNode() {
//		Node elem = this.first;
//
//		while (elem.hasNext()) {
//			if (!elem.getNext().hasNext()) {
//				return elem.getNext();
//			} else elem = elem.getNext();
//		}
//
//		if (elem != null) return elem;
//		else return null;
//	}

	public Integer top() {
		if (!this.isEmpty()) {
			return this.last.getInfo();
		}

		return null;
	}

	public boolean isEmpty() {
		if (this.size == 0) return true;
		else return false;
	}

	public int size() {
		return this.size;
	}

	public Object get(int index) {
		if (index == 0) return first.getInfo();
		else {
			Node elem = this.first;
			int contador = 1;

			while (elem.hasNext()) {
				if (contador == index) return elem.getNext().getInfo();
				else {
					contador++;
					elem = elem.getNext();
				}
			}
		}
		return null;
	}

	public void print() {
		if (this.size > 0) {
			Node elem = this.first;
			System.out.print("Elements: " + elem.getInfo());

			while (elem.hasNext()) {
				System.out.print(", " + elem.getNext().getInfo());
				elem = elem.getNext();
			}
		}
		else System.out.println("Lista sin elementos.");
	}

	public MyListIterator iterator() {
		return new MyListIterator(this.first);
	}

	private Node getLastNode() {
		return this.last;
	}

	private void insertOrdenadoAsc(Integer num) {
		//antes de insertar buscar si hay un numero mayor a num, insertarlo antes
		Node elem = this.getFirstNode();
		Node elemAnterior = null;
		//si no habia elementos lo inserto de una
		if (elem == null)
			this.insertFront(num);
		else {
			//mientras el numero del elemento apuntado sea mayor a mi
			while (elem != null && elem.getInfo() < num) {
				elemAnterior = elem;
				elem = elem.getNext();
			}

			if (elemAnterior == null)
				this.insertFront(num);
			else {
				Node tmp = new Node(num, elem);
				elemAnterior.setNext(tmp);
			}
			this.size++;
		}
	}


	public MySimpleLinkedList getCommonElements(MySimpleLinkedList lista1, MySimpleLinkedList lista2) {
		MySimpleLinkedList listaTpm = new MySimpleLinkedList();

		for (Integer numBuscar : lista1) {
			for (Integer num : lista2) {
				if (numBuscar == num) {
					insertOrdenadoAsc(num);
				}
			}
		}

		return listaTpm;
	}

	public MySimpleLinkedList getDifferentElements(MySimpleLinkedList lista1, MySimpleLinkedList lista2) {
		MySimpleLinkedList listaTpm = new MySimpleLinkedList();

		for (Integer numBuscar : lista1) {
			boolean coincidio = false;
			for (Integer num : lista2) {
				if (numBuscar == num) {
					coincidio = true;
				}
			}
			if (!coincidio)
				insertOrdenadoAsc(numBuscar);
		}
		//25,2,87,3,15
		//3,25,41,5,12

		return listaTpm;
	}

	public MySimpleLinkedList getDifferentElementsOrder(MySimpleLinkedList lista1, MySimpleLinkedList lista2) {
		Node pointer1 = lista1.getFirstNode();
		Node pointer2 = lista2.getFirstNode();
		MySimpleLinkedList listaTpm = new MySimpleLinkedList();

		while (pointer1 != null && pointer2 != null) {
			boolean loMeto = false;
			Integer val1 = pointer1.getInfo();
			Integer val2 = pointer2.getInfo();

			if (val1 < val2) {
				loMeto = true;
				pointer1 = pointer1.getNext();
			}
			else if (val1 == val2) {
				loMeto = false;
				//suponiendo que no se repiten los numero lo aumento ya que no habria otro igual
				pointer1 = pointer1.getNext();
			}
			else
				pointer2 = pointer2.getNext();

			if (loMeto)
				insertOrdenadoAsc(val1);
		}

		if (pointer1 != null && pointer2 == null)
			insertOrdenadoAsc(pointer1.getInfo());

		return listaTpm;
	}

	public MySimpleLinkedList getCommonElementsOrder(MySimpleLinkedList lista1, MySimpleLinkedList lista2) {
		Node pointer1 = lista1.getFirstNode();
		Node pointer2 = lista2.getFirstNode();
		MySimpleLinkedList listaTpm = new MySimpleLinkedList();

		while (pointer1 != null && pointer2 != null) {
			Integer val1 = pointer1.getInfo();
			Integer val2 = pointer2.getInfo();
			//ANOTACIÓN: EN EL PRIMER CASO AUMENTO EL 2 PORQUE LA LISTA GUARDA LOS NODOS DE MAYOR A MENOR. LO MISMO EN EL TERCER CASO QUE AUMENTO EL 1
			if (val1 < val2)
				pointer2 = pointer2.getNext();
			else if (val1 == val2) {
				pointer1 = pointer1.getNext();
				//aumento el dos suponiendo que en la lista uno no hay número repetidos, si no no habría que aumentar por las dudas
				pointer2 = pointer2.getNext();
				insertOrdenadoAsc(val1);
			}
			else {
				pointer1 = pointer1.getNext();
			}
		}

		// lista 1 : 2,3,15,25,87
		// lista 2 : 3,5,12,25,42
		// listaTmp :
		return listaTpm;
	}

	public ArrayList<MySimpleLinkedList> getSubSecuencias(MySimpleLinkedList lista) {
		ArrayList<MySimpleLinkedList> array = new ArrayList<>();

		Node puntero = lista.getFirstNode();

		while (puntero != null) {
			Integer val = puntero.getInfo();
			MySimpleLinkedList listaTpm = new MySimpleLinkedList();
			listaTpm.insertFront(val);

			while (puntero.getNext() != null && puntero.getNext().getInfo() > val) {
				//corrección: Esta forma era ineficinete porque para insertar ordenado
				//recorro linealmente y agrego más complejidad al algoritmo final
//				listaTpm.insertOrdenadoAsc(puntero.getNext().getInfo());
				//lo cambié por un pushback que inserta al final y ya queda ordenado
				listaTpm.pushBack(puntero.getNext().getInfo());
				puntero = puntero.getNext();
				val = puntero.getInfo();
			}

			if (listaTpm.size >= 2)
				array.add(listaTpm);

			puntero = puntero.getNext();
		}

		return array;
	}

	//USADO EN EJERCICIO 2 del TP2
	public int getRecursivo(int x) {
		return this.indexOfRecursivo(x, this.first, 0);
	}

	//USADO EN EJERCICIO 2 del TP2
    private int indexOfRecursivo(int x, Node index, int contador) {
		//si el nodo existe
		if (index != null)
			if (index.getInfo() == x)
				return contador;
			else
				return indexOfRecursivo(x, index.getNext(), contador+1);
		//si no existe no se encontró
		else
			return -1;
    }
}
