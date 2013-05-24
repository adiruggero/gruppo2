<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<center>
		
		<html:form method="POST" action="gestioneAnnunci.do">
			
			<table>
					<tr><td>Prodotto</td></tr>
					
					<tr>
						<td>Descrizione prodotto</td>
						<td><html:text property="prodotto.descrizione"/></td>
					</tr>
					<tr>
						<td>Prezzo prodotto</td>
						<td><html:text property="prodotto.prezzo"/></td>
					</tr>
					
					<tr><td>Annuncio</td></tr>
					
					<tr>
						<td>Descrizione Annuncio</td>
						<td><html:text property="descrizione"/></td>
					</tr>
					<tr>	
						<td>Categoria</td>
						<td><html:select name="annunciForm" property="categoria.codiceCategoria">
							<html:optionsCollection name = "annunciForm" property = "listCategoria"/>
							</html:select>
						</td>
					</tr>
					
					<tr><td><html:submit value="Inserisci annuncio"/></td></tr>
					<html:hidden property="method" value="inserisciAnnuncio"/>
			</table>
				
				
		
		
		
		
		
		</html:form>
</center>