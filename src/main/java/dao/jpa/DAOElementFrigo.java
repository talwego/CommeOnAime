package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOElementFrigo;
import model.ElementFrigo;

public class DAOElementFrigo implements IDAOElementFrigo {

	@Override
	public List<ElementFrigo> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<ElementFrigo> obj = em.createQuery("FROM element_frigo").getResultList();
		em.close();
		return obj;
	}

	@Override
	public ElementFrigo findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		ElementFrigo obj = em.find(ElementFrigo.class, id);
		em.close();
		return obj;
	}

	@Override
	public ElementFrigo save(ElementFrigo obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Context.getSingleton().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		ElementFrigo c = em.find(ElementFrigo.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}
