package br.com.grow.budgetingtool.bo;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import br.com.grow.budgetingtool.bo.impl.UserBO;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;
import br.com.grow.budgetingtool.vo.UserVO;

public class UserBOTest {

	@Test
	public void createUserTest() {
		try {
			UserVO userVO = new UserVO();
			userVO.setEmail("testeBO@teste.com");
			userVO.setPassword("¨$&#*¨$&*");
			userVO.setStatus(StatusEnum.PENDING);
			
			assertEquals("testeBO@teste.com", userVO.getEmail());
			
			UserBO userBO = new UserBO();
			
			int id = userBO.createUser(userVO);
			
			assertTrue(id > 0);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
