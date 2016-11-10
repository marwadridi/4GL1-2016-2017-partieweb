package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Laboratoire
 *
 */
@Entity

public class Laboratoire implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String adresse;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "laboratoire")
	private List<Employe> employes;
	@ManyToOne
	private Domaine domaine;

	public Laboratoire() {
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

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

}
