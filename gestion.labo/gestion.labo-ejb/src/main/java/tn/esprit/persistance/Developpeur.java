package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.persistance.Employe;

/**
 * Entity implementation class for Entity: Developpeur
 *
 */
@Entity

public class Developpeur extends Employe implements Serializable {

	
	private String domaine;
	private static final long serialVersionUID = 1L;

	public Developpeur() {
		super();
	}   
	public String getDomaine() {
		return this.domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
   
}
