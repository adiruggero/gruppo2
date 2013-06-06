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
<font face="verdana" size="3"><h3>AGGIUNGI UN LIBRO:</h3></font><br>
<br>

<html:form method="POST" action="utente.do">
<html:hidden property="method" value="addBook"/>

<font face="verdana">TITOLO</font>&nbsp;<html:text property="libro.titolo"/><br>
<font face="verdana">PAGINE</font>&nbsp;<html:text property="libro.pagine"/><br>
<html:hidden property="idUtente" value="${utenteForm.idUtente}"/>
<html:hidden property="libro.utente.idUtente" value="${utenteForm.idUtente }"/>
<html:submit styleClass="btn btn-info" value="AGGIUNGI!"/>

</html:form>

</center>