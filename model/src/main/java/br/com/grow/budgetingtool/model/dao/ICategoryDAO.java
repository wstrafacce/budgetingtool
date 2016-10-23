package br.com.grow.budgetingtool.model.dao;

import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.model.entities.Category;

public interface ICategoryDAO {
	
	public List<Category> findAllCategories();

	public Category findCategoryById(int index);

	public Category findCategoryByName(String name);

	public List<Category> findCategoriesByNameLike(String name);

	public List<Category> findCategoriesByNameIn(Collection<String> names);

	public Integer insertCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category user);

}
