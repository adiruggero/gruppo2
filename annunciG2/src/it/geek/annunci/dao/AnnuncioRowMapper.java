package it.geek.annunci.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.geek.annunci.model.Annuncio;
import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Categoria;
import it.geek.annunci.model.Utente;

import org.springframework.jdbc.core.RowMapper;

public class AnnuncioRowMapper implements RowMapper<Annuncio> {

	public Annuncio mapRow(ResultSet rs,int mapRow)throws SQLException{
		
		Annuncio a = new Annuncio();
		Prodotto p = new Prodotto();
		Categoria c = new Categoria();
		Utente u = new Utente();
		
		a.setCodiceAnnuncio(rs.getInt("codice_annuncio"));
		a.setDescrizione(rs.getString("descrizione"));
		a.setVisite(rs.getInt("visite"));
		int stato = rs.getInt("stato");
		if(stato==1){
			a.setStato(true);
		}else{
			a.setStato(false);
		}
		c.setDescrizione(rs.getString("catDesc"));
		a.setCategoria(c);
		p.setDescrizione(rs.getString("prodDesc"));
		a.setProdotto(p);
		u.setUsername(rs.getString("username"));
		a.setUtente(u);
		
		return a;
		
	}
	
}
