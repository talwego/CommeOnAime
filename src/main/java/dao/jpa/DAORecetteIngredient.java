package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOIngredient;
import dao.IDAORecette;
import dao.IDAORecetteIngredient;
import model.RecetteIngredient;
import model.RecetteIngredient;

public class DAORecetteIngredient implements IDAORecetteIngredient {

	@Override
	public List<RecetteIngredient> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<RecetteIngredient> obj = em.createQuery("from RecetteIngredient").getResultList();
		em.close();
		return obj;
	}

	@Override
	public RecetteIngredient findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		RecetteIngredient obj = em.find(RecetteIngredient.class, id);
		em.close();
		return obj;
	}

	@Override
	public RecetteIngredient save(RecetteIngredient obj) {
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
		RecetteIngredient c = em.find(RecetteIngredient.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}
