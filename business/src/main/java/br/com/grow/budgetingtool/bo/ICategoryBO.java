package br.com.grow.budgetingtool.bo;

import java.util.Collection;
import java.util.List;

import br.com.grow.budgetingtool.model.entities.Category;
import br.com.grow.budgetingtool.vo.CategoryVO;

public interface ICategoryBO {
	
	public List<CategoryVO> findAllCategories();

	public CategoryVO findCategoryById(int index);

	public CategoryVO findCategoryByName(String name);

	public List<CategoryVO> findCategoriesByNameLike(String name);

	public List<CategoryVO> findCategoriesByNameIn(Collection<String> names);

	public Integer insertCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category user);

}
