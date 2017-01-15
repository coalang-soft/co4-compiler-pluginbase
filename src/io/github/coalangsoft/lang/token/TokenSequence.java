package io.github.coalangsoft.lang.token;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.BaseSequence;

public class TokenSequence extends BaseSequence<Token>{

	public TokenSequence(Token[] values) {
		super(makeTool(new Func<Integer, Token[]>() {

			public Token[] call(Integer p) {
				return new Token[p];
			}
			
		}), values);
	}

	public TokenTypeSequence getTypes() {
		TokenType[] arr = new TokenType[length()];
		for(int i = 0; i < length(); i++){
			arr[i] = at(i).getType();
		}
		return new TokenTypeSequence(arr);
	}

}
