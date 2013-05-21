package it.geek.annunci.service;

import java.util.List;

import org.apache.struts.util.LabelValueBean;
import it.geek.annunci.util.Collezioni;

public class CollezioniService implements CollezioniServiceInterface {
	
	private Collezioni collezioni;
	
	public void setCollezioni(Collezioni collezioni){
		this.collezioni=collezioni;
	}

	@Override
	public List<LabelValueBean> getCollezioni(String tab) {
		
		List<LabelValueBean> list = collezioni.getOptions(tab);
		
		
		return list;
		
	}

}
