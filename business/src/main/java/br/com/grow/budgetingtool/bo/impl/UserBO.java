package br.com.grow.budgetingtool.bo.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.bo.IUserBO;
import br.com.grow.budgetingtool.model.dao.IUserDAO;
import br.com.grow.budgetingtool.model.dao.impl.UserDAOImpl;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.vo.UserVO;

public class UserBO implements IUserBO{

	private final transient IUserDAO userDAO = new UserDAOImpl();

	@Override
	public List<UserVO> findAllUsers() {
		List<Object> users = userDAO.findAllUsers();
		List<UserVO> listUsers = new ArrayList<UserVO>();
		
		for (Object obj : users) {			
			try {
				UserVO userVO = new UserVO(obj);
				listUsers.add(userVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return listUsers;
	}

	@Override
	public UserVO findUserById(int index) {
		UserVO userVO = null;
		
		try {
			userVO = new UserVO(userDAO.findUserById(index));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userVO;
	}

	@Override
	public UserVO findUserByEmail(String email) {
		UserVO userVO = null;
		
		try {
			userVO = new UserVO(userDAO.findUserByEmail(email));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userVO;
	}

	@Override
	public List<UserVO> findUsersByEmailIn(Collection<String> emails) {
		List<Object> users = userDAO.findUsersByEmailIn(emails);
		List<UserVO> listUsers = new ArrayList<UserVO>();
		
		for (Object obj : users) {			
			try {
				UserVO userVO = new UserVO(obj);
				listUsers.add(userVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return listUsers;
	}

	@Override
	public Integer createUser(UserVO userVO) {
		return userDAO.insertUser((User) userVO.getRefClassInstance());
	}

	@Override
	public void updateUser(UserVO userVO) {
		userDAO.updateUser((User) userVO.getRefClassInstance());
	}

	@Override
	public void deleteUser(UserVO userVO) {
		userDAO.deleteUser((User) userVO.getRefClassInstance());
		
	}
}
