package it.geek.gh.controller;


import java.util.List;

import it.geek.gh.form.PersonaForm;
import it.geek.gh.pojo.Persona;
import it.geek.gh.service.PersonaService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GestionePersonaAction extends DispatchAction{

	private static Logger logger = Logger.getLogger(GestionePersonaAction.class);
			
			
	public ActionForward paginaIniziale(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		log.debug("entro...");
		
		PersonaService ps = new PersonaService();
		List<Persona> lista = ps.findAll();
				
	    request.setAttribute("listaPersone", lista);
		return mapping.findForward("entra");
		
	}
	
	public ActionForward creaPersona(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{

		return mapping.findForward("crea");
		
	}
	
	public ActionForward create(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		PersonaForm pf =(PersonaForm) form;
		log.debug(pf);
		Persona p = new Persona();
		PersonaService ps = new PersonaService();
		BeanUtils.copyProperties(p,pf);
		log.debug(p);
		ps.insert(p);
		
		List<Persona> lista = ps.findAll();
		
	    request.setAttribute("listaPersone", lista);
		
		return mapping.findForward("entra");
	}
	
	public ActionForward elimina(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		PersonaForm pf = (PersonaForm) form;
		Persona p = new Persona();
		BeanUtils.copyProperties(p, pf);
		
		PersonaService ps = new PersonaService();
		ps.delete(p.getIdPersona());
		
		List<Persona> lista = ps.findAll();
		
	    request.setAttribute("listaPersone", lista);
		
		return mapping.findForward("entra");
	}
	
	public ActionForward modifica(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		
		PersonaForm pf = (PersonaForm)form;
		PersonaService ps = new PersonaService();
		Persona p = ps.findById(pf.getIdPersona());
		BeanUtils.copyProperties(pf,p);
		
		return mapping.findForward("modifica");
	}
	
	public ActionForward edit(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		PersonaForm pf = (PersonaForm)form;
		log.debug(pf);
		PersonaService ps = new PersonaService();
		Persona p = new Persona();
		BeanUtils.copyProperties(p,pf);
		log.debug(p);
		ps.update(p);
		

		List<Persona> lista = ps.findAll();
		
	    request.setAttribute("listaPersone", lista);
		
		return mapping.findForward("entra");
		
	}
	
	public ActionForward ricercaPersona(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		return mapping.findForward("ricerca");
	}
	
	public ActionForward search(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		PersonaForm pf = (PersonaForm)form;
		PersonaService ps = new PersonaService();
		Persona p = new Persona();
		BeanUtils.copyProperties(pf,p);
		ps.research(p);
		
		return mapping.findForward("entra");
	}
}
	





	
	
