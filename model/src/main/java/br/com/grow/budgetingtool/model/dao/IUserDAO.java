package br.com.grow.budgetingtool.model.dao;

import java.util.Collection;
import java.util.List;

public interface IUserDAO {

	public List<Object> findAllUsers();

	public Object findUserById(int index);

	public Object findUserByEmail(String email);

	public List<Object> findUsersByEmailIn(Collection<String> emails);

	public Integer insertUser(Object userObj);

	public void updateUser(Object userObj);

	public void deleteUser(Object userObj);
	
}
