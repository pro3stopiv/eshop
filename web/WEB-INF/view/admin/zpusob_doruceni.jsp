<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="${base_url}zpusob_doruceni.do?action=showEdit" class="btn btn-primary">Nov� zp&#367;sob doru&#269;en�</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>N�zev zp&#367;sobu doru&#269;en�</th>
	    <th>Cena</th>
	    <th>Smaz�n�</th>
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