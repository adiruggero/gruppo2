
package it.geek.annunci.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
public class MyConnectionJNDI {
	
	private static Logger logger = Logger.getLogger(MyConnectionJNDI.class);
	
	public static Connection getConnection(){
		
		  Connection c = null;
		    try{
		    	InitialContext ctx = new InitialContext();
		    	DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/residenzaDB");
		    	c = ds.getConnection();
		    	logger.info("Connessione effettuata");
		    }catch(NamingException e){
		    	
		    	logger.error("Impossibile connettersi al DB");
		    	e.printStackTrace();
		    	
		    }catch(SQLException e){
		    	
		    	logger.error("Impossibile prendere la connessione");
		    	e.printStackTrace();
		    }
		    return c;
		    
	}
	
}
