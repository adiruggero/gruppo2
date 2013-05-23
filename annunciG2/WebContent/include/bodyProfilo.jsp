<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
QUESTO E' IL TUO PROFILO, LE TUE CREDENZIALI SONO:<br>
<br>
NOME:&nbsp;${utenteSession.nome}<br>
COGNOME:&nbsp;${utenteSession.cognome}<br>
USERNAME:&nbsp;${utenteSession.username}<br>
PASSWORD:&nbsp;${utenteSession.password}<br>
RUOLO:&nbsp;${utenteSession.ruolo.descrizione}<br>
<br>
SE VUOI MODIFICARE LE TUE CREDENZIALI, FALLO QUI:
<br>
<html:form styleId="modificaUtentiForm" action="gestioneUtente.do">
		<html:hidden property="method" value="eseguiModifica"/>
		<table>
			<tr><td>Nome:</td><td><html:text property="nome"/></td></tr>
			<tr><td>Cognome:</td><td><html:text property="cognome"/></td></tr>
			<tr><td>Username:</td><td><html:text property="username"/></td></tr>
			<tr><td>Password:</td><td><html:text property="password"/></td></tr>
		</table>
		<html:button  property="button">invia</html:button>
	</html:form>



</center>
</body>
</html>