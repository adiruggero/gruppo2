package it.geek.gh.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import it.geek.gh.pojo.Persona;

public class PersonaService {

	private static Logger log = Logger.getLogger(PersonaService.class);
	
	public List<Persona> findAll(){
		
		
		List<Persona> lista = null;
		
//		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
//		session.beginTransaction();
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria crt = session.createCriteria(Persona.class);
		
		lista = crt.list();
		
//		session.flush();
		session.close();
		
//		session.getTransaction().commit();
		return lista;
		
	}
	
	public void insert (Persona p){
		log.info("sono nel metodo insert");
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
	}
	
	public void delete (int codice){
		
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		
		Persona p = null;
		session.beginTransaction();
		p = (Persona) session.get(Persona.class, codice);
		session.delete(p);
		session.getTransaction().commit();
		
	}
	
	public Persona findById (int codice){
		
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		
		Persona p = null;
		session.beginTransaction();
		p = (Persona) session.get(Persona.class, codice);
		session.getTransaction().commit();
		
		return p;
	}
	
	public void update (Persona p){
		
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();	
		
		
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		

	}
	
	public List<Persona> research(Persona p){
		
		List<Persona> lista = null;
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		Criteria crt = session.createCriteria(Persona.class);
		crt.add(Restrictions.like("nome","%"+p.getNome()+"%"));
		crt.add(Restrictions.like("email", "%"+p.getEmail()+"%"));
		
		lista = crt.list();
		session.getTransaction().commit();
		
		return lista;
		
	}
}



