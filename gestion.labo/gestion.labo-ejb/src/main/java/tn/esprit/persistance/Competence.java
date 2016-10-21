package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Competence
 *
 */
@Entity

public class Competence implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="competences")
	private List<Technicien> techniciens;
	public Competence() {
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
	public List<Technicien> getTechniciens() {
		return techniciens;
	}
	public void setTechniciens(List<Technicien> techniciens) {
		this.techniciens = techniciens;
	}
   
}
