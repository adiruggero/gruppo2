package it.geek.anunci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.geek.annunci.model.Utente;

public class UtenteDAO implements UtenteDAOInterface{

	public Utente findByWhere (Connection conn) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Utente u = null;
		
		String sql = "";
		
		
		
		return u;
		
	}
}
