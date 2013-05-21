package it.geek.annunci.form;

import org.apache.struts.action.ActionForm;

public class UtentiForm extends ActionForm{

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String ruolo;
	private int creditoResiduo;
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
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public int getCreditoResiduo() {
		return creditoResiduo;
	}
	public void setCreditoResiduo(int creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}
	
						
}
