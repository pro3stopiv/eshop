<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li>
        <a href="${base_url}zpusob_doruceni.do?action=showEdit">Nový zp&#367;sob doru&#269;ení</a>
    </li>
    <c:forEach items="${zpusob_doruceni}" var="zpusob_doruceni">
        <li>
            <a href="${base_url}zpusob_doruceni.do?action=showEdit&amp;id=${zpusob_doruceni.idZpusobDoruceni}">${zpusob_doruceni.nazevZpusobu}</a>
            <a href="${base_url}zpusob_doruceni.do?action=delete&amp;id=${zpusob_doruceni.idZpusobDoruceni}">smazat</a>
        </li>
    </c:forEach>
</ul>
