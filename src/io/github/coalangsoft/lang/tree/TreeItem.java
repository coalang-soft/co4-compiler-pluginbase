package io.github.coalangsoft.lang.tree;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.token.Token;
import io.github.coalangsoft.lang.token.TokenSequence;
import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.ImutablePair;
import io.github.coalangsoft.lib.data.Pair;
import io.github.coalangsoft.lib.sequence.ModifiableSequence;

import java.util.ArrayList;
import java.util.List;

public class TreeItem extends ModifiableSequence<TreeItem>{
	
	private ArrayList<Token> tokens;
	private TreeItemType type;
	
	public TreeItem(TreeItemType type){
		super(makeTool(new Func<Integer, TreeItem[]>() {

			public TreeItem[] call(Integer p) {
				return new TreeItem[p];
			}
		}), new TreeItem[0]);
		tokens = new ArrayList<Token>();
		this.type = type;
	}
	
	public TreeItem addToken(Token t){
		tokens.add(t);
		return this;
	}
	
	public TokenSequence getTokens(){
		return new TokenSequence(tokens.toArray(new Token[0]));
	}

	public TreeItemType getType() {
		return type;
	}

	public void makeException(String string) {
		if(tokens.size() == 0){
			at(0).makeException(string);
		}
		Token t = tokens.get(0);
		throw new RuntimeException(String.format("(%d) %s", t.getLine(), string));
	}

	@Override
	public String toString() {
		return "TreeItem [tokens=" + tokens + ", type=" + type + ", childs=" + super.toString() + "]";
	}

	public void setAll(List<TreeItem> call) {
		clear();
		for(int i = 0; i < call.size(); i++){
			add(call.get(i));
		}
	}

	public String visit(CompileContext context, Func<Pair<TreeItem, CompileContext>, String> visitor) {
		return visitor.call(new ImutablePair<TreeItem, CompileContext>(this, context));
	}

	public TreeItemTypeSequence getChildTypes() {
		TreeItemType[] arr = new TreeItemType[length()];
		for(int i = 0; i < length(); i++){
			arr[i] = values[i].getType();
		}
		return new TreeItemTypeSequence(arr);
	}
	
}
