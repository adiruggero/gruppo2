package it.geek.annunci.service;

import it.geek.annunci.dao.UtenteDao;
import it.geek.annunci.model.Utente;

public class UtenteService implements UtenteServiceInterface{
	
	private UtenteDao utenteDao;
	
	public void setUtenteDao(UtenteDao utenteDao){
		this.utenteDao=utenteDao;
	}
	
	public Utente get(Utente u){
		
		Utente utRet = null;
		
		if(u != null){
			
			utRet = utenteDao.findByWhere(u);
			if(utRet!=null){
				int online = Utente.getUtentiOnline();
				online ++;
				Utente.setUtentiOnline(online);
			}
		}
		
		return utRet;
	}

	

}