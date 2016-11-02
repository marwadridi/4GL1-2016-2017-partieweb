package edu.esprit.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.persistance.Developpeur;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.Technicien;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	
	private Employe employe;
	
	@EJB
	EmployeServiceLocal employeServiceLocal;
	
	
	public String doLogin(){
		
		String navigateTo="";
		employe=employeServiceLocal.identifierEmploye
				(login, password);
		if(employe !=null)
		{
			if(employe instanceof Technicien)
				navigateTo="/tech/accueil";
			//forword
			if(employe instanceof Developpeur)
				navigateTo="/dev/accueil?faces-redirect=true";
			//redirection
		}
		else 
			navigateTo="/error?faces-redirect=true";
			
		
		
		return navigateTo;
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
