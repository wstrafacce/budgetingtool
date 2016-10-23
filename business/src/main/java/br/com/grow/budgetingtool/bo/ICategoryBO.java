package br.com.grow.budgetingtool.bo;

import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.vo.CategoryVO;
import br.com.grow.budgetingtool.vo.UserVO;

public interface ICategoryBO {
	
	public List<CategoryVO> findAllCategories();

	public CategoryVO findCategoryById(int index);

	public CategoryVO findCategoryByName(String name, UserVO userVO);

	public List<CategoryVO> findCategoriesByNameLike(String name, UserVO userVO);

	public List<CategoryVO> findCategoriesByNameIn(Collection<String> names, UserVO userVO);
	
	public List<CategoryVO> findCategoriesUser(UserVO user);

	public Integer createCategory(CategoryVO categoryVO) throws OperationNotSupportedException;

	public void updateCategory(CategoryVO categoryVO) throws OperationNotSupportedException;

	public void deleteCategory(CategoryVO categoryVO) throws OperationNotSupportedException;

}
