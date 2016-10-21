package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistance.Competence;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Laboratoire;
import tn.esprit.persistance.Technicien;

@Remote
public interface EmployeServiceRemote {

	void ajouterEmploye(Employe employe);

	void supprimerEmploye(Employe employe);

	void modifierEmploye(Employe employe);

	Employe chercherEmployeParId(int id);
	
	List<Technicien> retournerTousLesTechniciens();
	
	Employe identifierEmploye(String login, String password);
	
	void affecterContactEmploye(Contact contact, Employe employe);
	
	void ajouterContact(Contact contact);
	
	
	void affecterEmployeLaboratoire(Employe employe,Laboratoire laboratoire);
	
	void ajouterLaboratoire(Laboratoire laboratoire);
	
	
	void affecterCompetenceTechnicien(Technicien technicien, Competence competence);
	
	void ajouterCompetence(Competence competence);
	

}
