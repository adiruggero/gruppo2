package it.geek.annunci.dao;

import java.util.List;
import it.geek.annunci.model.Annuncio;

public interface AnnuncioDaoInterface {

	public List<Annuncio> findByWhere(Annuncio a);
	public boolean update(Annuncio a);
	public Annuncio findById(int id);
	
}
