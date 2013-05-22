package it.geek.annunci.dao;

import java.util.ArrayList;
import java.util.List;

import it.geek.annunci.model.Prodotto;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProdottoDao implements ProdottoDaoInterface {
	
	private static Logger log = Logger.getLogger(ProdottoDao.class);
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		
		this.jdbcTemplate=jdbcTemplate;
		
	}

	public boolean update(Prodotto p) {
		
		
		List<Object> listAdd = new ArrayList<Object>();
		StringBuilder sb = new StringBuilder();	
		sb.append("UPDATE prodotti SET");
		if(p.getDescrizione()!=null){
			listAdd.add(p.getDescrizione());
			sb.append(" descrizione=? ,");
		}
		if(p.getPrezzo()!=0){
			listAdd.add(p.getPrezzo());
			sb.append(" prezzo=? ,");
		}
		if(p.getDataAcquisto()!=null){
			java.util.Date dataAcq = p.getDataAcquisto();
			java.sql.Date dataAqcSql = new java.sql.Date(dataAcq.getTime());
			listAdd.add(dataAqcSql);
			sb.append(" data_acquisto=? ,");
		}
		if(p.getAcquirente()!=null && p.getAcquirente().getCodiceUtente()!=0){
			listAdd.add(p.getAcquirente().getCodiceUtente());
			sb.append(" acquirente=? ,");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		
		sb.append(" WHERE codice_prodotto=?");
		listAdd.add(p.getCodiceProdotto());
		
		int ritorno = jdbcTemplate.update(sb.toString(),listAdd.toArray());
		
		if(ritorno>=0){
			return true;
		}else{
			return false;
		}
		
		
	}

}
