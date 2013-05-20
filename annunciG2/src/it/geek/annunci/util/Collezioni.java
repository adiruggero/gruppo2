package it.geek.annunci.util;

import java.util.List;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Collezioni {

	private static Logger logger = Logger.getLogger(Collezioni.class);
	
	public static List<LabelValueBean> getOptions(String tab){
		
		Connection c  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+tab;
		c = MyConnectionJNDI.getConnection();
		
		LabelValueBean lvb = new LabelValueBean("","0");
		List<LabelValueBean> list = new Vector<LabelValueBean>();
		
		list.add(lvb);
		
		try{
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				String value = rs.getString("codice_categoria");
				String label = rs.getString("descrizione");
				lvb  = new LabelValueBean(label,value);
				list.add(lvb);
				logger.info("Query combo eseguita");
			}
		}catch(Exception e){
			
			logger.error("query combo non eseguita");
			e.printStackTrace();
		}
		finally{
			try{
				rs.close();
			}catch(Exception e){
				logger.error("rs non chiuso");
				e.printStackTrace();
			}
			try{
				ps.close();
			}catch(Exception e){
				logger.error("ps non chiuso");
				e.printStackTrace();
			}try{
				c.close();
			}catch(Exception e){
				logger.error("connessione chiusa");
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
}
