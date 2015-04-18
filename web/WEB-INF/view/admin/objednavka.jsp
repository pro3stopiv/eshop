<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="${base_url}objednavka.do?action=showEdit" class="btn btn-primary">Nov� objedn�vka</a>
<table class="table table-hover">
    <thead>
	<th>ID objedn�vky</th>
	<th>Stav objedn�vky</th>
	<th>Datum</th>
	<th>Z�kazn�k</th>
	<th>Celkov� cena</th>
    </thead>
    

<c:forEach items="${objednavky}" var="objednavka">
    <tr>
        <td>
	    <a href="${base_url}objednavka.do?action=showEdit&amp;id=${objednavka.idObjednavka}">
		${objednavka.idObjednavka}  
		 
	    </a>
	</td>
	<td>
	    ${objednavka.stavObjednavky}
	</td>
	<td>${objednavka.datum}</td>
	<td>${objednavka.zakaznik.jmeno} ${objednavka.zakaznik.prijmeni}</td>
	<td>${objednavka.celkovaCena} K&#269;</td>
        <td><a href="${base_url}objednavka.do?action=delete&amp;id=${objednavka.idObjednavka}" class="btn btn-danger">Smazat</a></td>
    </tr>
</c:forEach>
</table>
