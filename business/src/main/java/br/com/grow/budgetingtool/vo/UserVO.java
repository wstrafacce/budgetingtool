package br.com.grow.budgetingtool.vo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.grow.budgetingtool.model.enuns.StatusEnum;

public class UserVO {
	
	private Class<?> refClass;
	private Object instanceObj;
	private final transient String CLASSNAME = "br.com.grow.budgetingtool.model.entities.User";
	
	public Object getRefClassInstance(){
		return this.instanceObj;
	}
	
	public UserVO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.refClass = Class.forName(CLASSNAME);
		this.instanceObj = refClass.newInstance();
	}
	
	public UserVO(Object instanceObj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.refClass = Class.forName(CLASSNAME);
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

	public String getLastname() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getLastname");
		return (String) methodObj.invoke(instanceObj);
	}

	public void setLastname(String lastname) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setLastname", String.class);
		methodObj.invoke(instanceObj, lastname);
	}

	public String getEmail() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getEmail");
		return (String) methodObj.invoke(instanceObj);
	}

	public void setEmail(String email) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setEmail", String.class);
		methodObj.invoke(instanceObj, email);
	}

	public String getPassword() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getPassword");
		return (String) methodObj.invoke(instanceObj);
	}

	public void setPassword(String password) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setPassword", String.class);
		methodObj.invoke(instanceObj, password);
	}
	
	public StatusEnum getStatus() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getStatus");
		return  (StatusEnum) methodObj.invoke(instanceObj);
	}

	public void setStatus(StatusEnum statusEnum) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setStatus", StatusEnum.class);
		methodObj.invoke(instanceObj, statusEnum);
	}

	public File getPicture() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getPicture");
		return (File) methodObj.invoke(instanceObj);
	}

	public void setPicture(File picture) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setPassword", String.class);
		methodObj.invoke(instanceObj, picture);
	}

	public int getId() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getId");
		return  (int) methodObj.invoke(instanceObj);
	}
}
