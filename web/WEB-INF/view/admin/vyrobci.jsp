<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li>
        <a href="${base_url}vyrobce.do?action=showEdit">Nový výrobce</a>
    </li>
    <c:forEach items="${vyrobci}" var="vyrobce">
        <li>
            <a href="${base_url}vyrobce.do?action=showEdit&amp;id=${vyrobce.idVyrobce}">${vyrobce.nazev}</a>
            <a href="${base_url}vyrobce.do?action=delete&amp;id=${vyrobce.idVyrobce}">smazat</a>
        </li>
    </c:forEach>
</ul>
