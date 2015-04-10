<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list-group">
    <h3>Pivo</h3>
    <c:forEach items="${menuKategorie}" var="kategorie">        
        <a href="./kategorie.do?id=${kategorie.idKategorie}" class="list-group-item">${kategorie.nazev}</a>
    </c:forEach>
</div>