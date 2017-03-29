package io.github.coalangsoft.lang.tree.layer;

import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;

public class DeepExtracter extends Extracter{

	private TokenType open;
	private LayerState state;
	private TokenType close;

	public DeepExtracter(TreeItemType type, TokenType open,
			TokenType close) {
		super(type);
		this.open = open;
		this.close = close;
		this.state = new LayerState(open,close);
	}

	@Override
	protected boolean onFeed(TreeItem treeItem) {
		if(treeItem.getType() == TreeItemType.TOKEN){
			state.feed(treeItem.getTokens().at(0).getType());
			return state.isFinished();
		}else if(treeItem.getType().isDeep()){
			treeItem.setAll(new DeepExtracter(type, open, close).call(treeItem.asList()));
		}
		return false;
	}

	@Override
	protected boolean isOpener(TreeItem treeItem) {
		if(treeItem.getType() == TreeItemType.TOKEN){
			return treeItem.getTokens().at(0).getType() == open;
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
