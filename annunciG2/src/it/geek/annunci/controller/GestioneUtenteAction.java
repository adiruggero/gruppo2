package it.geek.annunci.controller;

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

public class GestioneUtenteAction extends DispatchAction{

	
	private static Logger logger = Logger.getLogger(GestioneUtenteAction.class);
	private String forwardPath = "";
	
	public ActionForward changePrivate(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		UtentiForm utenti = (UtentiForm) form;
		HttpSession session = request.getSession();
		
		Utente u = (Utente) session.getAttribute("utenteSessione");
		
		if(u==null){
			//Login
		} else{
			//
		}
		
		
		
		
		
	}
}
