package br.com.grow.budgetingtool.model.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.grow.budgetingtool.model.dao.IUserDAO;
import br.com.grow.budgetingtool.model.entities.Status;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class UserDAOImpl implements IUserDAO {

	private final transient Configuration config = new Configuration().configure()
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Status.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAllUsers() {

		List<Object> users = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findAllUsers");
			users = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public Object findUserById(int index) {
		Object user = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findUserById");
			query.setParameter("id", index);
			user = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public Object findUserByEmail(String email) {
		Object user = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findUserByEmail");
			query.setParameter("email", email);
			if (query.getResultList().isEmpty()){
				return null;
			}
			//getSingleResult considera uma query que sempre retorna resultados.
			//Ocorre 'No entity found for query Exception' se a consulta nao retornar resultados (nao encontar user com o email informado)
			user = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findUsersByEmailIn(Collection<String> emails) {
		List<Object> users = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findUsersByEmailIn");
			query.setParameter("emailCollection", emails);
			users = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public Integer insertUser(Object userObj) {
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		Transaction tx = null;
		Integer userID = null;
		try {
			tx = session.beginTransaction();
			userID = (Integer) session.save(userObj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userID;
	}

	@Override
	public void updateUser(Object userObj) {
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			User user = (User) userObj;

			User oldUser = (User) session.get(User.class, user.getId());

			if (StringUtils.isNotBlank(user.getName())) {
				oldUser.setName(user.getName());
			}

			if (StringUtils.isNotBlank(user.getLastname())) {
				oldUser.setLastname(user.getLastname());
			}

			if (StringUtils.isNotBlank(user.getPassword())) {
				oldUser.setPassword(user.getPassword());
			}

			if (user.getStatus() != null) {
				oldUser.setStatus(user.getStatus());
			}

			if (user.getPicture() != null) {
				oldUser.setPicture(user.getPicture());
			}

			session.update(oldUser);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteUser(Object userObj) {

		Session session = HibernateUtil.getSessionFactory(config).openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = (User) userObj;
			user.setStatus(StatusEnum.INACTIVE);
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
