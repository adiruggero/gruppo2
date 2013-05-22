<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<center>

		<html:form method="POST" action="gestioneAnnunci.do">
		<html:hidden property="method" value="dettagli"/>
		<html:hidden property="codiceAnnuncio" value=""/>
		
		<table border="2">
		<tr>
			<td>Data Inserimento</td>
			<td>Descrizione</td>
			<td>Visite</td>
			<td>Stato</td>
		
			<logic:iterate id="annunci" name="listAnnunci">
			<tr>
				
				<td><bean:write name="annunci" property="dataInserimentoFormatted"/></td>
				<td><bean:write name="annunci" property="descrizione"/></td>
				<td><bean:write name="annunci" property="visite"/></td>
				<c:if test="${annunci.stato eq true }">
					<td>Attivo</td>
					
				</c:if>
				<c:if test="${annunci.stato eq false }">
					<td>Non Attivo</td>
				</c:if>
				<td><html:submit  value="Mostra" onclick="document.forms['annunciForm'].codiceAnnuncio.value='${annunci.codiceAnnuncio}';"></html:submit></td>
			</tr>		
			</logic:iterate>
		
		
		</table>
		
	</html:form>

</center>