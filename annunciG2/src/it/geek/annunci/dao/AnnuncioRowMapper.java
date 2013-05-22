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
		java.sql.Date dataSql = rs.getDate("data_inserimento");
		if(dataSql!=null){
			java.util.Date dataAnnuncio = new java.util.Date(dataSql.getTime());
			a.setDataInserimento(dataAnnuncio);
		}
		a.setVisite(rs.getInt("visite"));
		int stato = rs.getInt("stato");
		if(stato==1){
			a.setStato(true);
		}else{
			a.setStato(false);
		}
		c.setCodiceCategoria(rs.getInt("codice_categoria"));
		c.setDescrizione(rs.getString("catDesc"));
		a.setCategoria(c);
		p.setCodiceProdotto(rs.getInt("codice_prodotto"));
		p.setDescrizione(rs.getString("prodDesc"));
		a.setProdotto(p);
		u.setUsername(rs.getString("username"));
		a.setUtente(u);
		
		return a;
		
	}
	
}
