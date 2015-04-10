<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Kosik</h2>
<c:choose>
    <c:when  test="${produkty.size() == 0}">
        <p>Kosik je prazdny</p>
    </c:when>
    <c:otherwise>
        <form method="post">
            <c:forEach var="type" items="${produkty}">
               Id produkt: ${type.key}
               <input type="number" name="pocet[${type.key}]" value="${type.value}" />
               <a href="kosik.do?action=removeItem&amp;id=${type.key}">Smazat</a>
               <br />
            </c:forEach>


        </form>
    </c:otherwise>
</c:choose>