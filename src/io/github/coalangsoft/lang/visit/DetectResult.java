package io.github.coalangsoft.lang.visit;

public class DetectResult {

	private final String res;
	private final boolean compiled;

	public DetectResult(String compiled){
		this.res = compiled;
		this.compiled = compiled != null;
	}
	
	public boolean isCompiled() {
		return compiled;
	}

	public String compiled() {
		return res;
	}

}
