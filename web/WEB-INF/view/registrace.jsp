<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript">
    $(document).ready(function () {
        $('input[type="radio"]').click(function () {
            if ($(this).attr("value") == "ano") {
                $(".fakturacni-adr").hide('fast');
            }
            if ($(this).attr("value") == "ne") {
                $(".fakturacni-adr").show('fast');
            }
        });
    });
</script>


<form class="form-horizontal" id="form-norm" method="post">
    <input type="hidden" name="action" value="register" />
    <h2 class="form-signin-heading">Registrace</h2>
    
    <c:if test="${errors != null}">
        Vyplňte prosím všechny údaje.
        <ul>
            <c:forEach var="error" items="${errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>
    </c:if>
    
    <div class="row">
        <div class="col-sm-4">        
            <input type="text" name="jmeno" class="form-control" placeholder="Jméno" value="${zakaznik.jmeno}" required >
            <input type="text" name="prijmeni" class="form-control" placeholder="Příjmení" value="${zakaznik.prijmeni}" required >
            <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Zadejte email" value="${zakaznik.email}" required >
            <input type="text" name="telefon" class="form-control" placeholder="Telefon" value="${zakaznik.telefon}">
            <input type="password" name="heslo" id="inputPassword" class="form-control" placeholder="Heslo" required >   
            <input type="password" name="heslo_znovu" id="inputPassword" class="form-control" placeholder="Zopakujte heslo" required >   
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4">
            Doručovací a fakturační adresy se shodují
            <label><input type="radio" name="stejna_adresa"  value="ano"> Ano</label>
            <label><input type="radio" name="stejna_adresa" checked="checked" value="ne"> Ne</label>                            
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <h3>Doručovací adresa</h3>
            <input type="text" name="dorucovaci_ulice" class="form-control" placeholder="Ulice" value="${zakaznik.adresa.dorucovaciUlice}" required >
            <input type="text" name="dorucovaci_cp" class="form-control" placeholder="Číslo popisné" value="${zakaznik.adresa.dorucovaciCP}" required >
            <input type="text" name="dorucovaci_mesto" class="form-control" placeholder="Město"  value="${zakaznik.adresa.dorucovaciMesto}" required >
            <input type="text" name="dorucovaci_psc" class="form-control" placeholder="PSČ" value="${zakaznik.adresa.dorucovaciPSC}" required >

        </div>
        <div class="col-sm-4 fakturacni-adr">
            <h3>Fakturační adresa</h3>
            <input type="text" name="fakturacni_ulice" class="form-control" placeholder="Ulice" value="${zakaznik.adresa.fakturacniUlice}" >
            <input type="text" name="fakturacni_cp" class="form-control" placeholder="Číslo popisné"  value="${zakaznik.adresa.fakturacniCP}" >
            <input type="text" name="fakturacni_mesto" class="form-control" placeholder="Město"  value="${zakaznik.adresa.fakturacniMesto}" >
            <input type="text" name="fakturacni_psc" class="form-control" placeholder="PSČ"  value="${zakaznik.adresa.fakturacniPSC}" >

        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-2" >
            <div class="col-sm-4">
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Registrovat</button>
            </div>
        </div>
    </div>
</form>

