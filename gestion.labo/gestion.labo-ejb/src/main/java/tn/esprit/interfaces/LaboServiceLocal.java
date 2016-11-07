package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.persistance.Laboratoire;

@Local
public interface LaboServiceLocal {
	
	void addOrUpdateLabo(Laboratoire labo);
	void deleteLabo(Laboratoire labo);
	Laboratoire findById(int id);
	List<Laboratoire> findAll();
	

}
