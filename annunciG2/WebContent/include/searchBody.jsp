<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<center>

		<html:form method="POST" action="gestioneAnnunci.do"
		<tr>
			<td>Data Inserimento</td>
			<td>Descrizione</td>
			<td>Prezzo</td>
			<td>Visite</td>
			<td>Stato</td>
		
			<logic:iterate id="annunci" name="listAnnunci">
			<tr>
				
				<td><bean:write name="annunci" property="dataInserimentoFormatted"/></td>
				<td><bean:write name="annunci" property="descrizione"/></td>
				<td><bean:write name="annunci" property="prodotto.prezzo"/></td>
				<td><bean:write name="annunci" property="visite"/></td>
				<c:if test="${annunci.stato eq true }">
					<td>Attivo</td>
					
				</c:if>
				<c:if test="${annunci.stato eq false }">
					<td>Non Attivo</td>
				</c:if>
				<td><html:submit styleClass="btn btn-success"  value="Mostra" onclick="document.forms['annunciForm'].codiceAnnuncio.value='${annunci.codiceAnnuncio}';"></html:submit></td>
			</tr>		
			</logic:iterate>
		
		
		</table>
		
	</html:form>

</center>