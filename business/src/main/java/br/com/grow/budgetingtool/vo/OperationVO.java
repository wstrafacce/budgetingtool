package br.com.grow.budgetingtool.vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;

import br.com.grow.budgetingtool.model.enuns.InsertModeEnum;

public class OperationVO {

	private Class<?> refClass;
	private Object instanceObj;
	private final transient String CLASSNAME = "br.com.grow.budgetingtool.model.entities.Operation";
	
	public Object getRefClassInstance(){
		return this.instanceObj;
	}
	
	public OperationVO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.refClass = Class.forName(CLASSNAME);
		this.instanceObj = refClass.newInstance();
	}
	
	public OperationVO(Object instanceObj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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


	public float getValue() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getValue");
		return (float) methodObj.invoke(instanceObj);
	}

	public void setValue(float value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setValue", Float.class);
		methodObj.invoke(instanceObj, value);
	}

	public Timestamp getDate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getDate");
		return (Timestamp) methodObj.invoke(instanceObj);
	}

	public void setDate(Timestamp date) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setDate", Timestamp.class);
		methodObj.invoke(instanceObj, date);
	}

	public CategoryVO getCategory() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		Method methodObj = refClass.getDeclaredMethod("getCategory");		
		return (CategoryVO) new CategoryVO(methodObj.invoke(instanceObj)).getRefClassInstance();
	}

	public void setCategory(CategoryVO categoryVO) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setCategory", categoryVO.getRefClassInstance().getClass());
		methodObj.invoke(instanceObj, categoryVO.getRefClassInstance());
	}

	public UserVO getUser() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		Method methodObj = refClass.getDeclaredMethod("getUser");		
		return (UserVO) new UserVO(methodObj.invoke(instanceObj)).getRefClassInstance();
	}

	public void setUser(UserVO userVO) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setUser", userVO.getRefClassInstance().getClass());
		methodObj.invoke(instanceObj, userVO.getRefClassInstance());
	}

	public InsertModeEnum getInsertMode() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getInsertMode");
		return  (InsertModeEnum) methodObj.invoke(instanceObj);
	}

	public void setInsertMode(InsertModeEnum insertModeEnum) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("setInsertMode", InsertModeEnum.class);
		methodObj.invoke(instanceObj, insertModeEnum);
	}

	public int getId() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methodObj = refClass.getDeclaredMethod("getId");
		return  (int) methodObj.invoke(instanceObj);
	}

}
