package br.com.grow.budgetingtool.model.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.grow.budgetingtool.model.dao.ICategoryDAO;
import br.com.grow.budgetingtool.model.entities.Category;
import br.com.grow.budgetingtool.model.entities.CategoryType;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class CategoryDAOImpl implements ICategoryDAO {

	private final transient Configuration config = new Configuration().configure().addAnnotatedClass(Category.class)
			.addAnnotatedClass(CategoryType.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAllCategories() {

		List<Object> categories = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findAllCategories");
			categories = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categories;
	}

	@Override
	public Object findCategoryById(int index) {
		Object category = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findCategoryById");
			query.setParameter("id", index);
			category = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return category;
	}

	@Override
	public Object findCategoryByName(String name, Object userObj) {
		Object category = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findCategoryByName");
			query.setParameter("name", name);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			category = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findCategoriesByNameLike(String name, Object userObj) {
		List<Object> categories = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findCategoriesByNameLike");
			query.setParameter("name", name);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			categories = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categories;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findCategoriesByNameIn(Collection<String> names, Object userObj) {
		List<Object> categories = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findCategoriesByNameIn");
			query.setParameter("nameCollection", names);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			categories = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categories;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findCategoriesByUser(Object userObj) {
		List<Object> categories = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findCategoriesByUser");
			query.setParameter("user", userObj);
			categories = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categories;
	}

	@Override
	public Integer insertCategory(Object categoryObj) throws OperationNotSupportedException {
		Integer categoryID = null;
		Category category = (Category) categoryObj;
		if (category.getUser() != null) {
			Session session = HibernateUtil.getSessionFactory(config).openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				categoryID = (Integer) session.save(categoryObj);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			throw new OperationNotSupportedException("This operation is not suported for registers without user!");
		}

		return categoryID;
	}

	@Override
	public void updateCategory(Object categoryObj) throws OperationNotSupportedException {
		Category category = (Category) categoryObj;
		if (category.getUser() != null) {
			Session session = HibernateUtil.getSessionFactory(config).openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				Category oldCategory = (Category) session.get(Category.class, category.getId());

				if (StringUtils.isNotBlank(category.getName())) {
					oldCategory.setName(category.getName());
				}

				if (category.getType() != null) {
					oldCategory.setType(category.getType());
				}

				session.update(oldCategory);

				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			throw new OperationNotSupportedException("This operation is not suported for registers without user!");
		}
	}

	@Override
	public void deleteCategory(Object categoryObj) throws OperationNotSupportedException {
		Category category = (Category) categoryObj;
		if (category.getUser() != null) {
			Session session = HibernateUtil.getSessionFactory(config).openSession();

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(categoryObj);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			throw new OperationNotSupportedException("This operation is not suported for registers without user!");
		}
	}

}
