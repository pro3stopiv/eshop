<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid">
    <h1>${vyrobce.nazev}</h1>
    <br />
    
    <jsp:include page="./produkty.jsp" />
</div>