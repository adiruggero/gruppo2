package it.geek.gh.form;

import org.apache.struts.action.ActionForm;

public class PersonaForm extends ActionForm {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idPersona;
	private String nome;
	private String email;
	private String method;
	public String getNome() {
		return nome;
	}
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	@Override
	public String toString() {
		return "PersonaForm [idPersona=" + idPersona + ", nome=" + nome
				+ ", email=" + email + ", method=" + method + "]";
	
	}
}
