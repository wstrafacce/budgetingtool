package br.com.grow.budgetingtool.model.dao;

import java.util.List;

public interface IStatusDAO {
	
	public List<Object> findAllStatus();

	public Object findStatusById(int index);

}
