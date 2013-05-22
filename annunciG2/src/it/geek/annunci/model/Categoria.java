package it.geek.annunci.model;

import java.io.Serializable;

public class Categoria implements Serializable {
	
	private int codiceCategoria;
	private String descrizione;
	
	
	public int getCodiceCategoria() {
		return codiceCategoria;
	}
	public void setCodiceCategoria(int codiceCategoria) {
		this.codiceCategoria = codiceCategoria;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categoria [codiceCategoria=" + codiceCategoria
				+ ", descrizione=" + descrizione + "]";
	}
	
	
	
	
}
