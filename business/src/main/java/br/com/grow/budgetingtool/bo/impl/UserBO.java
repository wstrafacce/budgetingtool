package br.com.grow.budgetingtool.bo.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.bo.IUserBO;
import br.com.grow.budgetingtool.model.dao.IUserDAO;
import br.com.grow.budgetingtool.model.dao.impl.UserDAOImpl;
import br.com.grow.budgetingtool.vo.UserVO;

public class UserBO implements IUserBO {

	private final transient IUserDAO userDAO = new UserDAOImpl();

	@Override
	public List<UserVO> findAllUsers() {
		return returnUserVOList(userDAO.findAllUsers());
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
		return returnUserVOList(userDAO.findUsersByEmailIn(emails));
	}

	@Override
	public Integer createUser(UserVO userVO) {
		return userDAO.insertUser(userVO.getRefClassInstance());
	}

	@Override
	public void updateUser(UserVO userVO) {
		userDAO.updateUser(userVO.getRefClassInstance());
	}

	@Override
	public void deleteUser(UserVO userVO) {
		userDAO.deleteUser(userVO.getRefClassInstance());
	}

	private List<UserVO> returnUserVOList(List<Object> users) {
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
}
