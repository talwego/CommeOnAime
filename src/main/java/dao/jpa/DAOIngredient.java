package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOIngredient;
import model.Ingredient;
import model.Ingredient;

public class DAOIngredient implements IDAOIngredient {

	@Override
	public List<Ingredient> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Ingredient> obj = em.createQuery("FROM ingredient").getResultList();
		em.close();
		return obj;
	}

	@Override
	public Ingredient findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Ingredient obj = em.find(Ingredient.class, id);
		em.close();
		return obj;
	}

	@Override
	public Ingredient save(Ingredient obj) {
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
		Ingredient c = em.find(Ingredient.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}
