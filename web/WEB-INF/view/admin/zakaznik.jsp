<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="${base_url}zakaznik.do?action=showEdit" class="btn btn-primary">Nov� z�kazn�k</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>ID</th>
	    <th>Jm�no a p&#345;�jmen�</th>
	    <th>E-mail</th>
	    <th>Telefon</th>

	</tr>
    </thead>
    <c:forEach items="${zakaznici}" var="zakaznik">
    <tr>
	<td>${zakaznik.idZakaznik}</td>
        <td><a href="${base_url}zakaznik.do?action=showEdit&amp;id=${zakaznik.idZakaznik}">${zakaznik.jmeno} ${zakaznik.prijmeni}</a></td>            
        <td>${zakaznik.email}</td>
	<td>${zakaznik.telefon}</td>
	    </tr>
</c:forEach>
</table>
