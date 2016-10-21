package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.interfaces.EmployeServiceRemote;
import tn.esprit.persistance.Competence;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Laboratoire;
import tn.esprit.persistance.Technicien;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote, EmployeServiceLocal {

	public EmployeService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "gestion.labo-ejb")
	EntityManager em;

	@Override
	public void ajouterEmploye(Employe employe) {
		em.persist(employe);
	}

	@Override
	public void supprimerEmploye(Employe employe) {
		em.remove(em.merge(employe));
	}

	@Override
	public void modifierEmploye(Employe employe) {
		em.merge(employe);
	}

	@Override
	public Employe chercherEmployeParId(int id) {
		return em.find(Employe.class, id);
	}

	@Override
	public List<Technicien> retournerTousLesTechniciens() {

		String requete = "select t from Technicien t";

		return em.createQuery(requete, Technicien.class).getResultList();
	}

	@Override
	public Employe identifierEmploye(String login, String password) {
		Employe emp = null;
		String requete = "select e from Employe e where e.login=:x and e.password=:y ";
		try {
			emp = em.createQuery(requete, Employe.class).setParameter("x", login)
					.setParameter("y", password)
					.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("aucun objet avec ce login et ce mdp");
		}

		return emp;
	}

	@Override
	public void affecterContactEmploye(Contact contact, Employe employe) {
		
		employe.setContact(contact);
		em.merge(employe);
		
		
	}

	@Override
	public void ajouterContact(Contact contact) {
		em.persist(contact);
		
	}

	@Override
	public void affecterEmployeLaboratoire(Employe employe, Laboratoire laboratoire) {
		
		employe.setLaboratoire(laboratoire);
		em.merge(employe);
		
	}

	@Override
	public void ajouterLaboratoire(Laboratoire laboratoire) {
		em.persist(laboratoire);
		
	}

	@Override
	public void affecterCompetenceTechnicien(Technicien technicien, Competence competence) {
		
		
		if(technicien.getCompetences()==null)
		{
			technicien.setCompetences(new ArrayList<>());
		}
		
		technicien.getCompetences().add(competence);
		em.merge(technicien);
		
	}

	@Override
	public void ajouterCompetence(Competence competence) {
			em.persist(competence);
	}

}
