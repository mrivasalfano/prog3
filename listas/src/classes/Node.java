package classes;

public class Node {

	private Integer info;
	private Node next;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(Integer o, Node n) {
		this.setInfo(o);
		this.setNext(n);
	}
	
	public Node getNext() {
		return next;
	}

	public boolean hasNext() {
		if (this.next != null) return true;
		else return false;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

}
