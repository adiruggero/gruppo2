<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<center>
		<table border="2">
		<tr>
			<td>Descrizione</td>
			<td>Visite</td>
			<td>Stato</td>
			<td>Categoria</td>
			<td>Prodotto</td>
			<td>Utente</td>
		
			<logic:iterate id="annunci" name="listAnnunci">
			<tr>
				<td><bean:write name="annunci" property="dataInserimento"/></td>
				<td><bean:write name="annunci" property="descrizione"/></td>
				<td><bean:write name="annunci" property="visite"/></td>
				<c:if test="${annunci.stato eq true }">
					<td>Attivo</td>
				</c:if>
				<c:if test="${annunci.stato eq false }">
					<td>Non Attivo</td>
				</c:if>
				<td><html:submit value="Mostra"></html:submit></td>
			</tr>		
			</logic:iterate>
		
		
		</table>
		

</center>