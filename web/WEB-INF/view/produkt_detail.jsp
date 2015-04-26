<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="col-md-6">
    <h1>${produkt.nazev}</h1>
    <p>Cena: <fmt:formatNumber value="${produkt.cena}" pattern="##0.00 Kč" /></p>
    <p>Popis: ${produkt.popis}</p>
    <p>Doba dodání: ${produkt.dobaDodani} dní</p>
    <p>Obsah alkoholu: ${produkt.obsahAlkoholu}%</p>

    <br />

    <h2>Objednat</h2>
    <form method="post">
        <input type="hidden" name="id_produkt" value="${produkt.idProdukt}" />
        <input type="number" name="pocet" value="1" min="0" />
        <input type="hidden" name="action" value="addToCart" />
        <input type="submit" value="Přidat do košíku" />
    </form>

    <p>Výrobce: <a href="${base_url}vyrobce.do?id=${produkt.vyrobce.idVyrobce}">${produkt.vyrobce.nazev}</a></p>

</div>
<div class="col-md-6">
    <br />
    <br />

    <c:choose>
        <c:when test="${!empty produkt.nazevObrazku}">
            <img src="${produkt.nazevObrazku}" class="img-responsive" alt="${produkt.nazev}" style="height: 250px; width: auto;" />
        </c:when>
        <c:otherwise>  
            <img src="<c:url value="/images/produkt_placeholder.png" />" class="img-responsive" alt="placeholder" style="height: 250px; width: auto;" />
        </c:otherwise>
    </c:choose> 

</div>