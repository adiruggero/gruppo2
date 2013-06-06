<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- import for BOOTSTRAP CSS and JS (minimal) -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>	
	<!-- end import -->

<center>

<div align="left"><p class="muted"><font face="arial black" size="5">LISTA DEGLI UTENTI</font></p></div>
<br>
<br>
		
			<table class="table table-striped">
				<tr>
					
					
					<td><strong>ID</strong></td>
					<td><strong>Username</strong></td>
					<td><strong>Password</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>Cognome</strong></td>
					<td><strong>DETTAGLI LIBRI</strong></td>
					<td><strong>MODIFICA</strong></td>
					<td><strong>ELIMINA UTENTE</strong></td>
				
					
				</tr>
				
				<c:forEach var="info" items="${listaUtenti}">
					<tr>
						<td>${info.idUtente}</td>
						<td>${info.username}</td>
						<td>${info.password}</td>
						<td>${info.nome}</td>
						<td>${info.cognome}</td>
						<td><i class="icon-list"></i>&nbsp;<a href="utente.do?method=dettagli&idUtente=${info.idUtente}">dettagli</a></td>
						<td><i class="icon-pencil"></i>&nbsp;<a href="utente.do?method=modifica&idUtente=${info.idUtente}">modifica</a></td>
						<td><i class="icon-ban-circle"></i>&nbsp;<a href="utente.do?method=cancella&idUtente=${info.idUtente}">elimina</a></td>
						
						<td>	<html:form method="POST" action="utente.do">
							<html:hidden property="method" value="aggiungiLibro"/>
							<html:hidden property="idUtente" value="${info.idUtente}"/>
							<html:submit styleClass="btn btn-info" value="Aggiungi libro"/>
							</html:form></td>
						
					</tr>
				</c:forEach>
				</table>

<br>
<i class="icon-plus"></i>&nbsp;<a href="utente.do?method=creaUtente"><font face="franklin gothic demi" size="3">AGGIUNGI UTENTE</font></a><br>
</center>