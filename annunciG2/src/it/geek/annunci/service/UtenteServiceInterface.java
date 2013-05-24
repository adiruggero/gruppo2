package it.geek.annunci.service;

import java.util.List;

import it.geek.annunci.model.Utente;

public interface UtenteServiceInterface {
	
	public List<Utente> get (Utente u);
	public boolean create(Utente u);
	public Utente getId (int id);


}
