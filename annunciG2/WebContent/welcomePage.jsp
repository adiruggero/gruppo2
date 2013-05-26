<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
	<!-- import for BOOTSTRAP CSS and JS (minimal) -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>	
	<!-- end import -->
		
		
</head>
<body>
		
		<html:form method="POST" action="gestioneAnnunci.do">
			
			<html:hidden property="method" value="paginaIniziale"/>
			<center>
			
				<h3>Benvenuto nella nostra web-app!</h3>
				<html:submit value="entra nel sito"/>
			</center>
				
		</html:form>
		
		
</body>
</html>