package br.com.grow.budgetingtool.bo.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.bo.ICategoryBO;
import br.com.grow.budgetingtool.model.dao.ICategoryDAO;
import br.com.grow.budgetingtool.model.dao.impl.CategoryDAOImpl;
import br.com.grow.budgetingtool.vo.CategoryVO;
import br.com.grow.budgetingtool.vo.UserVO;

public class CategoryBO implements ICategoryBO {

	private final transient ICategoryDAO categoryDAO = new CategoryDAOImpl();
	
	@Override
	public List<CategoryVO> findAllCategories() {
		return returnCategoryVOList(categoryDAO.findAllCategories());
	}

	@Override
	public CategoryVO findCategoryById(int index) {
		CategoryVO categoryVO = null;

		try {
			categoryVO = new CategoryVO(categoryDAO.findCategoryById(index));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryVO;
	}

	@Override
	public CategoryVO findCategoryByName(String name, UserVO userVO) {
		CategoryVO categoryVO = null;

		try {
			categoryVO = new CategoryVO(categoryDAO.findCategoryByName(name, userVO.getRefClassInstance()));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryVO;
	}

	@Override
	public List<CategoryVO> findCategoriesByNameLike(String name, UserVO userVO) {
		return returnCategoryVOList(categoryDAO.findCategoriesByNameLike(name, userVO.getRefClassInstance()));
	}

	@Override
	public List<CategoryVO> findCategoriesByNameIn(Collection<String> names, UserVO userVO) {
		return returnCategoryVOList(categoryDAO.findCategoriesByNameIn(names,userVO.getRefClassInstance()));
	}
	
	@Override
	public List<CategoryVO> findCategoriesUser(UserVO user) {
		return returnCategoryVOList(categoryDAO.findCategoriesByUser(user.getRefClassInstance()));
	}
	
	@Override
	public Integer createCategory(CategoryVO categoryVO) throws OperationNotSupportedException {
		return categoryDAO.insertCategory(categoryVO.getRefClassInstance());
	}

	@Override
	public void updateCategory(CategoryVO categoryVO) throws OperationNotSupportedException {
		categoryDAO.updateCategory(categoryVO.getRefClassInstance());
	}

	@Override
	public void deleteCategory(CategoryVO categoryVO) throws OperationNotSupportedException {
		categoryDAO.deleteCategory(categoryVO.getRefClassInstance());
	}
	
	private List<CategoryVO> returnCategoryVOList(List<Object> categories) {
		List<CategoryVO> listUsers = new ArrayList<CategoryVO>();

		for (Object obj : categories) {
			try {
				CategoryVO categoryVO = new CategoryVO(obj);
				listUsers.add(categoryVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listUsers;
	}

}
