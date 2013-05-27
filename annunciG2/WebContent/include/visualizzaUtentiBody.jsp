<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<h3>Ecco la lista degli utenti!</h3>


			
<html:form action="gestioneUtente.do">
		<html:hidden property="method" value="visualizzaUtenti"/>

			<table border="1">
				<tr>
					
					<td><strong><center>Nome</center></strong></td>
					<td><strong><center>Cognome</center></strong></td>
					<td><strong><center>Username</center></strong></td>
					<td><strong><center>Password</center></strong></td>
				</tr>
				
				<c:forEach var="info" items="${listaUtenti}">
					<tr>
						<td><center>${info.nome}</center></td>
						<td><center>${info.cognome}</center></td>
						<td><center>${info.username}</center></td>
						<td><center>${info.password}</center></td>
					</tr>
				</c:forEach>
				
	</html:form>
</center>

</body>
</html>