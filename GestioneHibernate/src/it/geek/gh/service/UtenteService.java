package it.geek.gh.service;

import it.geek.gh.pojo.Libro;
import it.geek.gh.pojo.Persona;
import it.geek.gh.pojo.Utente;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class UtenteService {

	private static Logger log = Logger.getLogger(UtenteService.class);
	
	public List<Utente> findAll(){
		
		List<Utente> lista = null;
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria crt = session.createCriteria(Utente.class);
		lista = crt.list();
		session.close();
		
		return lista;
	}
	
public Utente findById (int codice){
		
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		
		Utente u = null;
		session.beginTransaction();
		u = (Utente) session.get(Utente.class, codice);
		session.getTransaction().commit();
		
		return u;
	}

public void delete (int codice){
	
	Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
	
	Utente u = null;
	session.beginTransaction();
	u = (Utente) session.get(Utente.class, codice);
	session.delete(u);
	session.getTransaction().commit();
	
	}
	
public void update (Utente u){
	
	Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();	
	
	
	session.beginTransaction();
	session.update(u);
	session.getTransaction().commit();
	
	}

public void insert (Utente u){
	
	Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
	
	session.beginTransaction();
	session.save(u);
	session.getTransaction().commit();
	
}

public void insertBook (Libro l){
	
	Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
	
	session.beginTransaction();
	session.save(l);
	session.getTransaction().commit();
	
}

}

