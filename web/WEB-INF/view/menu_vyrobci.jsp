<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list-group">
    <h3>Pivovary</h3>
    <c:forEach items="${menuVyrobci}" var="v">
        <a href="${base_url}vyrobce.do?id=${v.idVyrobce}" class="list-group-item<c:if test="${current_url == '/vyrobce.do' && vyrobce.idVyrobce==v.idVyrobce}"> active</c:if>">${v.nazev}</a>
    </c:forEach>
</div>