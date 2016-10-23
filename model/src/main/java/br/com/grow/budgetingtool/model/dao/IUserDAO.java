package br.com.grow.budgetingtool.model.dao;

import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.model.entities.User;

public interface IUserDAO {

	public List<User> findAllUsers();

	public User findUserById(int index);

	public User findUserByEmail(String email);

	public List<User> findUsersByEmailIn(Collection<String> emails);

	public Integer insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
	
}
