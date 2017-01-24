package io.github.coalangsoft.lang.token;

import io.github.coalangsoft.lib.sequence.basic.BasicSequence;

public class TokenSequence extends BasicSequence<Token>{

	public TokenSequence(Token[] values) {
		super(Token.class, values);
	}

	public TokenTypeSequence getTypes() {
		TokenType[] arr = new TokenType[length()];
		for(int i = 0; i < length(); i++){
			arr[i] = at(i).getType();
		}
		return new TokenTypeSequence(arr);
	}

}
