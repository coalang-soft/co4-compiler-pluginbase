package io.github.coalangsoft.lang.token;

import java.util.regex.Pattern;

public enum TokenType {
	
	SPECIAL,
	SEPERATOR("\\s"), SEMICOLON(";"), COMMA(","),
	NAME("[a-zA-Z\\_][a-zA-Z0-9\\_]*"),
	NUMBER("[0-9]+"),
	STRING_MARK("\""),
	ROUND_BRACKET_OPEN("\\("), ROUND_BRACKET_CLOSE("\\)"),
	BRACKET_OPEN("\\{"), BRACKET_CLOSE("\\}"), BACKSLASH("\\\\"), 
	SQUARE_BRACKET_OPEN("\\["), SQUARE_BRACKET_CLOSE("\\]"), DOT("\\.");
	
	private Pattern pattern;

	private TokenType(String info){
		this.pattern = Pattern.compile(info);
	}
	private TokenType(){}
	
	private boolean matches(String raw){
		if(pattern == null){
			return false;
		}
		return pattern.matcher(raw).matches();
	}
	public static TokenType find(String raw){
		TokenType[] ts = values();
		for(int i = 0; i < ts.length; i++){
			if(ts[i] != SPECIAL){
				if(ts[i].matches(raw)){
					return ts[i];
				}
			}
		}
		return SPECIAL;
	}
	
}
