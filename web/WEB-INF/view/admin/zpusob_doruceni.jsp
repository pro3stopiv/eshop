<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="${base_url}zpusob_doruceni.do?action=showEdit" class="btn btn-primary">Nový zp&#367;sob doru&#269;ení</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>Název zp&#367;sobu doru&#269;ení</th>
	    <th>Cena</th>
	    <th>Smazání</th>
	</tr>
    </thead>
    <c:forEach items="${zpusob_doruceni}" var="zpusob_doruceni">
        <tr>
            <td><a href="${base_url}zpusob_doruceni.do?action=showEdit&amp;id=${zpusob_doruceni.idZpusobDoruceni}">${zpusob_doruceni.nazevZpusobu}</a></td>
            <td>${zpusob_doruceni.cenaDoruceni} K&#269;</td>
	    <td><a href="${base_url}zpusob_doruceni.do?action=delete&amp;id=${zpusob_doruceni.idZpusobDoruceni}" class="btn btn-danger">smazat</a></td>
    </tr>
    </c:forEach>
</table>