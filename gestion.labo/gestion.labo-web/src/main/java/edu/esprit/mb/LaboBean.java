package edu.esprit.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.interfaces.LaboServiceLocal;
import tn.esprit.persistance.Domaine;
import tn.esprit.persistance.Laboratoire;

@ManagedBean
@ViewScoped
public class LaboBean implements Serializable {

	private List<Laboratoire> laboratoires = new ArrayList<Laboratoire>();

	private Laboratoire laboratoire = new Laboratoire();

	private boolean displayForm;
	
	private List<Domaine> domaines;

	@EJB
	LaboServiceLocal laboServiceLocal;

	@PostConstruct
	public void init() {
		laboratoires = laboServiceLocal.findAll();
		domaines= laboServiceLocal.getAllDomaines();
	}

	public void doAdd() {
		laboServiceLocal.addOrUpdateLabo(laboratoire);
		laboratoire = new Laboratoire();
		init();
		setDisplayForm(false);
	}

	public void doDelete() {
		laboServiceLocal.deleteLabo(laboratoire);
		laboratoire = new Laboratoire();
		init();
		setDisplayForm(false);
	}

	public void doCancel() {
		laboratoire = new Laboratoire();
		setDisplayForm(false);

	}

	public void doNew() {
		laboratoire = new Laboratoire();
		setDisplayForm(true);
	}

	public List<Laboratoire> getLaboratoires() {
		return laboratoires;
	}

	public void setLaboratoires(List<Laboratoire> laboratoires) {
		this.laboratoires = laboratoires;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public boolean isDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(boolean displayForm) {
		this.displayForm = displayForm;
	}

	public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

}
