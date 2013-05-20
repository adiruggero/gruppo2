<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<center>
		
		<html:form styleId="ricercaForm" method="POST" action="gestioneAnnunci.do">
		
			<td><html:select name="ricercaForm" property="categoria.codiceCategoria">
						<html:optionsCollection name="ricercaForm" property="listCategoria" />
					</html:select></td>
		
		</html:form>

</center>