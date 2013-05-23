<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
		
		
		
		
		<c:if test="${listProdotti ne null}">
			<h3>Ecco la lista dei tuoi acquisti!</h3>
				<logic:iterate name="listProdotti" id="prodotto">
					
					<bean:write name="prodotto" property="codiceProdotto"/>
					<bean:write name="prodotto" property="descrizione"/>
					<bean:write name="prodotto" property="dataAcquisto"/>

				</logic:iterate>
		
		</c:if>
		<c:if test="${listProdotti eq null }">
			
			<h3>Non hai effettuato acquisti!</h3>
			
		</c:if>

		

</center>