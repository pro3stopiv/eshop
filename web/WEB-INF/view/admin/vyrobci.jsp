<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="${base_url}vyrobce.do?action=showEdit" class="btn btn-primary">Nový výrobce</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>Název pivovaru</th>
	    <th>Adresa</th>
	    <th>Telefon</th>
	    <th>e-mail</th>
	    <th>www</th>
	    <th>Smazání</th>
	</tr>
    </thead>
    <c:forEach items="${vyrobci}" var="vyrobce">
        <tr>
            <td><a href="${base_url}vyrobce.do?action=showEdit&amp;id=${vyrobce.idVyrobce}">${vyrobce.nazev}</a></td>
            <td>
		${vyrobce.kontakt.ulice} ${vyrobce.kontakt.cp} <br />
		${vyrobce.kontakt.psc} ${vyrobce.kontakt.mesto}
	    </td>
	    <td>${vyrobce.kontakt.telefon}</td>
	    <td>${vyrobce.kontakt.email}</td>
	    <td><a href="${vyrobce.kontakt.www}">${vyrobce.kontakt.www}</a></td>
	    <td><a href="${base_url}vyrobce.do?action=delete&amp;id=${vyrobce.idVyrobce}" class="btn btn-danger">smazat</a></td>
        </tr>
    </c:forEach>
</table>

