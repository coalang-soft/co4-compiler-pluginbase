package io.github.coalangsoft.lang.context;

import java.util.ArrayList;
import java.util.List;

public class CompileContext {
	
	public CompileContext(){
		compileSystems = new ArrayList<CompileSystem>();
	}
	
	private List<CompileSystem> compileSystems;
	
	public void addCompileSystem(CompileSystem s){
		compileSystems.add(s);
	}
	public int compileSystemCount(){
		return compileSystems.size();
	}
	public CompileSystem getCompileSystem(int i){
		return compileSystems.get(i);
	}
	
}
