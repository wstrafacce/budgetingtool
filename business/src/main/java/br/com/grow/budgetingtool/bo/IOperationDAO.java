package br.com.grow.budgetingtool.bo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.model.entities.Category;
import br.com.grow.budgetingtool.model.entities.Operation;
import br.com.grow.budgetingtool.vo.OperationVO;

public interface IOperationDAO {
	
	public List<OperationVO> findAllOperations();

	public OperationVO findOperationById(int index);
	
	public OperationVO findOperationByName(String name);
	
	public List<OperationVO> findOperationsByNameLike(String name);
	
	public List<OperationVO> findOperationsByNameIn(Collection<String> names);

	public OperationVO findOperationsByCategory(Category category);
	
	public List<OperationVO> findOperationsByCategoryLike(String category);
	
	public List<OperationVO> findOperationsByCategoryIn(Collection<String> categories);
	
	public List<OperationVO> findOperationsByDate(Timestamp date);
	
	public List<OperationVO> findOperationsByPeriod(Timestamp startDate, Timestamp endDate);
	
	public List<OperationVO> findOperationsByValue(float startValue, float endValue);
	
	public Integer insertOperation(Operation operation);

	public List<Integer> insertAllOperations(Collection<Operation> operations);

	public void updateManualOperation(Operation operation) throws OperationNotSupportedException;

	public List<Integer> updateAllManualOperations(Collection<Operation> operations);

	public void deleteManualOperation(Operation operation) throws OperationNotSupportedException;

	public List<Integer> deleteAllManualOperations(Collection<Operation> operations);

}
