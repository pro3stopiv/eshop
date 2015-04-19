<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="container">
    <form method="post" action="${base_url}zpusob_doruceni.do" class="form-signin well">
        <h2 class="form-signin-heading">Způsob doručení</h2>
        <label for="nazev" class="col-sm-8 control-label">Název</label>
        <input name="nazev" class="form-control" <c:if test="${zpusob_doruceni != null}">value="${zpusob_doruceni.nazevZpusobu}"</c:if> />
            <label for="cena" class="col-sm-8 control-label">Cena</label>
            <input name="cena" class="form-control"<c:if test="${zpusob_doruceni != null}">value="${zpusob_doruceni.cenaDoruceni}"</c:if> />
            <br />
            <div class="row-centered">
            <c:if test="${zpusob_doruceni != null}">
                <input type="hidden" name="id" value="${zpusob_doruceni.idZpusobDoruceni}" />
            </c:if>
            <input type="hidden" name="action" value="edit" />
            <input type="submit" class="btn bg-primary btn-lg" />
        </div>
    </form>
</div>