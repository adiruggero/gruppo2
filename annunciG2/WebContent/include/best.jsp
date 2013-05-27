<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>


<center>
		<html:form styleId="bestForm" method="POST" action="gestioneAnnunci.do">
		<html:hidden property="codiceAnnuncio" value=""/>
		<h4>Guarda quali sono i nostri annunci più visti!</h4>
		<table>
			<tr>
				<td>Descrizione</td>
				<td>Visite</td>
			</tr>
			<logic:iterate name="bestList" id="best">
			<tr>
				<td><bean:write name="best" property="descrizione"/></td>
				<td><bean:write name="best" property="visite"/></td>
				<td><html:submit styleClass="btn btn-primary" value="Dettagli" onclick="document.forms['bestForm'].codiceAnnuncio.value='${best.codiceAnnuncio}';"/></td>
			</tr>
			</logic:iterate>
		</table>
		
		<html:hidden property="method" value="dettagli"/>
		
		</html:form>
</center>