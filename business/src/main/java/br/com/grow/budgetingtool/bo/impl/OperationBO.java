package br.com.grow.budgetingtool.bo.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.bo.IOperationBO;
import br.com.grow.budgetingtool.model.dao.IOperationDAO;
import br.com.grow.budgetingtool.model.dao.impl.OperationDAOImpl;
import br.com.grow.budgetingtool.vo.CategoryVO;
import br.com.grow.budgetingtool.vo.OperationVO;
import br.com.grow.budgetingtool.vo.UserVO;

public class OperationBO implements IOperationBO {

	private final transient IOperationDAO operationDAO = new OperationDAOImpl();

	@Override
	public List<OperationVO> findAllOperations() {
		return returnOperationVOList(operationDAO.findAllOperations());
	}


	@Override
	public OperationVO findOperationById(int index) {
		OperationVO operationVO = null;

		try {
			operationVO = new OperationVO(operationDAO.findOperationById(index));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return operationVO;
	}


	@Override
	public OperationVO findOperationByName(String name, UserVO userVO) {
		OperationVO operationVO = null;

		try {
			operationVO = new OperationVO(operationDAO.findOperationByName(name, userVO.getRefClassInstance()));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return operationVO;
	}


	@Override
	public List<OperationVO> findOperationsByNameLike(String name, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByNameLike(name, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByNameIn(List<String> names, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByNameIn(names, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByCategory(CategoryVO categoryVO, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByCategory(categoryVO.getRefClassInstance(), userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByCategoryLike(String category, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByCategoryLike(category, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByCategoryIn(List<String> categories, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByCategoryIn(categories, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByDate(Timestamp date, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByDate(date, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByPeriod(Timestamp startDate, Timestamp endDate, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByPeriod(startDate, endDate, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByValue(float startValue, float endValue, UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByValue(startValue, endValue, userVO.getRefClassInstance()));
	}


	@Override
	public List<OperationVO> findOperationsByUser(UserVO userVO) {
		return returnOperationVOList(operationDAO.findOperationsByUser(userVO.getRefClassInstance()));
	}


	@Override
	public Integer insertOperation(OperationVO operationVO) {
		return operationDAO.insertOperation(operationVO.getRefClassInstance());
	}


	@Override
	public List<Integer> insertAllOperations(List<OperationVO> operations) {
		return operationDAO.insertAllOperations(returnObjectList(operations));
	}

	@Override
	public void updateManualOperation(OperationVO operationVO) throws OperationNotSupportedException {
		operationDAO.updateManualOperation(operationVO.getRefClassInstance());
	}

	@Override
	public List<Integer> updateAllManualOperations(List<OperationVO> operations) {
		return operationDAO.updateAllManualOperations(returnObjectList(operations));
	}


	@Override
	public void deleteManualOperation(OperationVO operationVO) throws OperationNotSupportedException {
		operationDAO.deleteManualOperation(operationVO.getRefClassInstance());
	}


	@Override
	public List<Integer> deleteAllManualOperations(List<OperationVO> operations) {
		return operationDAO.deleteAllManualOperations(returnObjectList(operations));
	}
	
	
	private List<OperationVO> returnOperationVOList(List<Object> operations) {
		List<OperationVO> listOperations = new ArrayList<OperationVO>();

		for (Object obj : operations) {
			try {
				OperationVO operationVO = new OperationVO(obj);
				listOperations.add(operationVO);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listOperations;
	}
	
	private List<Object> returnObjectList(List<OperationVO> operations) {
		List<Object> listOperations = new ArrayList<Object>();

		for (OperationVO operationVO : operations) {
			listOperations.add(operationVO.getRefClassInstance());
		}

		return listOperations;
	}
}