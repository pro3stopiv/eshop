<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${menuKategorie}" var="kategorie">
        <li>
            <a href="./kategorie.do?id=${kategorie.idKategorie}">${kategorie.nazev}</a>
        </li>
    </c:forEach>
</ul>