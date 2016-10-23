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
	name = "findAllCategoryTypes",
	query = "SELECT * FROM TB_CATEGORY_TYPE ORDER BY ID",
	resultClass = CategoryType.class
	),
	
	@NamedNativeQuery(
	name = "findCategoryTypeById",
	query = "SELECT * FROM TB_CATEGORY_TYPE WHERE ID = :id",
	resultClass = CategoryType.class
	)
})
@Entity
@Table(name = "TB_CATEGORY_TYPE", catalog = "budgetingtool")
public class CategoryType {
	
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
