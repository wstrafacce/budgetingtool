package br.com.grow.budgetingtool.model.dao;

import java.util.List;

import br.com.grow.budgetingtool.model.entities.Status;

public interface IStatusDAO {
	
	public List<Status> findAllStatus();

	public Status findStatusById(int index);

}
