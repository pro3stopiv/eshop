<%-- 
    Document   : index
    Created on : 27.3.2015, 10:00:02
    Author     : Honza
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
      Admin
       <c:choose>
           <c:when test="${auth_state}">
               Přihlášen ${auth_user}. <a href="?logout=t">Odhlásit</a>
               <ul>
                   <li>
                       <a href="${base_url}vyrobce.do">Výrobci</a>
                   </li>
               </ul>
           </c:when>
           <c:otherwise>
            <form method="post">
                login <input name="login" />
                heslo <input type="password" name="password" />
                <input type="submit" value="Přihlásit" />
                <input type="hidden" name="action" value="login" />
            </form>
           </c:otherwise>
       </c:choose>
       
       <jsp:include page="./${view}.jsp" />
    </body>
</html>