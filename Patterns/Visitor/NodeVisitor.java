package Visitor;

import Composite.File;
import Composite.Folder;
import Composite.Node;

public class NodeVisitor implements Visitor {
	
	int totalSize;
	
	public NodeVisitor() {
		totalSize = 0;
	}
	
	public int getTotalSize() {
		return totalSize;
	}

	@Override
	public void visit(File file) {
		totalSize += file.calculateSize();
	}

	@Override
	public void visit(Folder folder) {
		for (Node n: folder.getNodes())
			totalSize += n.calculateSize();
	}

}
