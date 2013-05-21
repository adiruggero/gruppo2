package it.geek.annunci.service;

import java.util.List;
import org.apache.struts.util.LabelValueBean;

public interface CollezioniServiceInterface {

	public List<LabelValueBean> getCollezioni(String tab);
	
}
