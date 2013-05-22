package it.geek.annunci.controller;

import it.geek.annunci.factory.ServiceFactory;
import it.geek.annunci.form.UtentiForm;
import it.geek.annunci.model.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.omg.CORBA.Request;
import org.springframework.beans.BeanUtils;

public class GestioneUtenteAction extends DispatchAction{

	
	private static Logger logger = Logger.getLogger(GestioneUtenteAction.class);
	
	public ActionForward logUtente(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		String forwardPath = "";
		HttpSession session = request.getSession();
		Utente u = (Utente) session.getAttribute("utenteSessione");
		
		if(u==null){
			forwardPath="login";
			
			return mapping.findForward(forwardPath);
		} else{
			forwardPath="paginaUtente";
			
			return mapping.findForward(forwardPath);
		}
	
	}
	
	public ActionForward login(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		String forwardPath = "";
		UtentiForm uf = (UtentiForm) form;
		Utente u = new Utente();
		
		BeanUtils.copyProperties(uf,u);
		
		Utente utenteLog = ServiceFactory.getUtenteService().get(u);
		
		if(utenteLog!=null){
			HttpSession session = request.getSession();
			session.setAttribute("utenteSession",utenteLog);
			forwardPath="paginaUtente";
		}
		return mapping.findForward(forwardPath);
		
		
	}
	
	public ActionForward registrazione(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		String forwardPath ="registrazione";
		return mapping.findForward(forwardPath);			
				
				
		}
			
	}		
