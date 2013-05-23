 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrite!</title>
<script type="text/javascript">

function controllaCampi(){
	var nomeVal = document.forms['utentiForm'].nome.value;
	
	if(nomeVal==""){
		alert("A me risulta che tutti hanno un nome, il campo nome è vuoto!!!");
		return false;
	}
	var cognomeVal = document.forms['utentiForm'].cognome.value;
	if(cognomeVal==""){
		alert("A me risulta che tutti hanno un cognome, il campo cognome è vuoto!!!");
		return false;
	}
	var userVal = document.forms['utentiForm'].username.value;
	if(userVal==""){
		alert("devi avere un username se vuoi registrarti!");
		return false;
	}
	
	var passVal = document.forms['utentiForm'].password.value;
	if(passVal==""){
		alert("e la password quando la mettiamo?");
		return false;
	}
	document.forms['utentiForm'].submit();
}





</script>
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
		<html:button onclick="controllaCampi();" property="button">invia</html:button>
	</html:form>
</center>
</body>
</html>