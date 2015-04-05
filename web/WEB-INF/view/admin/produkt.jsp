<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">

    <a href="${base_url}produkt.do?action=showEdit" class="btn btn-primary">Nový produkt</a>

    <c:forEach items="${produkty}" var="produkt">
        <tr>
            <td><a href="${base_url}produkt.do?action=showEdit&amp;id=${produkt.idProdukt}">${produkt.nazev}</a></td>
            <td><a href="${base_url}produkt.do?action=delete&amp;id=${produkt.idProdukt}" class="btn btn-danger">smazat</a></td>
    </tr>
    </c:forEach>
</table>
