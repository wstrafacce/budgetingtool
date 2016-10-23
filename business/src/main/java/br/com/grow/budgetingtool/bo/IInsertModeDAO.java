package br.com.grow.budgetingtool.bo;

import java.util.List;

import br.com.grow.budgetingtool.vo.InsertModeVO;

public interface IInsertModeDAO {
	
	public List<InsertModeVO> findAllInsertModes();

	public InsertModeVO findInsertModeById(int index);

}
