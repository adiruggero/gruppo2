package it.geek.annunci.form;

import org.apache.struts.action.ActionForm;
import it.geek.annunci.model.Ruolo;

public class UtentiForm extends ActionForm{

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Ruolo ruolo = new Ruolo();
	private int creditoResiduo;
	private String method;
	
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
