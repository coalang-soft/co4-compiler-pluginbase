package io.github.coalangsoft.lang.token;

import io.github.coalangsoft.lib.sequence.basic.BasicSequence;

public class TokenTypeSequence extends BasicSequence<TokenType> {
	
	public TokenTypeSequence(TokenType[] values) {
		super(TokenType.class, values);
	}
	
}
