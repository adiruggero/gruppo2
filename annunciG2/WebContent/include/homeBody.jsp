<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<center>
		
		<html:form styleId="ricercaForm" method="POST" action="gestioneAnnunci.do">
		<table>
			<tr>
				<td>Seleziona una categoria</td>
				<td><html:select name="annunciForm" property="categoria.codiceCategoria">
						<html:option value="0">Seleziona Qualcosa</html:option>
						<html:optionsCollection name="annunciForm" property="listCategoria" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td>Descrizione</td>			
				<td><html:text property="descrizione"/>	</td>	
			</tr>	
			
			<html:hidden property="method" value="findAnnunci"/>
			<tr><td><html:submit value="cerca un annuncio"/></td></tr>
		</table>
			
		</html:form>

</center>