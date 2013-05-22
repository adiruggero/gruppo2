package it.geek.annunci.service;


import it.geek.annunci.dao.UtenteDAOInterface;
import it.geek.annunci.model.Utente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



public class UtenteService implements UtenteServiceInterface {
	
	private UtenteDAOInterface utente;
	
	public void setUtenteDao(UtenteDAOInterface utenteDao){
		this.utente = utenteDao;	
	}

	@Override
	public Utente get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}