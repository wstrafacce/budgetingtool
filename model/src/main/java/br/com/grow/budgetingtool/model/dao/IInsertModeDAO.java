package br.com.grow.budgetingtool.model.dao;

import java.util.List;

import br.com.grow.budgetingtool.model.entities.InsertMode;

public interface IInsertModeDAO {
	
	public List<InsertMode> findAllInsertModes();

	public InsertMode findInsertModeById(int index);

}
