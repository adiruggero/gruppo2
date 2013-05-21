package it.geek.annunci.service;

import it.geek.annunci.model.Annuncio;
import it.geek.annunci.dao.AnnuncioDao;

import java.util.List;

public class AnnuncioService implements AnnuncioServiceInterface {
	
	private AnnuncioDao annuncioDao;
	
	public void setAnnuncioDao(AnnuncioDao annuncioDao){
		this.annuncioDao=annuncioDao;
	}

	@Override
	public List<Annuncio> getWhere(Annuncio a) {
		
		List<Annuncio> listAnnuncio = null;
		if(a!=null){
			
			listAnnuncio = annuncioDao.findByWhere(a);
		}
		
		return listAnnuncio;
		
	}

}
