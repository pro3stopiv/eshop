<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${menuVyrobci}" var="vyrobce">
        <li>
            <a href="./vyrobceVypis.do?id=${vyrobce.idVyrobce}">${vyrobce.nazev}</a>
        </li>
    </c:forEach>
</ul>