<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${produkty}" var="produkt">
        <li>
            <a href="./produkt.do?id=${produkt.getProdukt().getIdProdukt()}">${produkt.getProdukt().getNazev()}</a>
        </li>
    </c:forEach>
</ul>
