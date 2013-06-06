<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- import for BOOTSTRAP CSS and JS (minimal) -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>	
	<!-- end import -->

<center>

<<div align="left"><p class="muted"><font face="arial black" size="5">LISTA DELLE PERSONE</font></p></div>
<br>
<br>


		
			<table class="table table-striped">
				<tr>
					
					
					<td><strong>Codice</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>e-mail</strong></td>
					<td><strong>MODIFICA</strong></td>
					<td><strong>ELIMINA</strong></td>
					
				</tr>
				
				<c:forEach var="info" items="${listaPersone}">
					<tr>
						<td>${info.idPersona}</td>
						<td>${info.nome}</td>
						<td>${info.email}</td>
						<td><i class="icon-pencil"></i>&nbsp;<a href="persona.do?method=modifica&idPersona=${info.idPersona}">modifica</a></td>
						<td><i class="icon-ban-circle"></i>&nbsp;<a href="persona.do?method=elimina&idPersona=${info.idPersona}">elimina</a><td>
					</tr>
				</c:forEach>
				</table>
	<br>
<i class="icon-plus"></i>&nbsp;<a href="persona.do?method=creaPersona"><font face="franklin gothic demi" size="3">AGGIUNGI PERSONA</font></a><br>
<br>
<i class="icon-search"></i>&nbsp;<a href="persona.do?method=ricercaPersona"><font face="franklin gothic demi" size="3">RICERCA PERSONA</font></a><br><br>


</center>
