package it.geek.annunci.factory;

import it.geek.annunci.service.AnnuncioServiceInterface;
import it.geek.annunci.service.CollezioniServiceInterface;
import it.geek.annunci.service.UtenteServiceInterface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {

	private static ApplicationContext ctx;
	
	static{
		ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	public static CollezioniServiceInterface getCollezioniService(){
		return (CollezioniServiceInterface) ctx.getBean("scollezioni");
	}
	
	public static AnnuncioServiceInterface getAnnuncioService(){
		return (AnnuncioServiceInterface)ctx.getBean("sannunci");
		
	}
	
	public static UtenteServiceInterface getUtenteService(){
		return (UtenteServiceInterface)ctx.getBean("sutenti");
	}
}
