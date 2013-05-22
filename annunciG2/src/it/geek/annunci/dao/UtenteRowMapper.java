package it.geek.annunci.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.geek.annunci.model.Ruolo;
import it.geek.annunci.model.Utente;

import org.springframework.jdbc.core.RowMapper;

public class UtenteRowMapper implements RowMapper<Utente> {

	public Utente mapRow(ResultSet rs,int mapRow)throws SQLException{
		
		Utente u = new Utente();
		Ruolo r = new Ruolo();
		
		u.setCodiceUtente(rs.getInt("codice_utente"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setNome(rs.getString("nome"));
		u.setCognome(rs.getString("cognome"));
		r.setCodiceRuolo(rs.getInt("codice_ruolo"));
		r.setDescrizione(rs.getString("descrizione"));
		u.setRuolo(r);
		int stato = rs.getInt("stato");
		if(stato==1){
			u.setStato(true);
		}else{
			u.setStato(false);
		}
		u.setCreditoResiduo(rs.getInt("credito_residuo"));
		
		return u;
	}

}
