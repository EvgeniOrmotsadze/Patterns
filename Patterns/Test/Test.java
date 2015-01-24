package Test;

import Visitor.NodeVisitor;
import Composite.File;
import Composite.Folder;

public class Test {
	
	public static void main(String[] args) {
		Folder f1 = new Folder("folder1");
		f1.add(new File("file1", 1));
		f1.add(new File("file2", 2));
		Folder f2 = new Folder("folder2");
		f2.add(new File("file3", 5));
		f1.add(f2);
		
		NodeVisitor nv = new NodeVisitor();
		f1.accept(nv);
		System.out.println(nv.getTotalSize());
		System.out.println(f2.getNodeInfo());
	}

}
