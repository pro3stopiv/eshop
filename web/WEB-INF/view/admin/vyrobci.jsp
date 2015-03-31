<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li>
        <a href="${base_url}vyrobce.do?action=edit">Nový výrobce</a>
    </li>
    <c:forEach items="${vyrobci}" var="vyrobce">
        <li>
            <a href="${base_url}vyrobce.do?action=edit&amp;id=${vyrobce.idVyrobce}">${vyrobce.nazev}</a>
        </li>
    </c:forEach>
</ul>
