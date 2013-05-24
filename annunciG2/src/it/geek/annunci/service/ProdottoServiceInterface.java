package it.geek.annunci.service;

import it.geek.annunci.model.Prodotto;

import java.util.List;

public interface ProdottoServiceInterface {

	public List<Prodotto> getByWhere(Prodotto p);
	
	public Prodotto getById(int codice);
}
