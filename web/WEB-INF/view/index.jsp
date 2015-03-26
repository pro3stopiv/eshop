<%-- 
    Document   : index
    Created on : 18.3.2015, 10:52:14
    Author     : baresja1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/layout.css" />" />
        <title>${title} | Stopiv</title>
    </head>
    <body>
       <jsp:include page="./menu.jsp" />
      
       <c:choose>
           <c:when test="${auth_state}">
               Přihlášen ${auth_user}. <a href="?logout=t">Odhlásit</a>
           </c:when>
           <c:otherwise>
            <form method="post">
                email <input name="email" />
                heslo <input type="password" name="password" />
                <input type="submit" value="Přihlásit" />
                <input type="hidden" name="action" value="login" />
            </form>
           </c:otherwise>
       </c:choose>
       
       <jsp:include page="./${view}.jsp" />
    </body>
</html>