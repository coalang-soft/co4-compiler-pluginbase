package io.github.coalangsoft.lang.tree.layer;

import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;

public class FlatExtracter extends Extracter{

	private TokenType mark;
	private LayerState state;
	
	public FlatExtracter(TreeItemType type, TokenType mark) {
		super(type);
		this.mark = mark;
		this.state = new LayerState(mark,mark);
	}

	@Override
	protected boolean onFeed(TreeItem treeItem) {
		if(treeItem.getType() == TreeItemType.TOKEN){
			state.feed(treeItem.getTokens().at(0).getType());
			return state.isFinished();
		}
		return false;
	}

	@Override
	protected boolean isOpener(TreeItem treeItem) {
		if(treeItem.getType() == TreeItemType.TOKEN){
			return treeItem.getTokens().at(0).getType() == mark;
		}
		return false;
	}

	@Override
	protected void open(TreeItem treeItem) {
		state.feed(treeItem.getTokens().at(0).getType());
		if(state.isFinished()){
			treeItem.makeException("Implementation Exception: state is finish after opening.");
		}
	}

}
