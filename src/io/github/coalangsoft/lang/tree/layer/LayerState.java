package io.github.coalangsoft.lang.tree.layer;

import io.github.coalangsoft.lang.token.TokenType;

public class LayerState {
	
	private TokenType opener;
	private TokenType closer;
	private boolean hasDepth;
	private boolean unescaped;
	private int depth = 0;

	public LayerState(TokenType opener, TokenType closer){
		this.opener = opener;
		this.closer = closer;
		
		if(opener == closer){
			hasDepth = false;
		}else{
			hasDepth = true;
		}
	}
	
	public void feed(TokenType t){
		if(hasDepth){
			if(t == opener){
				depth++;
			}else if(t == closer){
				depth--;
			}
		}else{
			if(depth == 0){
				if(t == opener){
					depth = 1;
				}
			}else{
				if(unescaped){
					unescaped = false;
				}else if(t == opener){
					depth = 0;
				}else if(t == TokenType.BACKSLASH){
					unescaped = true;
				}
			}
		}
	}
	
	public boolean isFinished(){
		return depth == 0;
	}

	@Override
	public String toString() {
		return "LayerState [opener=" + opener + ", closer=" + closer
				+ ", hasDepth=" + hasDepth + ", unescaped=" + unescaped
				+ ", depth=" + depth + "]";
	}
	
}
