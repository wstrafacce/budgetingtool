package br.com.grow.budgetingtool.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findAllStatus",
	query = "SELECT * FROM tb_status ORDER BY ID",
	resultClass = Status.class
	),
	
	@NamedNativeQuery(
	name = "findStatusById",
	query = "SELECT * FROM tb_status WHERE ID = :id",
	resultClass = Status.class
	)
})
@Entity
@Table(name = "tb_status", catalog = "budgetingtool")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
