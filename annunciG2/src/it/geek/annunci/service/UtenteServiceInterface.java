package it.geek.annunci.service;

import it.geek.annunci.model.Utente;

public interface UtenteServiceInterface {
	
	public Utente get (Utente u);
	public boolean create(Utente u);
	public Utente getId (int id);

}
