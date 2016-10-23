package br.com.grow.budgetingtool.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.grow.budgetingtool.bo.IStatusBO;
import br.com.grow.budgetingtool.model.dao.IStatusDAO;
import br.com.grow.budgetingtool.model.dao.impl.StatusDAOImpl;
import br.com.grow.budgetingtool.vo.StatusVO;

public class StatusBO implements IStatusBO {

	private final transient IStatusDAO statusDAO = new StatusDAOImpl();

	@Override
	public List<StatusVO> findAllStatus() {
		List<Object> status = statusDAO.findAllStatus();
		List<StatusVO> listStatus = new ArrayList<StatusVO>();

		for (Object obj : status) {
			try {
				StatusVO statusVO = new StatusVO(obj);
				listStatus.add(statusVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listStatus;
	}

	@Override
	public StatusVO findStatusById(int index) {
		StatusVO statusVO = null;

		try {
			statusVO = new StatusVO(statusDAO.findStatusById(index));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statusVO;
	}

}
