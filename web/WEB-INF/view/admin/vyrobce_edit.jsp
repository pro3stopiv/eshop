<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container ">
    <form method="post" action="${base_url}vyrobce.do" class="form-norm well">
        <div class="row">
            <div class="col-md-6">
                <h2>Informace o výrobci</h2>
                <div class="form-group">
                    <label for="nazev" class="col-sm-2 control-label">Název</label>
                    <input name="nazev" class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.nazev}"</c:if> />
                    </div>

                    <div class="form-group">
                        <label for="popis" class="col-sm-2">Popis</label>
                        <textarea name="popis" class="form-control"><c:if test="${vyrobce != null}">${vyrobce.popis}</c:if></textarea>
                    </div>
                    <div class="form-group">
                        <label for="latitude" class="col-sm-2 control-label">Latitude</label>
                        <input name="latitude" class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.latitude}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="longtitude" class="col-sm-2 control-label">Longtitude</label>
                        <input name="longtitude" class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.longtitude}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="altitude" class="col-sm-2 control-label">Altitude</label>
                        <input name="altitude" class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.altitude}"</c:if> />
                    </div>            
                </div>   
                <div class="col-md-6">
                    <h2>Kontakt</h2>            
                    <div class="form-group">
                        <label for="ulice" class="col-sm-8 control-label">Ulice</label>
                        <input name="ulice" class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.ulice}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="cp" class="col-sm-8 control-label">Číslo popisné</label>
                        <input name="cp"  class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.cp}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="mesto" class="col-sm-8 control-label">Město</label>
                        <input name="mesto"  class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.mesto}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="psc" class="col-sm-8 control-label">PSČ</label>
                        <input name="psc"  class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.psc}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="telefon" class="col-sm-8 control-label">Telefon</label>
                        <input name="telefon"  class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.telefon}"</c:if> />
                    </div>
                    <div class="form-group">
                        <label for="www" class="col-sm-8 control-label">www</label>
                        <input name="www"  class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.www}"</c:if> />                     
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-8 control-label">Email</label>
                        <input name="email"  class="form-control"<c:if test="${vyrobce != null}">value="${vyrobce.kontakt.email}"</c:if> />
                    </div>
                </div>
            </div>
            <div class="row-centered">                                                                   
            <c:if test="${vyrobce != null}">
                <input type="hidden" name="id" value="${vyrobce.idVyrobce}" />
            </c:if>
            <input type="hidden" name="action" value="edit" />
            <input type="submit" class="btn bg-primary btn-lg" />
        </div>                
    </form>
    <br>
</div>