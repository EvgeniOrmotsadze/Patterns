package Visitor;

import Composite.File;
import Composite.Folder;

public interface Visitor {
	
	public void visit(File file);
	
	public void visit(Folder folder);

}
