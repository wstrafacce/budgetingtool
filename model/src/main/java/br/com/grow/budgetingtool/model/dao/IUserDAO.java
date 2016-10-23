package br.com.grow.budgetingtool.model.dao;

import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.model.entities.User;

public interface IUserDAO {

	public List<Object> findAllUsers();

	public Object findUserById(int index);

	public Object findUserByEmail(String email);

	public List<Object> findUsersByEmailIn(Collection<String> emails);

	public Integer insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
	
}
