package Composite;

public abstract class Node {
	
	String name;
	int size;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract int calculateSize();
	
	public void add(Node n) {
		throw new UnsupportedOperationException();
	}
	
	public void delete(Node n) {
		throw new UnsupportedOperationException();
	}
	
	// Template method
	public String getNodeInfo() {
		return "Node type is: " + this.getClass().toString() + ". Size is: " + calculateSize() + ".";
	}

}
