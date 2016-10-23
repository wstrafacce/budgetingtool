package br.com.grow.budgetingtool.model.dao;

import java.util.List;

public interface IInsertModeDAO {
	
	public List<Object> findAllInsertModes();

	public Object findInsertModeById(int index);

}
