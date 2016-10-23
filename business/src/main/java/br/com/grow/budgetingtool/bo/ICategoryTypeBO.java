package br.com.grow.budgetingtool.bo;

import java.util.List;

import br.com.grow.budgetingtool.vo.CategoryTypeVO;

public interface ICategoryTypeBO {
	
	public List<CategoryTypeVO> findAllCategoryTypes();

	public CategoryTypeVO findCategoryTypeById(int index);

}
