package classes;

public class DoubleLinkedNode {

	private Integer info;
	private DoubleLinkedNode next;
	private DoubleLinkedNode previous;

	public DoubleLinkedNode() {
		this.info = null;
		this.next = null;
		this.previous = null;
	}

	public DoubleLinkedNode(Integer o, DoubleLinkedNode n, DoubleLinkedNode p) {
		this.setInfo(o);
		this.setNext(n);
		this.setPrevious(p);
	}
	
	public DoubleLinkedNode getNext() {
		return next;
	}

	public boolean hasNext() {
		if (this.next != null) return true;
		else return false;
	}

	public void setNext(DoubleLinkedNode next) {
		this.next = next;
	}

	public void setPrevious(DoubleLinkedNode previous) {
		this.previous = previous;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

}
