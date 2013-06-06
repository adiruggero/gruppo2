package it.geek.gh.controller;

import it.geek.gh.form.PersonaForm;
import it.geek.gh.form.UtenteForm;
import it.geek.gh.pojo.Libro;
import it.geek.gh.pojo.Persona;
import it.geek.gh.pojo.Utente;
import it.geek.gh.service.PersonaService;
import it.geek.gh.service.UtenteService;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class GestioneUtenteAction extends DispatchAction{

	private static Logger logger = Logger.getLogger(GestioneUtenteAction.class);

	public ActionForward visualizzaUtenti(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		UtenteService us = new UtenteService();
		List<Utente> lista = us.findAll();
				
	    request.setAttribute("listaUtenti", lista);
		
		
		return mapping.findForward("visualizza");
		
	}
	
	public ActionForward dettagli(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		Utente u = new Utente();
		UtenteForm uf = (UtenteForm) form;
		UtenteService us = new UtenteService();
		u = us.findById(uf.getIdUtente());
		
		request.setAttribute("listaLibri", u);;
		
		return mapping.findForward("visualizzaDettagli");
	}
	
	public ActionForward cancella(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
	
	
	
	UtenteForm uf = (UtenteForm) form;
	Utente u = new Utente();
	BeanUtils.copyProperties(u, uf);
	
	UtenteService us = new UtenteService();
	us.delete(u.getIdUtente());
	
	List<Utente> lista = us.findAll();
	
    request.setAttribute("listaUtenti", lista);
	
	return mapping.findForward("visualizza");
	}	
	
	
	public ActionForward modifica(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		

		UtenteForm uf = (UtenteForm)form;
		UtenteService us = new UtenteService();
		Utente u = us.findById(uf.getIdUtente());
		BeanUtils.copyProperties(uf,u);
		
		return mapping.findForward("modificaUtente");
	}

	public ActionForward modificaEffettuata(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
	
		
		UtenteForm uf = (UtenteForm)form;
		UtenteService us = new UtenteService();
		Utente u = new Utente();
		BeanUtils.copyProperties(u,uf);
		us.update(u);
		
	List<Utente> lista = us.findAll();
	
    request.setAttribute("listaUtenti", lista);
    
    return mapping.findForward("visualizza");
	
	
	}
	
	public ActionForward creaUtente(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
	
		return mapping.findForward("aggiungiUtente");
		
	}
	
	public ActionForward create(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		UtenteForm uf =(UtenteForm) form;
		Utente u = new Utente();
		UtenteService us = new UtenteService();
		BeanUtils.copyProperties(u,uf);
		us.insert(u);
		
		List<Utente> lista = us.findAll();
		
	    request.setAttribute("listaUtenti", lista);
	    
	    return mapping.findForward("visualizza");
	}
	
	public ActionForward aggiungiLibro(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		return mapping.findForward("aggiungiLibro");
	}
	
	public ActionForward addBook(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		UtenteForm uf =(UtenteForm) form;
		log.debug(uf);
		Libro l = uf.getLibro();
		UtenteService us = new UtenteService();
		
		Utente u = us.findById(uf.getIdUtente());
		log.debug(u);
		Set<Libro> sl = u.getLibros();
		log.debug(sl.size());
		
		sl.add(l);
		
		log.debug(sl.size());
		u.setLibros(sl);
		
		
		us.update(u);
		
		List<Utente> lista = us.findAll();
	    request.setAttribute("listaUtenti", lista);
	    
		return mapping.findForward("visualizza");
	}
}	

	
