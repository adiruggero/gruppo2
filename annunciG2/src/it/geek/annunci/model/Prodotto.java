package it.geek.annunci.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.Serializable;

public class Prodotto implements Serializable {
	
	private int codiceProdotto;
	private String descrizione;
	private int prezzo;
	private Date dataAcquisto;
	private Utente acquirente;
	
	
	
	
	/**
	 * @return the acquirente
	 */
	public Utente getAcquirente() {
		return acquirente;
	}
	/**
	 * @param acquirente the acquirente to set
	 */
	public void setAcquirente(Utente acquirente) {
		this.acquirente = acquirente;
	}
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
	public String getDataAcquistoFormatted(){
		String data="";
		if(dataAcquisto!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.format(dataAcquisto);
		}
		return data;
	}
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prodotto [codiceProdotto=" + codiceProdotto + ", descrizione="
				+ descrizione + ", prezzo=" + prezzo + ", dataAcquisto="
				+ dataAcquisto + "]";
	}
	
	

}
