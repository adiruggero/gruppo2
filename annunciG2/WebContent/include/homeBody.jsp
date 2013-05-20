<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<center>
		
		<html:form method="POST" action="gestioneAnnunci.do">
		
			<td><html:select name="annunciForm" property="categoria.codiceCategoria">
						<html:optionsCollection name="annunciForm" property="listCategoria" />
					</html:select></td>
		
		</html:form>

</center>