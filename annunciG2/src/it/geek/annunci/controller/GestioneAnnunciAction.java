package it.geek.annunci.controller;

import it.geek.annunci.factory.ServiceFactory;
import it.geek.annunci.form.AnnunciForm;
import it.geek.annunci.model.Annuncio;
import it.geek.annunci.model.Prodotto;
import it.geek.annunci.model.Utente;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.log4j.Logger;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GestioneAnnunciAction extends DispatchAction{
	
	private static Logger logger = Logger.getLogger(GestioneAnnunciAction.class);
	private String forwardPath = "";
			
			
	public ActionForward findAnnunci(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		java.util.Date defaultValue = null;
		DateConverter dateConverter = new DateConverter(defaultValue); 
		dateConverter.setPattern("dd/MM/yyyy");   
		ConvertUtils.register(dateConverter, java.util.Date.class); 
		
		forwardPath="search";
		
		AnnunciForm af = (AnnunciForm)form;
		log.debug(af);
		Annuncio a = new Annuncio();
		
		BeanUtils.copyProperties(a,af);
		
		
		log.debug(a);
		
		List<Annuncio> listAnnuncio = ServiceFactory.getAnnuncioService().getWhere(a);
		
		request.setAttribute("listAnnunci",listAnnuncio);
		
		return mapping.findForward(forwardPath);
		
	}
	
	public ActionForward dettagli(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		
		java.util.Date defaultValue = null;
		DateConverter dateConverter = new DateConverter(defaultValue); 
		dateConverter.setPattern("dd/MM/yyyy");   
		ConvertUtils.register(dateConverter, java.util.Date.class); 
		
		AnnunciForm af =(AnnunciForm)form;
		
		Annuncio a = new Annuncio();
		
		BeanUtils.copyProperties(a,af);
	
		Annuncio ret = ServiceFactory.getAnnuncioService().getAndUpdate(a);
		
		request.setAttribute("annuncio",ret);
		
		forwardPath="dettagli";
		
		return mapping.findForward(forwardPath);
		
	}
	
	public ActionForward compra(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		

		
		java.util.Date defaultValue = null;
		DateConverter dateConverter = new DateConverter(defaultValue); 
		dateConverter.setPattern("dd/MM/yyyy");   
		ConvertUtils.register(dateConverter, java.util.Date.class); 
		
		HttpSession session = request.getSession();
		
		Utente ut = (Utente)session.getAttribute("utenteSession");
		int codice = ut.getCodiceUtente();
		Utente ret = ServiceFactory.getUtenteService().getId(codice);
		
		request.setAttribute("utente",ret);
		
		AnnunciForm af = (AnnunciForm) form;
		Annuncio a = new Annuncio();
		BeanUtils.copyProperties(a, af);
		int codiceAnnuncio = a.getCodiceAnnuncio();
		
		
		Annuncio aRet = ServiceFactory.getAnnuncioService().get(codiceAnnuncio);
		
		request.setAttribute("annuncio",aRet);
		
		forwardPath="finalizza";
		
		return mapping.findForward(forwardPath);
		
	}	
	
	public ActionForward finalizza(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		java.util.Date defaultValue = null;
		DateConverter dateConverter = new DateConverter(defaultValue); 
		dateConverter.setPattern("dd/MM/yyyy");   
		ConvertUtils.register(dateConverter, java.util.Date.class);
		
		HttpSession session = request.getSession();
		Utente ut = (Utente) session.getAttribute("utenteSession");
		
		int codice = ut.getCodiceUtente();
		Utente ret = ServiceFactory.getUtenteService().getId(codice);
		
		AnnunciForm af = (AnnunciForm) form;
		Annuncio a = new Annuncio();
		BeanUtils.copyProperties(a,af);
		
		int codiceAnnuncio = a.getCodiceAnnuncio();
		
		Annuncio aRet = ServiceFactory.getAnnuncioService().get(codiceAnnuncio);
		
		Prodotto p = new Prodotto();
		
		int codiceProdotto = aRet.getProdotto().getCodiceProdotto();
		
		p.setCodiceProdotto(codiceProdotto);
		
		boolean comprato = ServiceFactory.getAnnuncioService().buyAndUpdate(aRet,p,ret);
		
		if(comprato){
			
			Prodotto prodUtente = new Prodotto();
			prodUtente.setAcquirente(ret);
			
			List<Prodotto> list = ServiceFactory.getProdottoService().getByWhere(prodUtente);
			
			request.setAttribute("listProdotti",list);
			
			
			forwardPath="success";
		}else{
			forwardPath="failure";
		}
		return mapping.findForward(forwardPath);		
		
	}
		
}
