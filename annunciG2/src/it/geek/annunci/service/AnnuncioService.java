package it.geek.annunci.service;

import it.geek.annunci.model.Annuncio;
import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Utente;
import it.geek.annunci.dao.AnnuncioDao;
import it.geek.annunci.dao.ProdottoDao;
import it.geek.annunci.dao.UtenteDao;

import java.util.List;

import org.apache.log4j.Logger;



public class AnnuncioService implements AnnuncioServiceInterface {
	
	
	private static Logger log = Logger.getLogger(AnnuncioService.class);
	
	private ProdottoDao prodottoDao;
	private AnnuncioDao annuncioDao;
	private UtenteDao utenteDao;
	
	public void setUtenteDao(UtenteDao utenteDao){
		this.utenteDao=utenteDao;
	}
	
	public void setProdottoDao(ProdottoDao prodottoDao){
		this.prodottoDao=prodottoDao;
	}
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
	
	public Annuncio getAndUpdate(Annuncio a){
		log.debug(a);
		
		Annuncio an = null;
		
		
		
		if(a!=null){
		
				
				an = annuncioDao.findById(a.getCodiceAnnuncio());
				
				int visite = an.getVisite();
				visite++;
				an.setVisite(visite);
			
				boolean ret = annuncioDao.update(an);
				
				
			}
			
			
		return an;
		
		
	}

	public boolean buyAndUpdate(Annuncio a,Prodotto p,Utente u){
		
		boolean modificato = false;
		
		if(a!=null && p != null){
			
			log.info("Sono in buyAndUpdate!");
			
			
			int prezzoProdotto = p.getPrezzo();
			int creditoUtente =u.getCreditoResiduo();
			
			if(prezzoProdotto>creditoUtente){
				throw new RuntimeException();
			}
			else{
				
				p.setAcquirente(u);
				
				if(p.getDataAcquisto()==null){
					
					java.util.Date dataAcq = new java.util.Date();
					p.setDataAcquisto(dataAcq);
					log.info("Update data Acquisto eseguita!");
				}
				
				boolean ret = prodottoDao.update(p);
				
				creditoUtente = creditoUtente-prezzoProdotto;
				u.setCreditoResiduo(creditoUtente);
				
				log.debug(u.getCreditoResiduo());
				
				boolean aggiornaCredito = utenteDao.update(u);
				
				if(ret == true && aggiornaCredito==true){
					
					log.info("Chiudo l'annuncio!");
					a.setStato(false);
				    modificato=annuncioDao.update(a);
					
					
				}
				
				
			}	

		}
		return modificato;
		
	}
	
	public Annuncio get(int codice){
		
		Annuncio a = null;
		
		a = annuncioDao.findById(codice);
		
		return a;
	}
}	
