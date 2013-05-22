package it.geek.annunci.form;

import org.apache.struts.action.ActionForm;
import it.geek.annunci.factory.ServiceFactory;
import it.geek.annunci.model.Categoria;
import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Utente;

import java.util.List;
import org.apache.struts.util.LabelValueBean;

public class AnnunciForm extends ActionForm{
	
	
	private List<LabelValueBean> listCategoria;
	private String dataInserimento;
	private String dataInserimentoFormatted;
	private String descrizione;
	private boolean stato;
	private int codiceAnnuncio;
	private int visite;
	private Categoria categoria = new Categoria();
	private Prodotto prodotto = new Prodotto();
	private Utente utente = new Utente();
	private String method;
	
	

	public int getVisite() {
		return visite;
	}
	
	public void setVisite(int visite) {
		this.visite = visite;
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
	public int getCodiceAnnuncio() {
		return codiceAnnuncio;
	}
	public void setCodiceAnnuncio(int codiceAnnuncio) {
		this.codiceAnnuncio = codiceAnnuncio;
	}
	public String getDataInserimentoFormatted() {
		return dataInserimentoFormatted;
	}
	public void setDataInserimentoFormatted(String dataInserimentoFormatted) {
		this.dataInserimentoFormatted = dataInserimentoFormatted;
	}
	public String getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<LabelValueBean> getListCategoria() {
		listCategoria = ServiceFactory.getCollezioniService().getCollezioni("categoria");
		return listCategoria;
	}
	public void setListCategoria(List<LabelValueBean> listCategoria) {
		this.listCategoria = listCategoria;
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
		return "AnnunciForm [listCategoria=" + listCategoria
				+ ", dataInserimento=" + dataInserimento
				+ ", dataInserimentoFormatted=" + dataInserimentoFormatted
				+ ", descrizione=" + descrizione + ", stato=" + stato
				+ ", codiceAnnuncio=" + codiceAnnuncio + ", visite=" + visite
				+ ", categoria=" + categoria + ", prodotto=" + prodotto
				+ ", utente=" + utente + ", method=" + method + "]";
	}
	
	
	
	

}
