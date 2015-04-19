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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/layout.css" />" />
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>	
        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
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
                                    <li><a href="${base_url}index.do">Úvod</a></li>
                                    <li><a href="${base_url}kontakt.do">Kontakty</a></li>
                                    <li><a href="${base_url}obchodni-podminky.do">Obchodní podmínky</a></li>
                                    <li><a href="${base_url}o-nas.do">O nás</a></li>
                                    <li><a href="${base_url}kosik.do">Košík</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right" id="menu-pravo">
                                    <c:choose>
                                        <c:when test="${auth_state}">
                                            <form method="post" class="form-inline">                                    
                                                Přihlášen uživatel ${auth_user.jmeno} ${auth_user.prijmeni} (${auth_user.email})     
                                                <a href="?logout=t" class="  btn-sm">Odhlásit</a>
                                            </form>                                                                                                                                                                                                                                                                                                                                                               
                                        </c:when>
                                        <c:otherwise>  
                                            <form method="post" class="form-inline" id="login">                                    
                                                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required>
                                                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Heslo" required>
                                                <input type="submit" class="btn btn-md btn-primary" value="Přihlásit"/>
                                                <a href="${base_url}registrace.do">Registrovat</a>
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
            <!-- panel kategorii -->
            <div class="row">
                <div class="col-xs-3 kategorie">                    
                    <form class="navbar-form">
                        <h3>Kategorie</h3>                    
                        <div class="form-group">
                            <input type="text" class="form-control input-sm right" placeholder="hledat">
                        </div>
                        <button type="submit" class="btn-default btn-sm"><span class="glyphicon glyphicon-search"></span></button>                                    


                        <jsp:include page="./menu_kategorie.jsp" />

                        <jsp:include page="./menu_vyrobci.jsp" />
                    </form>
                </div>
                <div class="col-xs-8 obsah">
                    <!-- obsah -->
                    <jsp:include page="./${view}.jsp" />

                </div>
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