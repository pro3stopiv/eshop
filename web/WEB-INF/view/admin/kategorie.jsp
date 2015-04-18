<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <a href="${base_url}kategorie.do?action=showEdit" class="btn btn-primary">Nov� kategorie</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>N�zev kategorie</th>
	    <th>Popis</th>
	    <th>Smaz�n�</th>
	</tr>
    </thead>
<c:forEach items="${kategorie}" var="kategorie">
    <tr>
        <td><a href="${base_url}kategorie.do?action=showEdit&amp;id=${kategorie.idKategorie}">${kategorie.nazev}</a></td>            
        <td>${kategorie.popis}</td>
	<td><a href="${base_url}kategorie.do?action=delete&amp;id=${kategorie.idKategorie}" class="btn btn-danger">Smazat</a></td>
    </tr>
</c:forEach>
</table>
