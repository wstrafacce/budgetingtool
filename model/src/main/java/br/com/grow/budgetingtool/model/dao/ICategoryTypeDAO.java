package br.com.grow.budgetingtool.model.dao;

import java.util.List;

public interface ICategoryTypeDAO {
	
	public List<Object> findAllCategoryTypes();

	public Object findCategoryTypeById(int index);

}
