<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach items="${produkty}" var="produkt">
    <div class="col-md-4 text-center produkt">        
        <div class="thumbnail img-responsive" style="text-decoration: none; ">
            <a href="./produkt.do?id=${produkt.getIdProdukt()}">
                
                <c:choose>
                    <c:when test="${!empty produkt.nazevObrazku}">
                        <img src="${produkt.nazevObrazku}" class="img-responsive" alt="${produkt.nazev}" style="height: 150px; width: auto;" />
                    </c:when>
                    <c:otherwise>  
                        <img src="<c:url value="/images/produkt_placeholder.png" />" class="img-responsive" alt="placeholder" style="height: 150px; width: auto;" />
                    </c:otherwise>
                </c:choose> 

                <h2>${produkt.getNazev()}</h2>                      
                <h3 class="text-danger"><fmt:formatNumber value="${produkt.cena}" pattern="#,##0.00 Kč" /></h3>   
            </a>
        </div>
    </div>
</c:forEach>