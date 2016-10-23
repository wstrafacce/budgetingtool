package br.com.grow.budgetingtool.model.dao;

import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.model.entities.Category;

public interface ICategoryDAO {
	
	public List<Object> findAllCategories();

	public Object findCategoryById(int index);

	public Object findCategoryByName(String name);

	public List<Object> findCategoriesByNameLike(String name);

	public List<Object> findCategoriesByNameIn(Collection<String> names);

	public Integer insertCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category user);

}
