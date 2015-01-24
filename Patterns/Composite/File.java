package Composite;

import Visitor.Visitable;
import Visitor.Visitor;

public class File extends Node implements Visitable {
	
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public int calculateSize() {
		return size;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
