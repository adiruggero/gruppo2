<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.geek.annunci.model.Utente" %>
<center>
		
		<h3>Benvenuto</h3>
		
		<h4>Ci sono <%=Utente.utentiOnline%> utenti online!</h4>
		<c:if test="${utenteSession eq null}">
			<h3> Non sei loggato</h3>
		</c:if>
		
		<c:if test="${utenteSession ne null}">
			<h4> ${utenteSession.username}</h4>
			
		</c:if>
		Clicca qui per tornare alla <a href="home.jsp">Home</a> <br/>
		<c:if test="${utenteSession ne null }">
			Clicca qui per effettuare la <a href="gestioneUtente.do?method=logout">Logout</a>
		</c:if>	
</center>