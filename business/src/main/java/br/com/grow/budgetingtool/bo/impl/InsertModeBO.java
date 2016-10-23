package br.com.grow.budgetingtool.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.grow.budgetingtool.bo.IInsertModeBO;
import br.com.grow.budgetingtool.model.dao.IInsertModeDAO;
import br.com.grow.budgetingtool.model.dao.impl.InsertModeDAOImpl;
import br.com.grow.budgetingtool.vo.InsertModeVO;

public class InsertModeBO implements IInsertModeBO {

	private final transient IInsertModeDAO insertModeDAO = new InsertModeDAOImpl();
	
	@Override
	public List<InsertModeVO> findAllInsertModes() {
		List<Object> insertModes = insertModeDAO.findAllInsertModes();
		List<InsertModeVO> listInsertModes = new ArrayList<InsertModeVO>();

		for (Object obj : insertModes) {
			try {
				InsertModeVO insertModeVO = new InsertModeVO(obj);
				listInsertModes.add(insertModeVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listInsertModes;
	}

	@Override
	public InsertModeVO findInsertModeById(int index) {
		InsertModeVO insertModeVO = null;

		try {
			insertModeVO = new InsertModeVO(insertModeDAO.findInsertModeById(index));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return insertModeVO;
	}

}
