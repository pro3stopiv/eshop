<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <form method="post" action="${base_url}produkt.do" class="form-signin well">

        <h2 class="form-signin-heading">Produkt</h2>
        <label for="nazev" class="col-sm-8 control-label">Název</label>
        <input name="nazev" class="form-control"<c:if test="${produkt != null}">value="${produkt.nazev}"</c:if> />
            <label for="cena" class="col-sm-8 control-label">Cena</label>
            <input name="cena" class="form-control"<c:if test="${produkt != null}">value="${produkt.cena}"</c:if> />
            <label for="popis" class="col-sm-8 control-label">Popis</label>
            <textarea name="popis" class="form-control"><c:if test="${produkt != null}">${produkt.popis}</c:if></textarea>
            <label for="doba_dodani" class="col-sm-8 control-label">Doba dodání</label>
            <input name="doba_dodani" class="form-control"<c:if test="${produkt != null}">value="${produkt.dobaDodani}"</c:if> />
            <label for="obsah_alkoholu" class="col-sm-8 control-label">Obsah alkoholu</label>
            <input name="obsah_alkoholu" class="form-control"<c:if test="${produkt != null}">value="${produkt.obsahAlkoholu}"</c:if> />
            <br />
        <c:if test="${produkt != null}">

            <img src="${produkt.nazevObrazku}" class="form-control img-responsive" alt="${produkt.nazev}" style="width: auto; height: 80px;" />

        </c:if>
        <br />
        <label for="obrazek" class="col-sm-8 control-label">Název obrázku</label>
        <input name="obrazek" class="form-control"<c:if test="${produkt != null}">value="${produkt.nazevObrazku}"</c:if>  />

            <label for="vyrobce" class="col-sm-8 control-label">Výrobce</label>
            <select name="vyrobce" class="form-control">
            <c:forEach items="${vyrobci}" var="vyrobce">
                <option value="${vyrobce.idVyrobce}" <c:if test="${vyrobce.idVyrobce == produkt.vyrobce.idVyrobce}"> selected="selected"</c:if>>${vyrobce.nazev}</option>
            </c:forEach>
        </select>
        <br />
        <ul style="list-style-type: none;">
            <h4>Kategorie</h4>
            <c:forEach items="${kategorie}" var="kategor">
                <li>
                    <input type="checkbox" name="kategorie[${kategor.idKategorie}]" <c:if test="${produkt.hasKategorie(kategor)}">checked="checked"</c:if> />${kategor.nazev}
                    </li>
            </c:forEach>
        </ul>
        <br />
        <br />            
        <div class="row-centered">
            <c:if test="${produkt != null}">
                <input type="hidden" name="id" value="${produkt.idProdukt}" />
            </c:if>
            <input type="hidden" name="action" value="edit" />
            <input type="submit" class="btn bg-primary btn-lg" />
        </div>
    </form>
</div>