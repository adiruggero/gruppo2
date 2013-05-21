package it.geek.annunci.form;

import org.apache.struts.action.ActionForm;
import it.geek.annunci.factory.ServiceFactory;
import it.geek.annunci.model.Categoria;
import java.util.List;
import org.apache.struts.util.LabelValueBean;

public class AnnunciForm extends ActionForm{
	
	
	private List<LabelValueBean> listCategoria;
	private String descrizione;
	private boolean stato;
	private Categoria categoria = new Categoria();
	private String method;
	
	
	
	
	
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
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	

}
