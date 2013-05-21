package it.geek.annunci.controller;

import it.geek.annunci.factory.ServiceFactory;
import it.geek.annunci.form.AnnunciForm;
import it.geek.annunci.model.Annuncio;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GestioneAnnunciAction extends DispatchAction{
	
	private static Logger logger = Logger.getLogger(GestioneAnnunciAction.class);
	private String forwardPath = "";
			
			
	public ActionForward findAnnunci(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		forwardPath="search";
		
		AnnunciForm af = (AnnunciForm)form;
		Annuncio a = new Annuncio();
		
		BeanUtils.copyProperties(af, a);
		
		List<Annuncio> listAnnuncio = ServiceFactory.getAnnuncioService().getWhere(a);
		
		request.setAttribute("listAnnunci",listAnnuncio);
		
		return mapping.findForward(forwardPath);
		
	}
	

}
