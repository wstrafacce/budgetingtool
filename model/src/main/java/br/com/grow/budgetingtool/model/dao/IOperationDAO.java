package br.com.grow.budgetingtool.model.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public interface IOperationDAO {
	
	public List<Object> findAllOperations();

	public Object findOperationById(int index);
	
	public Object findOperationByName(String name, Object userObj);
	
	public List<Object> findOperationsByNameLike(String name, Object userObj);
	
	public List<Object> findOperationsByNameIn(Collection<String> names, Object userObj);

	public List<Object> findOperationsByCategory(Object category, Object userObj);
	
	public List<Object> findOperationsByCategoryLike(String category, Object userObj);
	
	public List<Object> findOperationsByCategoryIn(Collection<String> categories, Object userObj);
	
	public List<Object> findOperationsByDate(Timestamp date, Object userObj);
	
	public List<Object> findOperationsByPeriod(Timestamp startDate, Timestamp endDate, Object userObj);
	
	public List<Object> findOperationsByValue(float startValue, float endValue, Object userObj);
	
	public List<Object> findOperationsByUser(Object userObj);
	
	public Integer insertOperation(Object operation);

	public List<Integer> insertAllOperations(Collection<Object> operations);

	public void updateManualOperation(Object operation) throws OperationNotSupportedException;

	public List<Integer> updateAllManualOperations(Collection<Object> operations);

	public void deleteManualOperation(Object operation) throws OperationNotSupportedException;

	public List<Integer> deleteAllManualOperations(Collection<Object> operations);

}
