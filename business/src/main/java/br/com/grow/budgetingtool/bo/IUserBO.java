package br.com.grow.budgetingtool.bo;

import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.vo.UserVO;

public interface IUserBO {
	public List<UserVO> findAllUsers();

	public UserVO findUserById(int index);

	public UserVO findUserByEmail(String email);

	public List<UserVO> findUsersByEmailIn(Collection<String> emails);

	public Integer createUser(UserVO userVO);

	public void updateUser(UserVO userVO);

	public void deleteUser(UserVO userVO);
}
