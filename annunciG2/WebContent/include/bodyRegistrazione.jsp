 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<center><b><h2>Registrazione nuovo utente</h2></b></center><br/>
<br/>
	<center>
	<html:form styleId="utentiForm" action="gestioneUtente.do">
		<html:hidden property="method" value="eseguiRegistrazione"/>
		<table>
			<tr><td>Nome:</td><td><html:text property="nome"/></td></tr>
			<tr><td>Cognome:</td><td><html:text property="cognome"/></td></tr>
			<tr><td>Username:</td><td><html:text property="username"/></td></tr>
			<tr>
		<td>Ruolo:</td>
				<td><html:select name="utentiForm" property="ruolo.codiceRuolo">
				<html:optionsCollection name = "utentiForm" property = "listRuoli"/>
				</html:select></td>
				</td>		
			</tr>
			<tr><td>Password:</td><td><html:text property="password"/></td></tr>
		</table>
		<html:submit>invia</html:submit>
	</html:form>
</center>
</body>
</html>