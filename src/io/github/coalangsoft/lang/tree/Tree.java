package io.github.coalangsoft.lang.tree;

import io.github.coalangsoft.lang.token.TokenGroup;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;
import io.github.coalangsoft.lang.tree.layer.DeepExtracter;
import io.github.coalangsoft.lang.tree.layer.FlatExtracter;

import java.util.List;

public class Tree {
	
	private TokenGroup tokens;

	public static List<TreeItem> finish(List<TreeItem> l){
		l = new FlatExtracter(TreeItemType.STRING, TokenType.STRING_MARK).call(l);
		l = new DeepExtracter(TreeItemType.GROUP, TokenType.ROUND_BRACKET_OPEN, TokenType.ROUND_BRACKET_CLOSE).call(l);
		l = new DeepExtracter(TreeItemType.BLOCK, TokenType.BRACKET_OPEN, TokenType.BRACKET_CLOSE).call(l);
		l = new DeepExtracter(TreeItemType.LIST, TokenType.SQUARE_BRACKET_OPEN, TokenType.SQUARE_BRACKET_CLOSE).call(l);
		return l;
	}
	
	public Tree(TokenGroup tokens){
		this.tokens = tokens;
	}
	
	public TreeItem createTree(){
		return createTree(tokens.asTreeItems(), TreeItemType.ROOT);
		
	}
	
	public static TreeItem createTree(List<TreeItem> l, TreeItemType type){
		TreeItem root = new TreeItem(type);
		
		l = finish(l);
		
		for(int i = 0; i < l.size(); i++){
			root.add(l.get(i));
		}
		
		return root;
	}
	
}
