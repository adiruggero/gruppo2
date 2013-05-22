<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>

		
	<html:form method="POST" action="gestioneAnnunci.do">	
		<html:hidden property="method" value="finalizza"/>	
		<html:hidden property="codiceAnnuncio" value="${annuncio.codiceAnnuncio }"/>
		<table>
		<tr><td><h3>Dettagli utente:</h3> </td></tr>
				<tr><td>Username: </td><td>${utente.username}</td></tr>
				<tr><td>Password: </td><td>${utente.password}</td></tr>
				<tr><td>Nome: </td>  <td>${utente.nome}</td></tr>
				<tr><td>Cognome:</td><td>${utente.cognome}</td></tr>
				<tr><td>Credito Residuo:</td><td>${utente.creditoResiduo}£</td></tr>
				
				<br>
				<br>
				
	<tr><td>	<h3>Dettagli acquisto:</h3> </td></tr>
		
				<tr>
					<td>Data Inserimento</td>
					<td>Dettagli</td>
					<td>Visite</td>
					<td>Stato</td>
					<td>Categoria</td>
					<td>Prodotto</td>
					<td>Utente</td>
				</tr>
					<tr>	
					
						<td>${annuncio.dataInserimentoFormatted}</td>
						<td>${annuncio.descrizione}</td>
						<td>${annuncio.visite}</td>
						<c:if test="${annuncio.stato eq true }">
							<td>Attivo</td>
						</c:if>
						<c:if test="${annuncio.stato eq false }">
							<td>Non Attivo</td>
						</c:if>
						<td>${annuncio.categoria.descrizione}</td>
						<td>${annuncio.prodotto.descrizione}</td>
						<td>${annuncio.prodotto.codiceProdotto }</td>dsaòdjòf
						<td>${annuncio.utente.username }</td>
						<c:if test="${annuncio.stato eq true }">
							<td><html:submit value="Finalizza!"></html:submit></td>
						</c:if>
						<c:if test="${annuncio.stato eq false }">
							<td>Prodotto non più in vendita!</td>
						</c:if>
							
					</tr>
		
						
		</table>
	
	</html:form>

</center>