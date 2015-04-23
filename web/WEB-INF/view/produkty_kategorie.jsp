<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <h1>${kategorie.nazev}</h1>
    <br />
    <c:forEach items="${produkty}" var="produkt">
        <div class="col-md-4 text-center produkt">        
            <div class="thumbnail img-responsive" style="text-decoration: none;">
                <a href="./produkt.do?id=${produkt.getProdukt().getIdProdukt()}"> 
                    <img style="padding-right: 10px;" src="${produkt.produkt.nazevObrazku}" />            
                    <h2>${produkt.getProdukt().getNazev()}</h2>

                <h3 class="text-danger">${produkt.getProdukt().getCena()} Kč</h3>   
                </a>
            </div>
        </div>
    </c:forEach>
</div>