package it.geek.annunci.dao;

import it.geek.annunci.model.Utente;
import java.util.List;

public interface UtenteDaoInterface {

	public List<Utente> findByWhere(Utente u);
	public boolean update(Utente u);
	public List<Utente> findAll();
	public void delete (int id);
	
}
