package br.com.grow.budgetingtool.vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.grow.budgetingtool.model.enuns.CategoryTypeEnum;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;

public class CategoryVO {
	
	private Class<?> refClass;
	private Object instanceObj;
	private final transient String CLASSNAME = "br.com.grow.budgetingtool.model.entities.Category";
	
	public Object getRefClassInstance(){
		return this.instanceObj;
	}
	
	public CategoryVO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.refClass = Class.forName(CLASSNAME);
		this.instanceObj = refClass.newInstance();
	}
	
	public CategoryVO(Object instanceObj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		refClass = Class.forName(CLASSNAME);
		this.instanceObj = instanceObj;
	}
	
	public String getName() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getName");
		return (String) methodObj.invoke(instanceObj);
	}

	public void setName(String name) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setName", String.class);
		methodObj.invoke(instanceObj, name);
	}

	public CategoryTypeEnum getType() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getType");
		return  (CategoryTypeEnum) methodObj.invoke(instanceObj);
	}

	public void setType(CategoryTypeEnum categoryTypeEnum) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setStatus", StatusEnum.class);
		methodObj.invoke(instanceObj, categoryTypeEnum);
	}

	public int getId() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getId");
		return  (int) methodObj.invoke(instanceObj);
	}
}
