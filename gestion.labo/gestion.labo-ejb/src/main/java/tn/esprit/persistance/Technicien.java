package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import tn.esprit.persistance.Employe;

/**
 * Entity implementation class for Entity: Technicien
 *
 */
@Entity

public class Technicien extends Employe {

	
	private String specialite;
	//private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Competence> competences;

	public Technicien() {
		super();
	}   
	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
   
}
