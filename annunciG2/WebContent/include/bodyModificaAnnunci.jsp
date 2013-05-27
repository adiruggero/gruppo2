<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<center>

		<table>
				
				<tr>
					<td>Descrizione</td>
					<td>Data Inserimento</td>
					<td>Visite</td>
					<td>Categoria</td>
					<td>Prezzo</td>
					<td>Prodotto</td>
					<td>Utente</td>
					<td>Stato</td>
				</tr>
				<tr>
					<logic:iterate name="listAnnunci" id="annuncio">
					<td><bean:write name="annuncio" property="descrizione"/></td>
					<td><bean:write name="annuncio" property="dataInserimento"/></td>
					<td><bean:write name="annuncio" property="visite"/></td>
						
					
					</logic:iterate>
				</tr>	
		</table>
</center>