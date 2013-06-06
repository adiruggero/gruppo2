package it.geek.annunci.dao;

import java.util.ArrayList;
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

	public List<Utente> findByWhere(Utente u){
		
		List<Object> list = new Vector<Object>();
		
		StringBuilder sb = new StringBuilder();

		
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
			sb.append(" u.codice_ruolo=? AND");
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
		
		return  jdbcTemplate.query(sb.toString(),list.toArray(),new UtenteRowMapper()); 
		
	
		
	}
	

	public boolean insert(Utente u) {
		
		String sql ="INSERT INTO utenti (username, password, nome, cognome, codice_ruolo) values (?,?,?,?,?)";
		int ritorno = jdbcTemplate.update(sql, new Object[] { u.getUsername(), u.getPassword(),u.getNome(), u.getCognome(), u.getRuolo().getCodiceRuolo()});
		boolean ret = false;
		if (ritorno>=0){
			ret = true;
		}
		return ret;
	}



	public Utente findById(int id){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT u.codice_utente,u.username,u.password,u.nome,u.cognome,r.codice_ruolo,u.stato,u.credito_residuo,r.descrizione");
		sb.append(" FROM utenti u, ruoli r");
		sb.append(" WHERE u.codice_ruolo=r.codice_ruolo AND u.codice_utente=?");
		
		Utente ut = jdbcTemplate.queryForObject(sb.toString(),new Object[]{id},new UtenteRowMapper());
		
		return ut;
		
		
		
	}

	
	public boolean update(Utente u){
		
		StringBuilder sb = new StringBuilder();
		List<Object> list = new ArrayList<Object>();
		
		sb.append("UPDATE utenti SET ");
		if(u.getUsername()!=null){
			sb.append(" username=? ,");
			list.add(u.getUsername());
		}
		if(u.getNome()!=null){
			sb.append(" nome=? ,");
			list.add(u.getNome());
		}
		if(u.getCognome()!=null){
			sb.append(" cognome=? ,");
			list.add(u.getCognome());
		}
		if(u.getRuolo()!=null && u.getRuolo().getCodiceRuolo()!=0 ){
			sb.append(" codice_ruolo=? ,");
			list.add(u.getRuolo().getCodiceRuolo());
		}
		if(u.getCreditoResiduo()!=0){
			sb.append(" credito_residuo=? ,");
			list.add(u.getCreditoResiduo());
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(" WHERE codice_utente=?");
		list.add(u.getCodiceUtente());
		
		
		int ritorno = jdbcTemplate.update(sb.toString(),list.toArray());
		
		if(ritorno>=0){
			return true;
		}else{
			return false;
		}
		
	}
	public List<Utente> findAll() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT u.codice_utente,u.username,u.password,u.nome,u.cognome,r.codice_ruolo,u.stato,u.credito_residuo,r.descrizione");
		sb.append(" FROM utenti u, ruoli r");
		sb.append(" WHERE u.codice_ruolo=r.codice_ruolo");
		sb.append(" ORDER BY nome ASC");
		
		
		return (List<Utente>)jdbcTemplate.query(sb.toString(), new UtenteRowMapper());
	}
	
	public void delete (int id){
		
		Utente u = new Utente();
		String sql = "delete from utenti where codice_utente =?";
		jdbcTemplate.update(sql, new Object[] {u.getCodiceUtente()});
		
		
	}
}
