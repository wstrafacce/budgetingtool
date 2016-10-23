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
	public Object findOperationByName(String name) {
		Object operation = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationByName");
			query.setParameter("name", name);
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
	public List<Object> findOperationsByNameLike(String name) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByNameLike");
			query.setParameter("name", name);
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
	public List<Object> findOperationsByNameIn(Collection<String> names) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByNameIn");
			query.setParameter("nameCollection", names);
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}

	@Override
	public Object findOperationsByCategory(Category category) {
		Object operation = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByCategory");
			query.setParameter("category", category.getName());
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
	public List<Object> findOperationsByCategoryLike(String category) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByCategoryLike");
			query.setParameter("category", category);
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
	public List<Object> findOperationsByCategoryIn(Collection<String> categories) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByCategoryIn");
			query.setParameter("categoryCollection", categories);
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
	public List<Object> findOperationsByDate(Timestamp date) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByDate");
			query.setParameter("date", date.toString());
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
	public List<Object> findOperationsByPeriod(Timestamp startDate, Timestamp endDate) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByPeriod");
			query.setParameter("startDate", startDate.toString());
			query.setParameter("endDate", endDate.toString());
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
	public List<Object> findOperationsByValue(float startValue, float endValue) {
		List<Object> operations = null;
		Session session = HibernateUtil.getSessionFactory(config).openSession();

		try {
			Query query = session.getNamedQuery("findOperationsByValue");
			query.setParameter("startDate", startValue);
			query.setParameter("endDate", endValue);
			operations = query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return operations;
	}
	
	@Override
	public Integer insertOperation(Operation operation) {
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
	public List<Integer> insertAllOperations(Collection<Operation> operations) {
		Session session = HibernateUtil.getSessionFactory(config).openSession();
		Transaction tx = null;
		List<Integer> operationIDs = new ArrayList<Integer>();

		for (Operation operation : operations) {
			try {
				tx = session.beginTransaction();
				operationIDs.add((Integer) session.save(operation));
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}

		session.close();
		return operationIDs;
	}

	@Override
	public void updateManualOperation(Operation operation) throws OperationNotSupportedException {
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
	public List<Integer> updateAllManualOperations(Collection<Operation> operations) {
		Session session = null;
		List<Integer> operationIDs = null;

		for (Operation operation : operations) {
			if (InsertModeEnum.MANUAL.equals(operation.getInsertMode())) {

				if (session == null) {
					session = HibernateUtil.getSessionFactory(config).openSession();
					operationIDs = new ArrayList<Integer>();
				}

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
					operationIDs.add(oldOperation.getId());
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}
			}
		}

		if (session != null) {
			session.close();
		}

		return operationIDs;
	}

	@Override
	public void deleteManualOperation(Operation operation) throws OperationNotSupportedException {
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
	public List<Integer> deleteAllManualOperations(Collection<Operation> operations) {
		Session session = null;
		List<Integer> operationIDs = null;

		for (Operation operation : operations) {
			if (InsertModeEnum.MANUAL.equals(operation.getInsertMode())) {
				
				if (session == null) {
					session = HibernateUtil.getSessionFactory(config).openSession();
					operationIDs = new ArrayList<Integer>();
				}
				
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					session.delete(operation);
					operationIDs.add(operation.getId());
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

		if (session != null) {
			session.close();
		}
		
		return operationIDs;
	}

}
