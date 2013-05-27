package it.geek.annunci.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.geek.annunci.model.Annuncio;

import org.springframework.jdbc.core.RowMapper;

public class VisiteRowMapper implements RowMapper<Annuncio> {

	public Annuncio mapRow(ResultSet rs,int mapRow)throws SQLException{
		
		Annuncio a = new Annuncio();
		
		a.setCodiceAnnuncio(rs.getInt("codice_annuncio"));
		a.setDescrizione(rs.getString("descrizione"));
		a.setVisite(rs.getInt("visite"));
		
		return a;
		
	}

}
