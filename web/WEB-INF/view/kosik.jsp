<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Košík   <span class="glyphicon glyphicon-shopping-cart"></span></h2>


<c:choose>
    <c:when  test="${produkty.size() == 0}">
        <p>Košík je prázdný</p>
    </c:when>
    <c:otherwise>
        <div class="container-fluid">

            <form method="post" class="form-group">
                <table class="table">
                    <c:forEach var="type" items="${produkty}">
                        <tr>
                            <td><img src="pivo.jpg" width="100" height="100"/></td>
                            <td>Id produkt: <strong>${type.key}</strong></td>
                            <td>Cena: <strong>50Kč</strong></td>
                            <td>
                                Počet kusů: <input type="number" name="pocet[${type.key}]" value="${type.value}" />
                                <button><a class="glyphicon glyphicon-remove" id="btn-remove" href="kosik.do?action=removeItem&amp;id=${type.key}"></a></button>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>Celkem položek: <strong>10</strong> </td>
                        <td></td>
                        <td>Celková cena: <strong>150 Kč</strong></td>
                    </tr>
                </table>
            </form>
        </div>
    </c:otherwise>
</c:choose>