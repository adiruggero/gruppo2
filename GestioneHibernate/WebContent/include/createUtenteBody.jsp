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
<font face="verdana" size="3"><h3>AGGIUNGI UN UTENTE:</h3></font><br>
<br>

<html:form method="POST" action="utente.do">
<html:hidden property="method" value="create"/>

<font face="verdana">USERNAME</font>&nbsp;<html:text property="username"/><br>
<font face="verdana">PASSWORD</font>&nbsp;<html:text property="password"/><br>
<font face="verdana">NOME</font>&nbsp;<html:text property="nome"/><br>
<font face="verdana">COGNOME</font>&nbsp;<html:text property="cognome"/><br>
<html:submit styleClass="btn btn-info" value="AGGIUNGI!"/>

</html:form>


</center>