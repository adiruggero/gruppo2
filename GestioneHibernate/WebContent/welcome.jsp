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
		<table width="100%" height="600px" border="2">
			<tr>
				<td colspan="2" height="20%">
				<jsp:include flush="true" page="include/head.jsp"/></td>
			</tr>
			<tr>
				<td width="15%" height="40%">
					<jsp:include flush="true" page="include/private.jsp"/>
				</td>
						
				<td width="85%" height="80%">
					<jsp:include flush="true" page="include/body.jsp"/>
				</td>
			</tr>	
			
			
		</table>
</body>
</html>