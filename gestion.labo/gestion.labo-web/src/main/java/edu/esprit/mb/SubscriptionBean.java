package edu.esprit.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.persistance.Contact;
import tn.esprit.persistance.Developpeur;

@ManagedBean
@ViewScoped
public class SubscriptionBean  implements Serializable{
	
	private Developpeur developpeur = new Developpeur();
	private Contact contact = new Contact();
	
	@EJB
	EmployeServiceLocal employeServiceLocal;
	
	
	public void doSubscribe(){
		
		developpeur.setContact(contact);
		employeServiceLocal.ajouterEmploye(developpeur);
		
	}
	
	public Developpeur getDeveloppeur() {
		return developpeur;
	}
	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	

}
