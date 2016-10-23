package br.com.grow.budgetingtool.bo;

import java.sql.Timestamp;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.vo.CategoryVO;
import br.com.grow.budgetingtool.vo.OperationVO;
import br.com.grow.budgetingtool.vo.UserVO;

public interface IOperationBO {
	
	public List<OperationVO> findAllOperations();

	public OperationVO findOperationById(int index);
	
	public OperationVO findOperationByName(String name, UserVO userVO);
	
	public List<OperationVO> findOperationsByNameLike(String name, UserVO userVO);
	
	public List<OperationVO> findOperationsByNameIn(List<String> names, UserVO userVO);

	public List<OperationVO> findOperationsByCategory(CategoryVO categoryVO, UserVO userVO);
	
	public List<OperationVO> findOperationsByCategoryLike(String category, UserVO userVO);
	
	public List<OperationVO> findOperationsByCategoryIn(List<String> categories, UserVO userVO);
	
	public List<OperationVO> findOperationsByDate(Timestamp date, UserVO userVO);
	
	public List<OperationVO> findOperationsByPeriod(Timestamp startDate, Timestamp endDate, UserVO userVO);
	
	public List<OperationVO> findOperationsByValue(float startValue, float endValue, UserVO userVO);
	
	public List<OperationVO> findOperationsByUser(UserVO userVO);
	
	public Integer insertOperation(OperationVO operationVO);

	public List<Integer> insertAllOperations(List<OperationVO> operations);

	public void updateManualOperation(OperationVO operationVO) throws OperationNotSupportedException;

	public List<Integer> updateAllManualOperations(List<OperationVO> operations);

	public void deleteManualOperation(OperationVO operationVO) throws OperationNotSupportedException;

	public List<Integer> deleteAllManualOperations(List<OperationVO> operations);

}
