package io.github.coalangsoft.lang.context;

import java.util.ArrayList;
import java.util.List;

public class CompileContext {
	
	public CompileContext(){
		compileSystems = new ArrayList<CompileSystem>();
		hints = new ArrayList<String>();
	}
	
	private List<CompileSystem> compileSystems;
	private CompileSystem lastSystem;
	private Class<? extends CompileSystem> required;
	private ArrayList<String> hints;
	
	public void addCompileSystem(CompileSystem s){
		compileSystems.add(s);
	}
	public int compileSystemCount(){
		return compileSystems.size();
	}
	public CompileSystem getCompileSystem(int i){
		return compileSystems.get(i);
	}
	public void enterSystem(CompileSystem s) throws StateUpdateException {
//		System.out.println(required);
		if(required != null){
			if(!required.isInstance(s)){
				throw new StateUpdateException("Required system " + required.getName());
			}
		}
		required = null;
	}
	public void exitSystem(CompileSystem s){
		this.lastSystem = s;
	}
	public CompileSystem getLastSystem(){
		return lastSystem;
	}
	public void requireNext(Class<? extends CompileSystem> clss) {
		this.required = clss;
	}
	public void sendHint(String hint) {
		this.hints.add(hint);
	}
	public boolean hasHint(String s){
		return hints.remove(s);
	}
	
}
