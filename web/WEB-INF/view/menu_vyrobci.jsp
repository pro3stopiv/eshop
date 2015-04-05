<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="list-group">
    <c:forEach items="${menuVyrobci}" var="vyrobce">
        <li class="list-group-item">
            <a href="./vyrobceVypis.do?id=${vyrobce.idVyrobce}">${vyrobce.nazev}</a>
        </li>
    </c:forEach>
</ul>