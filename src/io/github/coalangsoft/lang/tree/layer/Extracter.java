package io.github.coalangsoft.lang.tree.layer;

import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;
import io.github.coalangsoft.lib.data.Func;

import java.util.ArrayList;
import java.util.List;


public abstract class Extracter implements Func<List<TreeItem>, List<TreeItem>> {

	private boolean open;
	private TreeItem current;
	protected TreeItemType type;
	
	private ArrayList<TreeItem> result;
	
	public Extracter(TreeItemType type){
		this.type = type;
	}
	
	public List<TreeItem> call(List<TreeItem> p) {
		this.result = new ArrayList<TreeItem>();
		for(int i = 0; i < p.size(); i++){
			feed(p.get(i));
		}
		return this.result;
	}

	private void feed(TreeItem treeItem) {
		if(!open){
			open = isOpener(treeItem);
			if(open){
				current = new TreeItem(type);
				current.add(treeItem);
				open(treeItem);
			}else{
				result.add(treeItem);
			}
		}else{
			current.add(treeItem);
			open = !onFeed(treeItem);
			if(!open){
				result.add(current);
			}
		}
	}

	protected abstract boolean onFeed(TreeItem treeItem);
	protected abstract boolean isOpener(TreeItem treeItem);
	protected abstract void open(TreeItem treeItem);
	
}
