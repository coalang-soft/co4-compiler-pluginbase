package io.github.coalangsoft.lang.context;

import java.util.ArrayList;
import java.util.List;

public class CompileContext {
	
	public CompileContext(){
		compileSystems = new ArrayList<CompileSystem>();
	}
	
	private List<CompileSystem> compileSystems;
	private CompileSystem lastSystem;
	private Class<? extends CompileSystem> required;
	private Object hint;
	
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
		System.out.println(required);
		if(required != null){
			if(!required.isInstance(s)){
				throw new StateUpdateException("Required system " + required.getName());
			}
		}
	}
	public void exitSystem(CompileSystem s){
		this.lastSystem = s;
		this.hint = null;
	}
	public CompileSystem getLastSystem(){
		return lastSystem;
	}
	public void requireNext(Class<? extends CompileSystem> clss) {
		this.required = clss;
	}
	public void sendHint(Object hint) {
		this.hint = hint;
	}
	public Object getHint(){
		return hint;
	}
	
}
