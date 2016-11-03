package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity

public class Employe {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int cin;
	private String login;
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	//private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Contact contact;
	
	@ManyToOne
	private Laboratoire laboratoire;

	public Employe() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Laboratoire getLaboratoire() {
		return laboratoire;
	}
	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

   
}
