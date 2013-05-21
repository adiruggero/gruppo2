package it.geek.annunci.util;

import it.geek.annunci.exception.BusinessException;

import java.util.List;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Collezioni implements CollezioniInterface{

	private static Logger logger = Logger.getLogger(Collezioni.class);
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public List<LabelValueBean> getOptions(String tab){
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *");
		sb.append(" FROM " + tab);
		
		List<LabelValueBean> list = new Vector<LabelValueBean>();
		
		try{
			list = jdbcTemplate.query(sb.toString(),new CollezioniRowMapper());
		}catch(EmptyResultDataAccessException e){
			logger.error("Impossibile eseguire query");
			throw new BusinessException(e);
		}
	
		return list;
	}	
	
}	