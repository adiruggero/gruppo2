<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
		
		
		
		<table>		
		
		<c:if test="${listProdotti ne null}">
			<h3>Ecco la lista dei tuoi acquisti!</h3>
			
			<tr>
				<td>Codice Prodotto</td>
				<td>Descrizione</td>
				<td>Data acquisto</td>
			</tr>	
				<logic:iterate name="listProdotti" id="prodotto">
			<tr>		
				<td><bean:write name="prodotto" property="codiceProdotto"/></td>
				<td><bean:write name="prodotto" property="descrizione"/></td>
				<td><bean:write name="prodotto" property="dataAcquistoFormatted"/></td>
			</tr>
				</logic:iterate>
		
		</c:if>
		<c:if test="${listProdotti eq null }">
			
			<h3>Non hai effettuato acquisti!</h3>
			
		</c:if>

		
	</table>
</center>