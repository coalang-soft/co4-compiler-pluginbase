package io.github.coalangsoft.lang.token;

public class Token {
	
	private String value;
	private TokenType type;
	private int line;
	private int column;

	public Token(int line, int column, String value){
		this.line = line;
		this.column = column;
		this.value = value;
		this.type = TokenType.find(value);
	}
	
	public Token(int line, int column, String value, TokenType type){
		this.line = line;
		this.column = column;
		this.value = value;
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public TokenType getType() {
		return type;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "Token [value=" + value + ", type=" + type + ", line=" + line
				+ ", column=" + column + "]";
	}
	
}
