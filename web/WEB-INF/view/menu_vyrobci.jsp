<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list-group">
    <h3>Pivovary</h3>
    <c:forEach items="${menuVyrobci}" var="vyrobce">
        <a href="./vyrobceVypis.do?id=${vyrobce.idVyrobce}" class="list-group-item">${vyrobce.nazev}</a>
    </c:forEach>
</div>