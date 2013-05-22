package it.geek.annunci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;

import it.geek.annunci.model.Utente;

public class UtenteDAO implements UtenteDAOInterface{
	
	
	private JdbcTemplate jdbcTemplate;




	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Utente login (String username, String password) {

        PreparedStatement ps = null;
		ResultSet rs = null;
		Utente u = null;
		
		String sql="SELECT username=?, password=? FROM utenti";
		
		
try {
				
			
			ps.setString (1, username);
			ps.setString(2, password);

			System.out.println(sql);
					
			rs = ps.executeQuery ();
			
			if (rs.next()) {
			u = new Utente();
			
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			}
				
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				 try {
						rs.close();
					}
					catch (Exception e) {
					System.out.println ("Impossibile chiudere il ResultSet"+ e);
					e.printStackTrace ();
					}
					try {
						ps.close();
					} catch (Exception e) {
					System.out.println ("Impossibile chiudere il PrepareStatement"+ e);
					e.printStackTrace ();
					}
							
					
				}	return u;
	}

			
		
	
public boolean insert(Utente u, Connection conn) {
		
		String sql ="INSERT INTO utenti (username, password, nome, cognome, codice_ruolo, stato, credito_residuo) values (?,?,?,?,?,?,?)";
		int ritorno = jdbcTemplate.update(sql, new Object[] {u.getUsername(), u.getPassword(), u.getNome(), u.getCognome(), u.getRuolo(), u.isStato(), u.getCreditoResiduo()});
		boolean ret = false;
		if (ritorno>0){
		ret = true;
		}
		return ret;
	
}
	 
	 

}