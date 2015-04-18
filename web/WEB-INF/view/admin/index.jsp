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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/layout.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" />
        <title>${title} | Stopiv</title>
    </head>
    <body>
        <div class="container obal">
            <div class="row">
                <div class="col-sm-12 menu">
                    <!-- menu -->                                                         
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">                                    
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>                                
                            </div>
                            <div class="collapse navbar-collapse" id="menu">
			
                                <ul class="nav navbar-nav">
                                    <li><a href="${base_url}vyrobce.do" class="active">Výrobci</a></li>
                                    <li><a href="${base_url}kategorie.do">Kategorie</a></li>
                                    <li><a href="${base_url}produkt.do">Produkty</a></li>
				    <li><a href="${base_url}objednavka.do">Objednávky</a></li>
                                    <li><a href="${base_url}zpusob_doruceni.do">Způsoby doručení</a></li>
				    <li><a href="${base_url}zakaznik.do">Zákazníci</a></li>
				    
                                </ul>
			
                                <ul class="nav navbar-nav navbar-right" id="menu-pravo">
                                    <c:choose>
                                        <c:when test="${admin_auth_state}">
                                            <form method="post" class="form-inline">                                    
                                                Přihlášen uživatel ${admin_auth_user.login}     
                                                <a href="?logout=t" class="  btn-sm">Odhlásit</a>
                                            </form>
                                        </c:when>
                                        <c:otherwise>  
                                            <form method="post" class="form-inline" id="login" action="index.do">                                    
                                                <input type="text" class="form-control" name="login" placeholder="Login" required autofocus>
                                                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Heslo" required>
                                                <input type="submit" class="btn btn-md btn-primary" value="Přihlásit"/>
                                                
                                                <input type="hidden" name="action" value="login" />                               
                                            </form>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>             
            <div class="col-xs-12 obsah">
                <!-- obsah -->
                <jsp:include page="./${view}.jsp" />

            </div>

            <!-- paticka -->
            <div class="row">
                <div class="col-xs-12 paticka">
                    <div class="col-xs-4">
                        <h4 class="text-left">Stopiv - ráj milovníků piva</h4>
                    </div>
                    <div class="col-xs-4">
                        <h4 class="text-center">2015</h4>
                    </div>
                    <div class="col-xs-4">
                        <h4 class="text-right">Bareš, Čapek, Vlček, Vojtěch</h4>
                    </div>
                </div>
            </div>            
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/js/bootstrap.min.js" />"></script>                                                            
    </body>
</html>