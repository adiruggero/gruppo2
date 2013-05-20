package it.geek.annunci.form;

import org.apache.struts.action.ActionForm;
import it.geek.annunci.model.Categoria;
import it.geek.annunci.util.Collezioni;

import java.util.List;
import org.apache.struts.util.LabelValueBean;

public class AnnunciForm extends ActionForm{
	
	
	private List<LabelValueBean> listCategoria;
	private String descrizione;
	private boolean stato;
	private Categoria categoria = new Categoria();
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<LabelValueBean> getListCategoria() {
		listCategoria = Collezioni.getOptions("categoria");
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
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	

}
