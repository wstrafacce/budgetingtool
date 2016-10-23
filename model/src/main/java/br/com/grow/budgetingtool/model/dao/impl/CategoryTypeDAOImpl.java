package br.com.grow.budgetingtool.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import br.com.grow.budgetingtool.model.dao.ICategoryTypeDAO;
import br.com.grow.budgetingtool.model.entities.CategoryType;
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class CategoryTypeDAOImpl implements ICategoryTypeDAO{
	
	private final transient Configuration config = new Configuration().configure().addAnnotatedClass(CategoryType.class);

	public List<CategoryType> findAllCategoryTypes() {		

		List<CategoryType> categoryTypes = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		
		try {
			Query query = session.getNamedQuery("findAllCategoryTypes");
			categoryTypes = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categoryTypes;
	}

	public CategoryType findCategoryTypeById(int index) {
		CategoryType categoryType = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		
		try {
			Query query = session.getNamedQuery("findCategoryTypeById");
			query.setParameter("id", index);
			categoryType = (CategoryType) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categoryType;
	}
}
