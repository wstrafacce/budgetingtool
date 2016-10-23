package br.com.grow.budgetingtool.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import br.com.grow.budgetingtool.model.dao.IInsertModeDAO;
import br.com.grow.budgetingtool.model.entities.InsertMode;
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class InsertModeDAOImpl implements IInsertModeDAO{
	
	private final transient Configuration config = new Configuration().configure().addAnnotatedClass(InsertMode.class);

	public List<InsertMode> findAllInsertModes() {		

		List<InsertMode> insertMode = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		
		try {
			Query query = session.getNamedQuery("findAllInsertModes");
			insertMode = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return insertMode;
	}

	public InsertMode findInsertModeById(int index) {
		InsertMode insertMode = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		
		try {
			Query query = session.getNamedQuery("findInsertModeById");
			query.setParameter("id", index);
			insertMode = (InsertMode) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return insertMode;
	}

}
