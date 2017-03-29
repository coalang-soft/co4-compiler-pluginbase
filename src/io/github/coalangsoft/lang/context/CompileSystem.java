package io.github.coalangsoft.lang.context;

import io.github.coalangsoft.lang.tree.TreeItem;

public interface CompileSystem {
	
	public boolean accept(CompileContext context, TreeItem item);
	public String compile(CompileContext context, TreeItem item);
	
}
