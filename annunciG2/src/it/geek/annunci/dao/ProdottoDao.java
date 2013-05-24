package it.geek.annunci.dao;

import java.util.ArrayList;
import java.util.List;

import it.geek.annunci.model.Prodotto;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProdottoDao implements ProdottoDaoInterface {
	
	private static Logger log = Logger.getLogger(ProdottoDao.class);
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		
		this.jdbcTemplate=jdbcTemplate;
		
	}
	
	public List<Prodotto> findByWhere(Prodotto p){
		
		
		List<Object> list = new ArrayList<Object>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.codice_prodotto,p.descrizione,p.prezzo,p.data_acquisto,u.codice_utente");
		sb.append(" FROM utenti u RIGHT OUTER JOIN prodotti p ON u.codice_utente=p.acquirente ");
		sb.append(" WHERE 1=1 AND ");
		if(p.getCodiceProdotto()!=0){
			sb.append(" p.codice_prodotto=? AND");
			list.add(p.getCodiceProdotto());
		}
		if(p.getDescrizione()!=null){
			sb.append(" p.descrizione=? AND");
			list.add(p.getDescrizione());
		}
		if(p.getPrezzo()!=0){
			sb.append(" p.prezzo=? AND");
			list.add(p.getPrezzo());
		}
		if(p.getDataAcquisto()!=null){
			sb.append(" p.data_acquisto=? AND");
			java.util.Date dataAcq = p.getDataAcquisto();
			java.sql.Date dataAcqSql = new java.sql.Date(dataAcq.getTime());
			list.add(dataAcqSql);
		}
		if(p.getAcquirente()!=null && p.getAcquirente().getCodiceUtente()!=0){
			sb.append(" p.acquirente=? AND");
			list.add(p.getAcquirente().getCodiceUtente());
		}
		sb.delete(sb.length()-4, sb.length());
		
		List<Prodotto> listProdotto = jdbcTemplate.query(sb.toString(),list.toArray(),new ProdottoRowMapper());
		
		return listProdotto;
		
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
	
	public Prodotto findById(int codice){
		
		Prodotto p = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.codice_prodotto AS codice_prodotto,p.descrizione AS descrizione,p.prezzo AS prezzo,p.data_acquisto AS data_acquisto,u.codice_utente AS codice_utente");
		sb.append(" FROM utenti u RIGHT OUTER JOIN prodotti p ON u.codice_utente=p.acquirente ");
		sb.append(" WHERE p.codice_prodotto=?");
		try{
			p = jdbcTemplate.queryForObject(sb.toString(),new Object[]{codice},new ProdottoRowMapper());
		}catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}
		return p;
		
		
	}

	public boolean insert(Prodotto p){
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO prodotti(descrizione,prezzo)");
		sb.append(" VALUES(?,?)");
		
		List<Object> list = new ArrayList<Object>();
		list.add(p.getDescrizione());
		list.add(p.getPrezzo());
		
		int ritorno = jdbcTemplate.update(sb.toString(),list.toArray());
		
		if(ritorno>=0){
			return true;
		}else{
			return false;
		}
	}
	
}
