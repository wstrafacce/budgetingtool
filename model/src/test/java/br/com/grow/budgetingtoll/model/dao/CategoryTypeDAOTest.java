package br.com.grow.budgetingtoll.model.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.grow.budgetingtool.model.dao.impl.CategoryTypeDAOImpl;
import br.com.grow.budgetingtool.model.entities.CategoryType;

public class CategoryTypeDAOTest {
	
	@Test
	@Ignore
	public void listAllTest() {
		CategoryTypeDAOImpl dao = new CategoryTypeDAOImpl();
		List<Object> entity = dao.findAllCategoryTypes();
		assertArrayEquals(new String[]{"INCOME", "EXPENSE"}, new String[]{((CategoryType) entity.get(0)).getName(), ((CategoryType) entity.get(1)).getName()});
	}
	
	@Test
	@Ignore
	public void getByIdTest() {
		CategoryTypeDAOImpl dao = new CategoryTypeDAOImpl();
		CategoryType entity = (CategoryType) dao.findCategoryTypeById(2);
		assertEquals("EXPENSE", entity.getName());
	}
}
