package it.geek.annunci.model;

import java.io.Serializable;

public class Ruolo implements Serializable {

	private int codiceRuolo;
	private String descrizione;
	
	
	public int getCodiceRuolo(){
		return codiceRuolo;
	}
	public void setCodiceRuolo(int codiceRuolo) {
		this.codiceRuolo = codiceRuolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
	
}
