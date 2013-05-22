<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<base href="<%=basePath%>"/>
<body>
		<table width="100%" height="600px" border="2">
			<tr>
				<td colspan="2" height="20%"><jsp:include flush="true" page="include/header.jsp"/></td>
			</tr>
			<tr>
				<td width="15%" height="40%">
					<jsp:include flush="true" page="include/best.jsp"/>
					<br>
					<br>
					<jsp:include flush="true" page="include/private.jsp"/>
				</td>
						
				<td width="85%" height="80%">
					<jsp:include flush="true" page="include/bodyRegistrazione.jsp"/>
				</td>
			</tr>	
			
			
		</table>
</body>
</html>