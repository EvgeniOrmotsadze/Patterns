package Composite;

import java.util.ArrayList;

import Visitor.Visitable;
import Visitor.Visitor;

public class Folder extends Node implements Visitable {
	
	ArrayList<Node> nodes;

	public Folder(String name) {
		nodes = new ArrayList<Node>();
		this.name = name;
	}
	
	public void add(Node n) {
		nodes.add(n);
	}
	
	public void delete(Node n) {
		nodes.remove(n);
	}
	
	public int calculateSize() {
		int total = 0;
		for (Node n: nodes)
			total += n.calculateSize();
		return total;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

}
