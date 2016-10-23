package br.com.grow.budgetingtool.bo;

import br.com.grow.budgetingtool.model.dao.IUserDAO;
import br.com.grow.budgetingtool.model.dao.impl.UserDAOImpl;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.vo.UserVO;

public class UserBO {

	private final transient IUserDAO userDAO = new UserDAOImpl();
	
	public int createUser(UserVO userVO) {
		return userDAO.insertUser((User) userVO.getRefClassInstance());
	}
}
