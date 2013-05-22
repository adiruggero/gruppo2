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
		
		
		
		Prodotto p = new Prodotto();
		AnnunciForm af = (AnnunciForm)form;
		Annuncio a = new Annuncio();
		
		
		BeanUtils.copyProperties(a,af);
		
		HttpSession session = request.getSession();
		
		Utente u =(Utente) session.getAttribute("utenteSession");
		p.setCodiceProdotto(a.getProdotto().getCodiceProdotto());
	
		boolean ret = ServiceFactory.getAnnuncioService().buyAndUpdate(a, p, u);
		
		if(ret){
			forwardPath="private";
		
		}
		
		return mapping.findForward(forwardPath);
		
	}
}
