
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<center>
<h4>QUESTO E' IL TUO PROFILO:</h4><br>

<h4>SE VUOI MODIFICARE LE TUE CREDENZIALI, FALLO QUI:</h4><br>

<html:form styleId="modificaUtentiForm" action="gestioneUtente.do">
		<html:hidden property="method" value="eseguiModifica"/>
		<table>
			<tr><td>Nome:</td><td><html:text property="nome"/></td></tr>
			<tr><td>Cognome:</td><td><html:text property="cognome"/></td></tr>
			<tr><td>Username:</td><td><html:text property="username"/></td></tr>
			<tr><td>Password:</td><td><html:text property="password"/></td></tr>
		</table>
		<html:submit>invia</html:submit>
	</html:form>



</center>
