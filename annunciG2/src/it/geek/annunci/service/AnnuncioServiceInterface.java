package it.geek.annunci.service;

import java.util.List;
import it.geek.annunci.model.Annuncio;
import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Utente;

public interface AnnuncioServiceInterface {
	
	public List<Annuncio> getWhere(Annuncio a);
	public Annuncio getAndUpdate(Annuncio a);
	public boolean buyAndUpdate(Annuncio a,Prodotto p,Utente u);
	public Annuncio get(int codice);
	public List<Annuncio> findView();
	public boolean insertAndUpdate(Annuncio a,Prodotto p,Utente u);
	
}
