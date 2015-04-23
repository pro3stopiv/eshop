<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list-group">
    <h3>Kategorie</h3>
    <c:forEach items="${menuKategorie}" var="k">        
        <a href="./kategorie.do?id=${k.idKategorie}" class="list-group-item<c:if test="${current_url == '/kategorie.do' && kategorie.idKategorie==k.idKategorie}"> active</c:if>">${k.nazev}</a>
    </c:forEach>
</div>