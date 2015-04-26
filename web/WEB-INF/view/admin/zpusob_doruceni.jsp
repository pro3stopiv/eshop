<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="${base_url}zpusob_doruceni.do?action=showEdit" class="btn btn-primary">Nový způsob doručení</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>Název způsobu doručení</th>
	    <th>Cena</th>
	    <th>Smazání</th>
	</tr>
    </thead>
    <c:forEach items="${zpusob_doruceni}" var="zpusob_doruceni">
        <tr>
            <td><a href="${base_url}zpusob_doruceni.do?action=showEdit&amp;id=${zpusob_doruceni.idZpusobDoruceni}">${zpusob_doruceni.nazevZpusobu}</a></td>
            <td><fmt:formatNumber value="${zpusob_doruceni.cenaDoruceni}" pattern="#,##0.00 Kč" /></td>
	    <td><a href="${base_url}zpusob_doruceni.do?action=delete&amp;id=${zpusob_doruceni.idZpusobDoruceni}" class="btn btn-danger">smazat</a></td>
    </tr>
    </c:forEach>
</table>