package br.com.grow.budgetingtool.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import br.com.grow.budgetingtool.model.dao.IStatusDAO;
import br.com.grow.budgetingtool.model.entities.Status;
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class StatusDAOImpl implements IStatusDAO{

	private final transient Configuration config = new Configuration().configure()
			.addAnnotatedClass(Status.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAllStatus() {		

		List<Object> status = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		
		try {
			Query query = session.getNamedQuery("findAllStatus");
			status = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public Object findStatusById(int index) {
		Object status = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		
		try {
			Query query = session.getNamedQuery("findStatusById");
			query.setParameter("id", index);
			status = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}
	
}
