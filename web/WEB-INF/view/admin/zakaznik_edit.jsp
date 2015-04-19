<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid zakaznik ">
    <form method="post" action="${base_url}zakaznik.do" class="well">
        <div class="form-signin ">
            <div class="row">

                <h2 class="form-signin-heading">Údaje zákazníka</h2>

                <label for="jmeno" class="col-sm-8 control-label">Jméno</label>
                <input class="form-control" name="jmeno" <c:if test="${zakaznik != null}">value="${zakaznik.jmeno}"</c:if> />

                    <label for="prijmeni" class="col-sm-8 control-label">Příjmení</label>
                    <input class="form-control" name="prijmeni" <c:if test="${zakaznik != null}">value="${zakaznik.prijmeni}"</c:if> />

                    <label for="email" class="col-sm-8 control-label">Email</label>
                    <input class="form-control" name="email" type="email" <c:if test="${zakaznik != null}">value="${zakaznik.email}"</c:if> />

                    <label for="telefon" class="col-sm-8 control-label">Telefon</label>
                    <input class="form-control" name="telefon" <c:if test="${zakaznik != null}">value="${zakaznik.telefon}"</c:if> />

                </div>
            </div>
            <h2 class="row-centered">Adresy</h2><br />
            <div class="row zakaznik ">
                <div class="col-md-6">
                    <h4 class="form-signin-heading">Doručovací</h4>
                    <label for="dorucovaciUlice" class="col-sm-8 control-label">Ulice</label>
                    <input class="form-control" name="dorucovaciUlice" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciUlice}"</c:if> />

                    <label for="dorucovaciCP" class="col-sm-8 control-label">Číslo popisné</label>
                    <input class="form-control" name="dorucovaciCP" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciCP}"</c:if> />

                    <label for="dorucovaciMesto" class="col-sm-8 control-label">Město</label>
                    <input class="form-control" name="dorucovaciMesto" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciMesto}"</c:if> />

                    <label for="dorucovaciPSC" class="col-sm-8 control-label">PSČ</label>
                    <input class="form-control" name="dorucovaciPSC" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciPSC}"</c:if> />
                </div>
                <div class="col-md-6">
                    <h4 class="form-signin-heading">Fakturační</h4>
                    <label for="fakturacniUlice" class="col-sm-8 control-label">Ulice</label>
                    <input class="form-control" name="fakturacniUlice" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniUlice}"</c:if> />

                    <label for="fakturacniCP" class="col-sm-8 control-label">Číslo popisné</label>
                    <input class="form-control" name="fakturacniCP" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniCP}"</c:if> />

                    <label for="fakturacniMesto" class="col-sm-8 control-label">Město</label>
                    <input class="form-control" name="fakturacniMesto" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniMesto}"</c:if> />

                    <label for="fakturacniPSC" class="col-sm-8 control-label">PSČ</label>
                    <input class="form-control" name="fakturacniPSC" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniPSC}"</c:if> />
                </div>
            </div>

            <div class="row-centered">
                <br />
            <c:if test="${zakaznik != null}">
                <input type="hidden" name="id" value="${zakaznik.idZakaznik}" />
            </c:if>
            <input type="hidden" name="action" value="edit" />
            <input type="submit" class="btn bg-primary btn-lg" />
            <br />
        </div>

    </form>
    <br />
</div>