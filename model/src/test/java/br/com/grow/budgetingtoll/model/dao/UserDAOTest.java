package br.com.grow.budgetingtoll.model.dao;

import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

import br.com.grow.budgetingtool.model.dao.impl.UserDAOImpl;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;

public class UserDAOTest {

	@Test
	@Ignore
	public void insertTest() {
		User user = new User();
		UserDAOImpl userDAO = new UserDAOImpl();
		
		user.setEmail("teste@teste.com");
		user.setPassword("¨$&#*¨$&*");
		user.setStatus(StatusEnum.PENDING);
		int id = userDAO.insertUser(user);
		assertNull(id);
	}

}
