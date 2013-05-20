package it.geek.annunci.model;


import it.geek.annunci.model.Utente;

import java.io.Serializable;
import java.util.Date;



public class Annuncio implements Serializable {

	private int codiceAnnuncio;
	private String descrizione;
	private Date dataInserimento;
	private int visite;
	private boolean stato;
	private Categoria categoria;
	private Prodotto prodotto;
	private Utente utente;
	
	
	public int getCodiceAnnuncio() {
		return codiceAnnuncio;
	}
	public void setCodiceAnnuncio(int codiceAnnuncio) {
		this.codiceAnnuncio = codiceAnnuncio;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public int getVisite() {
		return visite;
	}
	public void setVisite(int visite) {
		this.visite = visite;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	
	
}
