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
	name = "findAllInsertModes",
	query = "SELECT * FROM TB_INSERT_MODE ORDER BY ID",
	resultClass = InsertMode.class
	),
	
	@NamedNativeQuery(
	name = "findInsertModeById",
	query = "SELECT * FROM TB_INSERT_MODE WHERE ID = :id",
	resultClass = InsertMode.class
	)
})
@Entity
@Table(name = "TB_INSERT_MODE", catalog = "budgetingtool")
public class InsertMode {
	
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
