package br.com.grow.budgetingtool.model.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.model.entities.Category;
import br.com.grow.budgetingtool.model.entities.Operation;

public interface IOperationDAO {
	
	public List<Object> findAllOperations();

	public Object findOperationById(int index);
	
	public Object findOperationByName(String name);
	
	public List<Object> findOperationsByNameLike(String name);
	
	public List<Object> findOperationsByNameIn(Collection<String> names);

	public Object findOperationsByCategory(Category category);
	
	public List<Object> findOperationsByCategoryLike(String category);
	
	public List<Object> findOperationsByCategoryIn(Collection<String> categories);
	
	public List<Object> findOperationsByDate(Timestamp date);
	
	public List<Object> findOperationsByPeriod(Timestamp startDate, Timestamp endDate);
	
	public List<Object> findOperationsByValue(float startValue, float endValue);
	
	public Integer insertOperation(Operation operation);

	public List<Integer> insertAllOperations(Collection<Operation> operations);

	public void updateManualOperation(Operation operation) throws OperationNotSupportedException;

	public List<Integer> updateAllManualOperations(Collection<Operation> operations);

	public void deleteManualOperation(Operation operation) throws OperationNotSupportedException;

	public List<Integer> deleteAllManualOperations(Collection<Operation> operations);

}
