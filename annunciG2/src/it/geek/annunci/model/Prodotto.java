package it.geek.annunci.model;

import java.util.Date;

import java.io.Serializable;

public class Prodotto implements Serializable {
	
	private int codiceProdotto;
	private String descrizione;
	private int prezzo;
	private Date dataAcquisto;
	
	
	public int getCodiceProdotto() {
		return codiceProdotto;
	}
	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public Date getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	

}
