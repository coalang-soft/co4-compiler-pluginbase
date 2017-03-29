package io.github.coalangsoft.lang.token;

import io.github.coalangsoft.lang.token.Token;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;

import java.util.ArrayList;
import java.util.List;


public class TokenGroup {
	
	private List<Token> tokens;

	public TokenGroup(List<Token> tokens){
		this.tokens = tokens;
	}

	public TokenGroup() {
		this.tokens = new ArrayList<Token>();
	}

	public List<Token> getRaw(){
		return tokens;
	}
	
	public String getCode(){
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < tokens.size(); i++){
			b.append(tokens.get(i).getValue());
			b.append(" ");
		}
		return b.toString();
	}
	
	public int getStartLine(){
		return tokens.get(0).getLine();
	}
	public int getStartColumn(){
		return tokens.get(0).getColumn();
	}
	
	@Override
	public String toString() {
		return "TokenGroup [tokens=" + tokens + "]";
	}

	public List<TreeItem> asTreeItems() {
		ArrayList<TreeItem> items = new ArrayList<TreeItem>();
		for(int i = 0; i < tokens.size(); i++){
			items.add(new TreeItem(TreeItemType.TOKEN).addToken(tokens.get(i)));
		}
		return items;
	}
	
}
