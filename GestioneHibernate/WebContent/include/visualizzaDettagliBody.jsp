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

<font face="verdana" size="3">DETTAGLI LIBRI:</font><br>
<table class="table table-bordered">
				<tr>
					
					
					<td><strong>ID</strong></td>
					<td><strong>Titolo</strong></td>
					<td><strong>Pagine</strong></td>
					
				</tr>
				
				<c:forEach var="info" items="${listaLibri.libros}">
					<tr>
						<td>${info.idLibro}</td>
						<td>${info.titolo}</td>
						<td>${info.pagine}</td>
					</tr>
				</c:forEach>
				</table>




</center>