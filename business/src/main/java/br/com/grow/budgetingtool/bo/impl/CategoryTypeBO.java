package br.com.grow.budgetingtool.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.grow.budgetingtool.bo.ICategoryTypeBO;
import br.com.grow.budgetingtool.model.dao.ICategoryTypeDAO;
import br.com.grow.budgetingtool.model.dao.impl.CategoryTypeDAOImpl;
import br.com.grow.budgetingtool.vo.CategoryTypeVO;

public class CategoryTypeBO implements ICategoryTypeBO {

	private final transient ICategoryTypeDAO categoryTypeDAO = new CategoryTypeDAOImpl();
	
	@Override
	public List<CategoryTypeVO> findAllCategoryTypes() {
		List<Object> categoryType = categoryTypeDAO.findAllCategoryTypes();
		List<CategoryTypeVO> listCategoryTypes = new ArrayList<CategoryTypeVO>();

		for (Object obj : categoryType) {
			try {
				CategoryTypeVO statusVO = new CategoryTypeVO(obj);
				listCategoryTypes.add(statusVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listCategoryTypes;
	}

	@Override
	public CategoryTypeVO findCategoryTypeById(int index) {
		CategoryTypeVO statusVO = null;

		try {
			statusVO = new CategoryTypeVO(categoryTypeDAO.findCategoryTypeById(index));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statusVO;
	}

}
