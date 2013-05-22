package it.geek.annunci.model;

import java.io.Serializable;

import it.geek.annunci.model.Ruolo;


public class Utente implements Serializable {

	private int codiceUtente;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Ruolo ruolo;
	private boolean stato;
	private int creditoResiduo;
	private static int utentiOnline;
	
	
	
	
	/**
	 * @return the utentiOnline
	 */
	public static int getUtentiOnline() {
		return utentiOnline;
	}
	/**
	 * @param utentiOnline the utentiOnline to set
	 */
	public static void setUtentiOnline(int utentiOnline) {
		Utente.utentiOnline = utentiOnline;
	}
	public int getCodiceUtente() {
		return codiceUtente;
	}
	public void setCodiceUtente(int codiceUtente) {
		this.codiceUtente = codiceUtente;
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
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public int getCreditoResiduo() {
		return creditoResiduo;
	}
	public void setCreditoResiduo(int creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}
	
	
	
	
}
