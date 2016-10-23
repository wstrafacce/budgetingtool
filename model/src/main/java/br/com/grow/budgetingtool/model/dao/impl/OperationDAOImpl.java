package br.com.grow.budgetingtool.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.grow.budgetingtool.model.dao.IOperationDAO;
import br.com.grow.budgetingtool.model.entities.Category;
import br.com.grow.budgetingtool.model.entities.InsertMode;
import br.com.grow.budgetingtool.model.entities.Operation;
import br.com.grow.budgetingtool.model.entities.User;
import br.com.grow.budgetingtool.model.enuns.InsertModeEnum;
import br.com.grow.budgetingtool.model.util.HibernateUtil;

public class OperationDAOImpl implements IOperationDAO{

	private final transient Configuration config = new Configuration().configure()
			.addAnnotatedClass(Operation.class)
			.addAnnotatedClass(Category.class)
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(InsertMode.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAllOperations() {

		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findAllOperations");
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}

	@Override
	public Object findOperationById(int index) {
		Object operation = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationById");
			query.setParameter("id", index);
			operation = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operation;
	}
	
	@Override
	public Object findOperationByName(String name, Object userObj) {
		Object operation = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationByName");
			query.setParameter("name", name);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operation = query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operation;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByNameLike(String name, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByNameLike");
			query.setParameter("name", name);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByNameIn(Collection<String> names, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByNameIn");
			query.setParameter("nameCollection", names);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByCategory(Object categoryObj, Object userObj) {
		List<Object> operation = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByCategory");
			Category category = (Category) categoryObj;
			query.setParameter("category", category.getId());
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operation = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operation;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByCategoryLike(String category, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByCategoryLike");
			query.setParameter("category", category);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByCategoryIn(Collection<String> categories, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByCategoryIn");
			query.setParameter("categoryCollection", categories);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByDate(Timestamp date, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByDate");
			query.setParameter("date", date.toString());
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByPeriod(Timestamp startDate, Timestamp endDate, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByPeriod");
			query.setParameter("startDate", startDate.toString());
			query.setParameter("endDate", endDate.toString());
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByValue(float startValue, float endValue, Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByValue");
			query.setParameter("startValue", startValue);
			query.setParameter("endValue", endValue);
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findOperationsByUser(Object userObj) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByUser");
			User user = (User) userObj;
			query.setParameter("user", user.getId());
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@Override
	public Integer insertOperation(Object operation) {
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		Transaction tx = null;
		Integer operationID = null;
		try {
			tx = session.beginTransaction();
			operationID = (Integer) session.save(operation);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operationID;
	}

	@Override
	public List<Integer> insertAllOperations(Collection<Object> operations) {
		List<Integer> operationIDs = null;
		for (Object operation : operations) {
				int operationId = insertOperation(operation);
				
				if (operationIDs == null){
					operationIDs = new ArrayList<Integer>();
				}
				
				operationIDs.add(operationId);
		}

		return operationIDs;
	}

	@Override
	public void updateManualOperation(Object operationObj) throws OperationNotSupportedException {
		Operation operation = (Operation) operationObj;
		if (InsertModeEnum.MANUAL.equals(operation.getInsertMode())) {
			Session session = HibernateUtil.getSessionFactory(config).openSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				Operation oldOperation = (Operation) session.get(Operation.class, operation.getId());

				if (StringUtils.isNotBlank(operation.getName())) {
					oldOperation.setName(operation.getName());
				}

				if (operation.getValue() != 0.0) {
					oldOperation.setValue(operation.getValue());
				}

				if (operation.getDate() != null) {
					oldOperation.setDate(operation.getDate());
				}

				if (operation.getCategory() != null) {
					oldOperation.setCategory(operation.getCategory());
				}

				session.update(oldOperation);

				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			throw new OperationNotSupportedException("This operation is not suported for acounts registers!");
		}
	}

	@Override
	public List<Integer> updateAllManualOperations(Collection<Object> operations) {
		List<Integer> operationIDs = null;

		for (Object operationObj : operations) {
			try {
				updateManualOperation(operationObj);
				
				if (operationIDs == null){
					operationIDs = new ArrayList<Integer>();
				}
				Operation operation = (Operation) operationObj;
				operationIDs.add(operation.getId());
			} catch (OperationNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return operationIDs;
	}

	@Override
	public void deleteManualOperation(Object operationObj) throws OperationNotSupportedException {
		Operation operation = (Operation) operationObj;
		if (InsertModeEnum.MANUAL.equals(operation.getInsertMode())) {

			Session session = HibernateUtil.getSessionFactory(config).openSession();

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(operation);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			throw new OperationNotSupportedException("This operation is not suported for acounts registers!");
		}

	}

	@Override
	public List<Integer> deleteAllManualOperations(Collection<Object> operations) {
		List<Integer> operationIDs = null;

		for (Object operationObj : operations) {
			try {
				deleteManualOperation(operationObj);
				
				if (operationIDs == null){
					operationIDs = new ArrayList<Integer>();
				}
				Operation operation = (Operation) operationObj;
				operationIDs.add(operation.getId());
			} catch (OperationNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return operationIDs;
	}

}
