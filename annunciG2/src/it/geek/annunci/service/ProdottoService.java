package it.geek.annunci.service;

import it.geek.annunci.dao.ProdottoDao;
import it.geek.annunci.model.Prodotto;

import java.util.List;

import org.apache.log4j.Logger;

public class ProdottoService implements ProdottoServiceInterface {
	
	private static Logger log = Logger.getLogger(ProdottoService.class);
	
	private ProdottoDao prodottoDao;
	
	public void setProdottoDao(ProdottoDao prodottoDao){
		this.prodottoDao = prodottoDao;
	}

	
	
	public List<Prodotto> getByWhere(Prodotto p){
		
		List<Prodotto> list = null;
		if(p!=null){
			
			list = prodottoDao.findByWhere(p);
			
		}
		
		return list;
		
		
		
		
		
	}
	
	

}
