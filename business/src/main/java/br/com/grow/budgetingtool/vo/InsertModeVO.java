package br.com.grow.budgetingtool.vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InsertModeVO {
	
	private Class<?> refClass;
	private Object instanceObj;
	private final transient String CLASSNAME = "br.com.grow.budgetingtool.model.entities.InsertMode";
	
	public Object getRefClassInstance(){
		return this.instanceObj;
	}
	
	public InsertModeVO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.refClass = Class.forName(CLASSNAME);
		this.instanceObj = refClass.newInstance();
	}
	
	public InsertModeVO(Object instanceObj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.refClass = Class.forName(CLASSNAME);
		this.instanceObj = instanceObj;
	}
	
	public int getId() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getId");
		return (int) methodObj.invoke(instanceObj);
	}

	public String getName() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getName");
		return (String) methodObj.invoke(instanceObj);
	}
}
