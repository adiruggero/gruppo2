package it.geek.annunci.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import it.geek.annunci.model.Utente;

public class UtenteDao implements UtenteDaoInterface {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}

	public Utente findByWhere(Utente u){
		
		List<Object> list = new Vector<Object>();
		
		StringBuilder sb = new StringBuilder();
		Utente utenteRet = null;
		
		sb.append("SELECT u.codice_utente,u.username,u.password,u.nome,u.cognome,r.codice_ruolo,u.stato,u.credito_residuo,r.descrizione");
		sb.append(" FROM utenti u, ruoli r");
		sb.append(" WHERE u.codice_ruolo=r.codice_ruolo AND");
		
		if(u.getCodiceUtente()!=0){
			sb.append(" codice_utente=? AND");
			list.add(u.getCodiceUtente());
		}
		if(u.getUsername()!=null){
			sb.append(" username=? AND");
			list.add(u.getUsername());
		}
		if(u.getPassword()!=null){
			sb.append(" password=? AND");
			list.add(u.getPassword());
		}
		if(u.getNome()!=null){
			sb.append(" nome=? AND");
			list.add(u.getNome());
		}
		if(u.getCognome()!=null){
			sb.append(" cognome=? AND");
			list.add(u.getCognome());
		}
		if(u.getRuolo()!=null && u.getRuolo().getCodiceRuolo()!=0){
			sb.append(" codice_ruolo=? AND");
			list.add(u.getRuolo().getCodiceRuolo());
		}
		/*if(u.isStato()==true){
			sb.append(" stato=? AND");
			Integer obj = 1;
			list.add(obj);
		}
		if(u.isStato()==false){
			sb.append(" stato=? AND");
			Integer obj = 0;
			list.add(obj);
		}*/
		if(u.getCreditoResiduo()!=0){
			sb.append(" credito_residuo=? AND");
			list.add(u.getCreditoResiduo());
		}
		sb.delete(sb.length()-4, sb.length());
		try{
			utenteRet = jdbcTemplate.queryForObject(sb.toString(),list.toArray(),new UtenteRowMapper()); 
		}catch(EmptyResultDataAccessException e){
		}
		return utenteRet;
		
	}

}
