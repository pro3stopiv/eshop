<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach items="${produkty}" var="produkt">
    <div class="col-md-4 text-center produkt">        
        <div class="thumbnail img-responsive" style="text-decoration: none;">
            <a href="./produkt.do?id=${produkt.getIdProdukt()}">

                
                <c:choose>
                    <c:when test="${!empty produkt.nazevObrazku}">
                        <img style="padding-right: 10px;" src="${produkt.nazevObrazku}" />                                                                                                                                                                                                                                                                                                                                                             
                    </c:when>
                    <c:otherwise>  
                        <img style="padding-right: 10px;" src="<c:url value="/images/produkt_placeholder.png" />" /> 
                    </c:otherwise>
                </c:choose> 

                <h2>${produkt.getNazev()}</h2>                      
                <h3 class="text-danger">${produkt.getCena()} Kč</h3>   
            </a>
        </div>
    </div>
</c:forEach>