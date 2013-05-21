package it.geek.annunci.service;


import it.geek.annunci.dao.UtenteDAOInterface;
import it.geek.annunci.model.Utente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



public class UtenteService implements UtenteServiceInterface {
	
	private UtenteDAOInterface utente;
	
	public void setUtenteDao(UtenteDAOInterface utenteDao){
		this.utente = utenteDao;	
	}
	
	
	public Utente get (String id) {
		Connection conn = ConnessioneJNDI.getConnection();
		Utente u = null;
		try {
			u = utente.findByWhere(id, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println ("Impossibile chiudere la Connection" + e);
				e.printStackTrace();
			}
		}
		
		return u;
		
	}

}

	