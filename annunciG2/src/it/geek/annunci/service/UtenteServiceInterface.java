package it.geek.resid.service;

import java.sql.Connection;
import java.util.List;

import it.geek.resid.model.Utente;

public interface UtenteServiceInterface {
	
	public Utente get (String id);
	public boolean create (Utente u);
	public List<Utente> getAll();
	public boolean modificaMultipla(int codice,String[]selezionati);

}
