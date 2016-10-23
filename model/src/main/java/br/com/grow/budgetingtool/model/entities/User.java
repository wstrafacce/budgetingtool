package br.com.grow.budgetingtool.model.entities;

import java.io.File;

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

import br.com.grow.budgetingtool.model.dao.impl.StatusDAOImpl;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findAllUsers",
	query = "SELECT * FROM TB_USER ORDER BY NAME",
	resultClass = User.class
	),
	
	@NamedNativeQuery(
	name = "findUserById",
	query = "SELECT * FROM TB_USER WHERE ID = :id",
	resultClass = User.class
	),
	
	@NamedNativeQuery(
	name = "findUserByEmail",
	query = "SELECT * FROM TB_USER WHERE EMAIL = :email",
	resultClass = User.class
	),
	
	@NamedNativeQuery(
	name = "findUsersByEmailIn",
	query = "SELECT * FROM TB_USER WHERE EMAIL IN (:emailCollection) ORDER BY NAME",
	resultClass = User.class
	)
})
@Entity
@Table(name = "TB_USER", catalog = "budgetingtool")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATUS")
	private Status status;

	@Column(name = "PICTURE")
	private File picture;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public StatusEnum getStatus() {
		return StatusEnum.getStatusEnumByIndex(status.getId());
	}

	public void setStatus(StatusEnum statusEnum) {
		this.status = (Status) new StatusDAOImpl().findStatusById(statusEnum.getIndex());
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}
	
}
