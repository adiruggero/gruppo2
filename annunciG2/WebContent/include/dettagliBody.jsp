<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<center>
	
		<html:form method="POST" action="gestioneAnnunci.do">
			
			<html:hidden property="codiceAnnuncio" value="${annuncio.codiceAnnuncio}"/>	
			<html:hidden property="method" value="compra"/>
			<table border="2">
			
			<c:if test="${annuncio.stato eq false }">
			<h3>Annuncio chiuso!</h3>
			</c:if>			
				<tr>
					<td>Data Inserimento</td>
					<td>Dettagli</td>
					<td>Prezzo</td>
					<td>Visite</td>
					<td>Stato</td>
					<td>Categoria</td>
					<td>Prodotto</td>
					<td>Utente</td>
				</tr>
					<tr>	
						
						<td>${annuncio.dataInserimentoFormatted}</td>
						<td>${annuncio.descrizione}</td>
						<td>${annuncio.prodotto.prezzo}</td>
						<td>${annuncio.visite}</td>
						<c:if test="${annuncio.stato eq true }">
							<td>Attivo</td>
						</c:if>
						<c:if test="${annuncio.stato eq false }">
							<td>Non Attivo</td>
						</c:if>
						<td>${annuncio.categoria.descrizione}</td>
						<td>${annuncio.prodotto.descrizione}</td>
						<td>${annuncio.utente.username }</td>
						
							
					
						<c:if test="${annuncio.stato eq true}">						
							<td><html:submit styleClass="btn btn-success" value="Buy!"></html:submit></td>
						</c:if>
		
					</tr>
			</table>
		</html:form>
</center>