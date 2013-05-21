package it.geek.annunci.util;

import java.util.List;
import org.apache.struts.util.LabelValueBean;

public interface CollezioniInterface {
	
	public List<LabelValueBean> getOptions(String id);

}
