package io.github.coalangsoft.lang.tree;

public enum TreeItemType {
	
	STRING(false), NUMBER(false), GROUP(true), BLOCK(true), LIST(true), TOKEN(false), ROOT(true);
	
	private boolean deep;

	private TreeItemType(boolean deep){
		this.deep = deep;
	}
	
	public boolean isDeep(){
		return deep;
	}
	
}
