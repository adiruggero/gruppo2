package it.geek.annunci.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Utente;

import org.springframework.jdbc.core.RowMapper;

public class ProdottoRowMapper implements RowMapper<Prodotto> {

	public Prodotto mapRow(ResultSet rs,int mapRow)throws SQLException{
		
		Prodotto p = new Prodotto();
		Utente u = new Utente();
		
		p.setCodiceProdotto(rs.getInt("codice_prodotto"));
		p.setDescrizione(rs.getString("descrizione"));
		p.setPrezzo(rs.getInt("prezzo"));
		java.sql.Date dataSql = rs.getDate("data_acquisto");
		if(dataSql!=null){
			java.util.Date dataAcq = new java.util.Date(dataSql.getTime());
			p.setDataAcquisto(dataAcq);
		}
		u.setCodiceUtente(rs.getInt("codice_utente"));
		p.setAcquirente(u);
		
		return p;
		
		
	}

}
