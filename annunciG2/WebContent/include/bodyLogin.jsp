<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<center>
		<h3>Effettua la login qui!</h3>
		<html:form method="POST" action="gestioneUtente.do">
		<table>
		<tr>
			<td>Username:</td> <td><html:text property="username"/></td>
		</tr>
		<tr>	
			<td>Password:</td> <td><html:text property="password"/></td>
		</tr>
			<html:hidden property="method" value="login"/>
			<tr><td><html:submit value="login"></html:submit>
		</table>
			altrimenti registrati <a href="gestioneUtenti.do?method=registrazione">qui!</a>
			
			
		</html:form>
</center>