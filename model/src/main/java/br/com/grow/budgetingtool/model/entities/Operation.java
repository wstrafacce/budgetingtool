package br.com.grow.budgetingtool.model.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import br.com.grow.budgetingtool.model.dao.impl.InsertModeDAOImpl;
import br.com.grow.budgetingtool.model.enuns.InsertModeEnum;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findAllOperations",
	query = "SELECT * FROM TB_OPERATION ODER BY ID",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationById",
	query = "SELECT * FROM TB_OPERATION WHERE ID = :id",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationByName",
	query = "SELECT * FROM TB_OPERATION WHERE NAME = :name",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByNameLike",
	query = "SELECT * FROM TB_OPERATION WHERE NAME LIKE '%:name%'",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByNameIn",
	query = "SELECT * FROM TB_OPERATION WHERE NAME IN (:nameCollection)",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByCategory",
	query = "SELECT * FROM TB_OPERATION WHERE CATEGORY = :category",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByCategoryLike",
	query = "SELECT * FROM TB_OPERATION OP INNER JOIN TB_CATEGORY CT ON OP.CATEGORY = CT.ID WHERE CT.NAME LIKE '%:category'",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByCategoryIn",
	query = "SELECT * FROM TB_OPERATION WHERE CATEGORY IN (:categoryCollection)",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByDate",
	query = "SELECT * FROM TB_OPERATION WHERE OP_DATE = :date",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByPeriod",
	query = "SELECT * FROM TB_OPERATION WHERE OP_DATE BETWEEN :startDate AND :endDate",
	resultClass = Operation.class
	),
	
	@NamedNativeQuery(
	name = "findOperationsByValue",
	query = "SELECT * FROM TB_OPERATION WHERE VALUE BETWEEN :startValue AND :endValue",
	resultClass = Operation.class
	)
})
@Entity
@Table(name = "TB_OPERATION", catalog = "budgetingtool")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "VALUE")
	private float value;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OP_DATE")
	private Timestamp date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY")
	private Category category;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INSERT_MODE")
	private InsertMode insertMode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InsertModeEnum getInsertMode() {
		return InsertModeEnum.getInsertModeEnumByIndex(insertMode.getId());
	}

	public void setInsertMode(InsertModeEnum insertModeEnum) {
		this.insertMode = new InsertModeDAOImpl().findInsertModeById(insertModeEnum.getIndex());
	}

	public int getId() {
		return id;
	}

}
