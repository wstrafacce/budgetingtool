package br.com.grow.budgetingtool.model.dao;

import java.util.List;

import br.com.grow.budgetingtool.model.entities.CategoryType;

public interface ICategoryTypeDAO {
	
	public List<CategoryType> findAllCategoryTypes();

	public CategoryType findCategoryTypeById(int index);

}
