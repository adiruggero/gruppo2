<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>


<center>
		<h4>Guarda quali sono i nostri annunci più visti!</h4>
		<table>
			<tr>
				<td>Descrizione</td>
				<td>Visite</td>
			</tr>
			<logic:iterate name="bestList" id="best">
			<tr>
				<td><bean:write name="best" property="descrizione"/></td>
				&nbsp;&nbsp;
				<td><bean:write name="best" property="visite"/></td>
			</tr>
			</logic:iterate>
		</table>
</center>