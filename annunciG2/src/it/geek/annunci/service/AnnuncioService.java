
package it.geek.annunci.service;

import it.geek.annunci.model.Annuncio;
import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Utente;
import it.geek.annunci.dao.AnnuncioDao;
import it.geek.annunci.dao.AnnuncioDaoInterface;
import it.geek.annunci.dao.ProdottoDao;
import it.geek.annunci.dao.ProdottoDaoInterface;
import it.geek.annunci.dao.UtenteDao;
import it.geek.annunci.dao.UtenteDaoInterface;

import java.util.List;

import org.apache.log4j.Logger;



public class AnnuncioService implements AnnuncioServiceInterface {
	
	
	private static Logger log = Logger.getLogger(AnnuncioService.class);
	
	private ProdottoDaoInterface prodottoDao;
	private AnnuncioDaoInterface annuncioDao;
	private UtenteDaoInterface utenteDao;
	
	public void setUtenteDao(UtenteDaoInterface utenteDao){
		this.utenteDao=utenteDao;
	}
	
	public void setProdottoDao(ProdottoDaoInterface prodottoDao){
		this.prodottoDao=prodottoDao;
	}
	public void setAnnuncioDao(AnnuncioDaoInterface annuncioDao){
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
			
			log.debug(prezzoProdotto);
			
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
	
	public List<Annuncio> findView(){
		
		List<Annuncio> listAnnunci = annuncioDao.findForView();
		
		return listAnnunci;
		
	}
	
	public boolean insertAndUpdate(Annuncio a,Prodotto p,Utente u){
		
		boolean annuncioInserito=false;
		
		p.setDescrizione(a.getProdotto().getDescrizione());
		p.setPrezzo(a.getProdotto().getPrezzo());
		
		boolean inserito = prodottoDao.insert(p);
		
		if(inserito==true){
			
			List<Prodotto> listProd = prodottoDao.findByWhere(p);
			
			if(listProd == null || listProd.isEmpty()){
				
				log.error("Errore! Prodotto non trovato!");
			
			}else if(listProd.size()>1){
				
				log.error("Attenzione! Prodotto non trovato");
				
			}else{
				
				Prodotto pForAnnuncio = listProd.get(0);
				a.setProdotto(pForAnnuncio);
				a.setUtente(u);
				
				annuncioInserito = annuncioDao.insert(a);
				
			}
			
		}else{
			return false;
		}
		
		return annuncioInserito;
		
	}
	
}	
