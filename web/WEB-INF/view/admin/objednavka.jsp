<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
    <thead>
	<th>ID objednávky</th>
	<th>Stav objednávky</th>
	<th>Datum</th>
	<th>Zákazník</th>
	<th>Celková cena</th>
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
    </tr>
</c:forEach>
</table>
