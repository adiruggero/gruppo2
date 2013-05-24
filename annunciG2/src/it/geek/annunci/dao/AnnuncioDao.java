package it.geek.annunci.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.JdbcTemplate;

import it.geek.annunci.model.Annuncio;


public class AnnuncioDao implements AnnuncioDaoInterface{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Annuncio> findByWhere(Annuncio a){
		
		List<Object> v = new Vector<Object>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a.codice_annuncio,a.data_inserimento,a.descrizione,a.visite,a.stato,p.codice_prodotto,p.prezzo,p.descrizione AS prodDesc,c.codice_categoria,c.descrizione AS catDesc,u.codice_utente,u.username");
		sb.append(" FROM annunci a,prodotti p,categoria c,utenti u");
		sb.append(" WHERE a.codice_categoria=c.codice_categoria AND");
		sb.append(" a.codice_prodotto=p.codice_prodotto AND");
		sb.append(" a.codice_utente=u.codice_utente AND");
		if(a.getCodiceAnnuncio()>0){
			sb.append(" a.codice_annuncio=? AND");
			v.add(a.getCodiceAnnuncio());
		}
		if(a.getDescrizione()!=null){
			sb.append(" a.descrizione LIKE ? AND");
			v.add("%"+a.getDescrizione()+"%");
		}
		if(a.getDataInserimento()!=null){
			sb.append(" a.data_inserimento=? AND");
			java.util.Date dataIns = a.getDataInserimento();
			java.sql.Date dataInsDb = new java.sql.Date(dataIns.getTime());
			v.add(dataInsDb);
		}
		if(a.isStato()==true){
			sb.append(" a.stato=? AND");
			Integer value = 1;
			v.add(value);
		}else{
			sb.append(" a.stato=? AND");
			Integer value = 0;
			v.add(value);
		}
		if(a.getCategoria()!=null && a.getCategoria().getCodiceCategoria()!=0){
			sb.append(" c.codice_categoria=? AND");
			v.add(a.getCategoria().getCodiceCategoria());
		}
		if(a.getProdotto()!=null && a.getProdotto().getCodiceProdotto()!=0){
			sb.append(" p.codice_prodotto=? AND");
			v.add(a.getProdotto().getCodiceProdotto());
		}
		if(a.getUtente()!=null && a.getUtente().getCodiceUtente()!=0){
			sb.append(" u.codice_utente=? AND");
			v.add(a.getUtente().getCodiceUtente());
		}
		sb.delete(sb.length()-4,sb.length());
		
		
		
		List<Annuncio> listAnnunci = jdbcTemplate.query(sb.toString(),v.toArray(),new AnnuncioRowMapper());
		
		return listAnnunci;
		
	}
	
	public boolean update(Annuncio a){
		
		StringBuilder sb = new StringBuilder();
		List<Object> list = new Vector<Object>();
		
		sb.append("UPDATE annunci SET");
		if(a.getDescrizione()!=null){
			sb.append(" descrizione=? ,");
			list.add(a.getDescrizione());
		}
		if(a.getDataInserimento()!=null){
			sb.append(" data_inserimento=? ,");
			java.util.Date dataIns=a.getDataInserimento();
			java.sql.Date dataSql = new java.sql.Date( dataIns.getTime());
			list.add(dataSql);
		}
		if(a.getVisite()!=null){
			sb.append(" visite=? ,");
			list.add(a.getVisite());
		}
		if(a.isStato()==true){
			sb.append(" stato=? ,");
			int i = 1;
			list.add(i);
		}
		if(a.isStato()==false){
			sb.append(" stato=? ,");
			int i = 0;
			list.add(i);
		}
		if(a.getCategoria().getCodiceCategoria()!=0){
			sb.append(" codice_categoria=? ,");
			list.add(a.getCategoria().getCodiceCategoria());
		}
		if(a.getProdotto().getCodiceProdotto()!=0){
			sb.append(" codice_prodotto=? ,");
			list.add(a.getProdotto().getCodiceProdotto());
		}
		if(a.getUtente().getCodiceUtente()!=0){
			sb.append(" codice_utente=? ,");
			list.add(a.getUtente().getCodiceUtente());
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(" WHERE codice_annuncio=?");
		list.add(a.getCodiceAnnuncio());
		
		int ritorno = jdbcTemplate.update(sb.toString(),list.toArray());
		
		if(ritorno>=0){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	public Annuncio findById(int id){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT a.codice_annuncio,a.data_inserimento,a.descrizione,a.data_inserimento,a.visite,a.stato,p.codice_prodotto,p.prezzo,p.descrizione AS prodDesc,c.codice_categoria,c.descrizione AS catDesc,u.codice_utente,u.username");
		sb.append(" FROM annunci a,prodotti p,categoria c,utenti u");
		sb.append(" WHERE a.codice_categoria=c.codice_categoria AND");
		sb.append(" a.codice_prodotto=p.codice_prodotto AND");
		sb.append(" a.codice_utente=u.codice_utente AND");
		sb.append(" codice_annuncio=?");
		
		Annuncio u = jdbcTemplate.queryForObject(sb.toString(),new Object[]{id},new AnnuncioRowMapper());
		
		return u;
	}

	public List<Annuncio> findForView(){
		
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT descrizione,visite");
		sb.append(" FROM annunci");
		sb.append(" ORDER BY visite desc");
		
		List<Annuncio> listAnnunci = jdbcTemplate.query(sb.toString(),new AnnuncioRowMapper());
		
		return listAnnunci;
		
	}
	
	public boolean insert(Annuncio a){
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO annunci(descrizione,codice_categoria,codice_prodotto,codice_utente)");
		sb.append(" VALUES(?,?,?,?");
		
		List<Object> list = new ArrayList<Object>();
		
		list.add(a.getDescrizione());
		list.add(a.getCategoria().getCodiceCategoria());
		list.add(a.getProdotto().getCodiceProdotto());
		list.add(a.getUtente().getCodiceUtente());
		
		int ritorno = jdbcTemplate.update(sb.toString(),list.toArray());
		
		if(ritorno>=0){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
	}
	
}
