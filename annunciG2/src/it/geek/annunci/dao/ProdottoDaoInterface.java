package it.geek.annunci.dao;

import java.util.List;

import it.geek.annunci.model.Prodotto;


public interface ProdottoDaoInterface {
	
	public boolean update(Prodotto p);
	public List<Prodotto> findByWhere(Prodotto p);
	public Prodotto findById(int codice);
	public boolean insert(Prodotto p);
}
