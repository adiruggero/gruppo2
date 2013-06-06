package it.geek.gh.form;

import java.util.HashSet;
import java.util.Set;

import it.geek.gh.pojo.Libro;
import it.geek.gh.pojo.Utente;

import org.apache.struts.action.ActionForm;

public class UtenteForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUtente;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Set<Libro> libros = new HashSet<Libro>(0);
	private Libro libro = new Libro();
	
	
	
	public Set<Libro> getLibros() {
		return libros;
	}
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	public Libro getLibro() {
		if(libro.getUtente()==null){
			libro.setUtente(new Utente());
		}
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
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
	@Override
	public String toString() {
		return "UtenteForm [idUtente=" + idUtente + ", username=" + username
				+ ", password=" + password + ", nome=" + nome + ", cognome="
				+ cognome + "]";
	}
	
	
	

}
