package io.github.coalangsoft.lang.token;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.BaseSequence;

public class TokenTypeSequence extends BaseSequence<TokenType> {
	
	public TokenTypeSequence(TokenType[] values) {
		super(makeTool(new Func<Integer, TokenType[]>() {

			public TokenType[] call(Integer p) {
				return new TokenType[p];
			}
			
		}), values);
	}
	
}
