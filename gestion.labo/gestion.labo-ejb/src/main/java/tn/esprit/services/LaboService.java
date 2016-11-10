package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.interfaces.LaboServiceLocal;
import tn.esprit.persistance.Domaine;
import tn.esprit.persistance.Laboratoire;

/**
 * Session Bean implementation class LaboService
 */
@Stateless
@LocalBean
public class LaboService implements LaboServiceLocal {

	/**
	 * Default constructor.
	 */
	public LaboService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public void addOrUpdateLabo(Laboratoire labo) {

		em.merge(labo);

	}

	@Override
	public void deleteLabo(Laboratoire labo) {
		em.remove(em.merge(labo));
	}

	@Override
	public Laboratoire findById(int id) {
		return em.find(Laboratoire.class, id);
	}

	@Override
	public List<Laboratoire> findAll() {

		return em.createQuery("select l from Laboratoire l", Laboratoire.class).getResultList();
	}

	@Override
	public Domaine getDomaineByName(String name) {
		Domaine domaine = null;
		String jpql = "select d from Domaine d where d.nom=:x";
		try{
		domaine = em.createQuery(jpql, Domaine.class)
				.setParameter("x", name)
				.getSingleResult();
		}
		catch(NoResultException ex)
		{
			System.out.println("n'existe pas");
		}
		return domaine;
	}

	@Override
	public List<Domaine> getAllDomaines() {
		
		return em.createQuery("select d from Domaine d"
				,Domaine.class)
				.getResultList();
	}

}
