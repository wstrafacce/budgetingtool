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
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class UserDAOImpl implements IUserDAO {

	private final transient Configuration config = new Configuration().configure()
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Status.class);

	public List<User> findAllUsers() {

		List<User> user = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findAllUsers");
			user = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	public User findUserById(int index) {
		User user = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findUserById");
			query.setParameter("id", index);
			user = (User) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	public User findUserByEmail(String email) {
		User user = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findUserByEmail");
			query.setParameter("email", email);
			user = (User) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	public List<User> findUsersByEmailIn(Collection<String> emails) {
		List<User> users = null;
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

	public Integer insertUser(User user) {
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		Transaction tx = null;
		Integer userID = null;
		try {
			tx = session.beginTransaction();
			userID = (Integer) session.save(user);
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

	public void updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

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

	public void deleteUser(User user) {

		Session session = HibernateUtil.getSessionFactory(config).openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
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
