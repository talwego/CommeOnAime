package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import context.Context;
import dao.IDAOCompte;
import model.Compte;

public class DAOCompte implements IDAOCompte{

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Compte> obj = em.createQuery("FROM compte").getResultList();
		em.close();
		return obj;
	}
	
	@Override
	public Compte findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Compte obj = em.find(Compte.class, id);
		em.close();
		return obj;
	}

	@Override
	public Compte save(Compte obj) {
		
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
		Compte c = em.find(Compte.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}

	@Override
	public Compte seConnecter(String login, String password) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Compte compte = null;

		try {

			Query requete = em.createQuery("select c from Compte c where c.login=:login and c.password=:password");
			requete.setParameter("login", login);
			requete.setParameter("password", password);
			compte = (Compte) requete.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}

		em.close();

		return compte;
	}

}
