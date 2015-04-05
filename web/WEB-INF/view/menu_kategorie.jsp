<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="list-group">
    <c:forEach items="${menuKategorie}" var="kategorie">
        <li class="list-group-item">
            <a href="./kategorie.do?id=${kategorie.idKategorie}">${kategorie.nazev}</a>
        </li>
    </c:forEach>
</ul>