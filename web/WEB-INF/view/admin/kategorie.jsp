<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li>
        <a href="${base_url}kategorie.do?action=showEdit">Nová kategorie</a>
    </li>
    <c:forEach items="${kategorie}" var="kategorie">
        <li>
            <a href="${base_url}kategorie.do?action=showEdit&amp;id=${kategorie.idKategorie}">${kategorie.nazev}</a>
            <a href="${base_url}kategorie.do?action=delete&amp;id=${kategorie.idKategorie}">smazat</a>
        </li>
    </c:forEach>
</ul>
