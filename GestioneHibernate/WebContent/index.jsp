<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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

<html:form method="POST" action="persona.do">
			
			<html:hidden property="method" value="paginaIniziale"/>
			<center>
			
				<h3>BENVENUTO IN UN BEL SITO, CLICCA "ENTRA" ED ENTRA!</h3>
				
				
				<img src="http://s18.postimage.org/6z9ndt0rd/zequila.jpg" class="img-rounded"><br><br><br>
				
				<html:submit styleClass="btn btn-info" value="ENTRA"/>
			</center>
				
		</html:form>





</body>
</html>