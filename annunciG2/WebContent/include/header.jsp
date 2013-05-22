<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<center>
		
		<h3>Benvenuto</h3>
		<c:if test="${utenteSession eq null}">
			<h3> Non sei loggato</h3>
		</c:if>
		
		<c:if test="${utenteSession ne null}">
			<h3> ${utenteSession.username}</h3>
				
		</c:if>
		<a href="home.jsp">Home</a>
</center>