<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <form method="post" action="${base_url}kategorie.do" class="well form-signin">
            <h2 class="form-signin-heading">Kategorie</h2> 
            <label for="nazev" class="col-sm-2 control-label">Název</label>
            <input name="nazev" class="form-control"<c:if test="${kategorie != null}"> value="${kategorie.nazev}"</c:if> required /> 
            <label for="popis" class="col-sm-2 control-label">Popis</label>
            <textarea name="popis" class="form-control" required><c:if test="${kategorie != null}">${kategorie.popis}</c:if></textarea>                        

            <div class="row-centered">
            <c:if test="${kategorie != null}">
                <input type="hidden" name="id" value="${kategorie.idKategorie}"  />
            </c:if>
            <input type="hidden" name="action" value="edit" />
            <br /><input type="submit" class="btn btn-lg bg-primary" />
            </div>
    </form>
</div>          



