package it.geek.annunci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.geek.annunci.model.Utente;

public class UtenteDAO implements UtenteDAOInterface{
	
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
}
	 
	 

