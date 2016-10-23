package br.com.grow.budgetingtool.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import br.com.grow.budgetingtool.model.dao.impl.CategoryTypeDAOImpl;
import br.com.grow.budgetingtool.model.enuns.CategoryTypeEnum;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findAllCategories",
	query = "SELECT * FROM TB_CATEGORY ODER BY ID",
	resultClass = Category.class
	),
	
	@NamedNativeQuery(
	name = "findCategoryById",
	query = "SELECT * FROM TB_CATEGORY WHERE ID = :id",
	resultClass = Category.class
	),
	
	@NamedNativeQuery(
	name = "findCategoyByName",
	query = "SELECT * FROM TB_CATEGORY WHERE NAME = :name",
	resultClass = Category.class
	),
	
	@NamedNativeQuery(
	name = "findCategoriesByNameLike",
	query = "SELECT * FROM TB_CATEGORY WHERE NAME LIKE '%:name%'",
	resultClass = Category.class
	),
	
	@NamedNativeQuery(
	name = "findCategoriesByNameIn",
	query = "SELECT * FROM TB_CATEGORY WHERE NAME IN (:nameCollection)",
	resultClass = Category.class
	)
})
@Entity
@Table(name = "TB_CATEGORY", catalog = "budgetingtool")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TYPE")
	private CategoryType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryTypeEnum getType() {
		return CategoryTypeEnum.getCategoryTypeEnumByIndex(type.getId());
	}

	public void setType(CategoryTypeEnum typeEnum) {
		this.type = new CategoryTypeDAOImpl().findCategoryTypeById(typeEnum.getIndex());
	}

	public int getId() {
		return id;
	}
}
