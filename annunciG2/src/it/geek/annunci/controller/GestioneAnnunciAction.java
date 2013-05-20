package it.geek.annunci.controller;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GestioneAnnunciAction extends DispatchAction{
	
	private static Logger logger = Logger.getLogger(GestioneAnnunciAction.class);
	private String forwardPath = "";
			
			
	public ActionForward search(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		
		forwardPath="search";
		
		return mapping.findForward(forwardPath);
		
	}
	

}
