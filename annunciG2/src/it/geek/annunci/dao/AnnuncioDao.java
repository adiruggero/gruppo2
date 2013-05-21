package it.geek.annunci.dao;

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
		sb.append("SELECT a.codice_annuncio,a.descrizione,a.data_inserimento,a.visite,a.stato,p.descrizione AS prodDesc,c.descrizione AS catDesc,u.username");
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
		if(a.isStato()==true){
			sb.append(" a.stato=? AND");
			Integer value = 1;
			v.add(value);
		}else{
			sb.append(" a.stato=? AND");
			Integer value = 0;
			v.add(value);
		}
		if(a.getCategoria().getCodiceCategoria()>0){
			sb.append(" c.codice_categoria=? AND");
			v.add(a.getCategoria().getCodiceCategoria());
		}
		if(a.getProdotto().getCodiceProdotto()>0){
			sb.append(" p.codice_prodotto=? AND");
			v.add(a.getProdotto().getCodiceProdotto());
		}
		if(a.getUtente().getCodiceUtente()>0){
			sb.append(" u.codice_utente=? AND");
			v.add(a.getUtente().getCodiceUtente());
		}
		sb.delete(sb.length()-4,sb.length());
		
		
		
		List<Annuncio> listAnnunci = jdbcTemplate.query(sb.toString(),v.toArray(),new AnnuncioRowMapper());
		
		return listAnnunci;
		
	}

}
