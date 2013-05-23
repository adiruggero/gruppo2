package it.geek.annunci.model;

import java.text.SimpleDateFormat;
import it.geek.annunci.model.Utente;
import java.io.Serializable;
import java.util.Date;



public class Annuncio implements Serializable {

	private int codiceAnnuncio;
	private String descrizione;
	private Date dataInserimento;
	private Integer visite;
	private boolean stato;
	private Categoria categoria;
	private Prodotto prodotto;
	private Utente utente;
	
	
	public String getDataInserimentoFormatted(){
		String data="";
		if(dataInserimento!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.format(dataInserimento);
		}
		return data;
	}
	

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
	public Integer getVisite() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Annuncio [codiceAnnuncio=" + codiceAnnuncio + ", descrizione="
				+ descrizione + ", dataInserimento=" + dataInserimento
				+ ", visite=" + visite + ", stato=" + stato + ", categoria="
				+ categoria + ", prodotto=" + prodotto + ", utente=" + utente
				+ "]";
	}
	
	
	
	
}
