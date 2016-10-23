package br.com.grow.budgetingtool.model.dao;

import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public interface ICategoryDAO {
	
	public List<Object> findAllCategories();

	public Object findCategoryById(int index);

	public Object findCategoryByName(String name, Object userObj);

	public List<Object> findCategoriesByNameLike(String name, Object userObj);

	public List<Object> findCategoriesByNameIn(Collection<String> names, Object userObj);
	
	public List<Object> findCategoriesByUser(Object userObj);

	public Integer insertCategory(Object categoryObj) throws OperationNotSupportedException;

	public void updateCategory(Object categoryObj) throws OperationNotSupportedException;

	public void deleteCategory(Object userObj) throws OperationNotSupportedException;

}
