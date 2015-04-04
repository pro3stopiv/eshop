<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li>
        <a href="${base_url}produkt.do?action=showEdit">Nový produkt</a>
    </li>
    <c:forEach items="${produkty}" var="produkt">
        <li>
            <a href="${base_url}produkt.do?action=showEdit&amp;id=${produkt.idProdukt}">${produkt.nazev}</a>
            <a href="${base_url}produkt.do?action=delete&amp;id=${produkt.idProdukt}">smazat</a>
        </li>
    </c:forEach>
</ul>
