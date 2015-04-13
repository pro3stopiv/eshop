<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Košík   <span class="glyphicon glyphicon-shopping-cart"></span></h2>


<c:choose>
    <c:when  test="${polozky.size() == 0}">
        <p>Košík je prázdný</p>
    </c:when>
    <c:otherwise>
        <div class="container-fluid">

            <form method="post" class="form-group">
                <table class="table">
                    <c:forEach var="item" items="${polozky}">
                        <tr>
                            <td><img src="pivo.jpg" width="100" height="100"/></td>
                            <td>Název <strong>${produkty.get(item.key).nazev}</strong></td>
                            <td>Cena za ks: <strong>${produkty.get(item.key).cena}Kč</strong></td>
                            <td>
                                Počet kusů: <input type="number" name="pocet[${item.key}]" value="${item.value}" />
                            </td>
                            <td>
                                Cena celkem: <strong>${produkty.get(item.key).cena * item.value}Kč</strong>
                            </td>
                            <td>
                                <a class="glyphicon glyphicon-remove" id="btn-remove" href="kosik.do?action=removeItem&amp;id=${item.key}"></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>Celkem položek: <strong>${polozky.size()}</strong> </td>
                        <td></td>
                        <td>Celková cena: <strong>${totalPrice} Kč</strong></td>
                        <td>
                            <a href="#" class="btn btn-primary" id="btn-order" >Objednat</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:otherwise>
</c:choose>