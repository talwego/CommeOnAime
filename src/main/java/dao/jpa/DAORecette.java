package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOIngredient;
import dao.IDAORecette;
import model.Recette;
import model.Recette;

public class DAORecette implements IDAORecette {

	@Override
	public List<Recette> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Recette> obj = em.createQuery("from Recette").getResultList();
		em.close();
		return obj;
	}

	@Override
	public Recette findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Recette obj = em.find(Recette.class, id);
		em.close();
		return obj;
	}

	@Override
	public Recette save(Recette obj) {
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
		Recette c = em.find(Recette.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}
