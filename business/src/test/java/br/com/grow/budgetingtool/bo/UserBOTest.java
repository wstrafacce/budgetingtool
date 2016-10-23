package br.com.grow.budgetingtool.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.grow.budgetingtool.bo.impl.UserBO;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;
import br.com.grow.budgetingtool.vo.UserVO;

public class UserBOTest {
	private static IUserBO userBO;
	
	@BeforeClass
	public static void init(){
		userBO = new UserBO();
	}

	@Test
	@Ignore
	public void createUserTest() {
		try {
			UserVO userVO = new UserVO();
			userVO.setEmail("testeBO2@teste.com");
			userVO.setPassword("¨$&#*¨$&*");
			userVO.setStatus(StatusEnum.PENDING);
			
			assertEquals("testeBO2@teste.com", userVO.getEmail());
			
			int id = userBO.createUser(userVO);
			
			assertTrue(id > 0);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void showCheckIfUserExistByEmail() {
		final String email = "teste@teste.com";
		final User user = (User) userBO.findUserByEmail(email).getRefClassInstance();
		assertNotNull(user);
	}

}
