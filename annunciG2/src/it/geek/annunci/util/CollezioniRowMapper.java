package it.geek.annunci.util;

import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.struts.util.LabelValueBean;

import java.util.Vector;

public class CollezioniRowMapper implements RowMapper<LabelValueBean> {

	public LabelValueBean mapRow(ResultSet rs,int mapRow) throws SQLException{
	
		
		
		String value = rs.getString("codice_categoria");
		String label = rs.getString("descrizione");
		
		LabelValueBean lvb = new LabelValueBean(label,value);
		
		return lvb;
		
	}
	
}
