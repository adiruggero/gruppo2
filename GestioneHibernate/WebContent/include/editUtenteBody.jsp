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

<html:form method="POST" action="utente.do">
<html:hidden property="method" value="modificaEffettuata"/>

<fieldset>
    <legend>Modifica Utente</legend>
    <label>USERNAME</label>
    <html:text property="username"/>
    <label class="checkbox">
    </label>
    <label>PASSWORD</label>
    <html:text property="password"/>
    <label class="checkbox">
    </label>
     <label>NOME</label>
    <html:text property="nome"/>
    <label class="checkbox">
    </label>
     <label>COGNOME</label>
    <html:text property="cognome"/>
    <label class="checkbox">
    </label>

    <html:hidden property="idUtente" value="${utenteForm.idUtente}"/>
    <button type="submit" class="btn btn-success">Modifica</button>
  </fieldset>

</html:form>


</center>