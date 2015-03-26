<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${menuKategorie}" var="kategorie">
        <li>
            <a href="./kategorie.do?id=${kategorie.getIdKategorie()}">${kategorie.getNazev()}</a>
        </li>
    </c:forEach>
</ul>
