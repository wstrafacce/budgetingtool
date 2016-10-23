package br.com.grow.budgetingtool.model.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import br.com.grow.budgetingtool.model.entities.Category;
import br.com.grow.budgetingtool.model.entities.Operation;

public interface IOperationDAO {
	
	public List<Operation> findAllOperations();

	public Operation findOperationById(int index);
	
	public Operation findOperationByName(String name);
	
	public List<Operation> findOperationsByNameLike(String name);
	
	public List<Operation> findOperationsByNameIn(Collection<String> names);

	public Operation findOperationsByCategory(Category category);
	
	public List<Operation> findOperationsByCategoryLike(String category);
	
	public List<Operation> findOperationsByCategoryIn(Collection<String> categories);
	
	public List<Operation> findOperationsByDate(Timestamp date);
	
	public List<Operation> findOperationsByPeriod(Timestamp startDate, Timestamp endDate);
	
	public List<Operation> findOperationsByValue(float startValue, float endValue);
	
	public Integer insertOperation(Operation operation);

	public List<Integer> insertAllOperations(Collection<Operation> operations);

	public void updateManualOperation(Operation operation) throws OperationNotSupportedException;

	public List<Integer> updateAllManualOperations(Collection<Operation> operations);

	public void deleteManualOperation(Operation operation) throws OperationNotSupportedException;

	public List<Integer> deleteAllManualOperations(Collection<Operation> operations);

}
