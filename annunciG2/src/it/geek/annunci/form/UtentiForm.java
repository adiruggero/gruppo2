package it.geek.annunci.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.LabelValueBean;

import it.geek.annunci.factory.ServiceFactory;
import it.geek.annunci.model.Ruolo;

public class UtentiForm extends ActionForm{

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Ruolo ruolo = new Ruolo();
	private int creditoResiduo;
	private String method;
	private List<LabelValueBean> listRuoli;
	
	public List<LabelValueBean> getListRuoli() {
		listRuoli=ServiceFactory.getCollezioniService().getCollezioni("ruoli");
		return listRuoli;
	}

	public void setListRuoli(List<LabelValueBean> listRuoli) {
		this.listRuoli = listRuoli;
	}

	public String getMethod(){
		return method;
	}
	
	public void setMethod(String method){
		this.method=method;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public int getCreditoResiduo() {
		return creditoResiduo;
	}
	public void setCreditoResiduo(int creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}
	
						
}
