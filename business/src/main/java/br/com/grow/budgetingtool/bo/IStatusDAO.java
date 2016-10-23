package br.com.grow.budgetingtool.bo;

import java.util.List;

import br.com.grow.budgetingtool.vo.StatusVO;

public interface IStatusDAO {
	
	public List<StatusVO> findAllStatus();

	public StatusVO findStatusById(int index);

}