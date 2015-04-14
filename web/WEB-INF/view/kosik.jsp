<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
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


<h2>Košík   <span class="glyphicon glyphicon-shopping-cart"></span></h2>


<c:choose>
    <c:when  test="${polozky.size() == 0}">
        <p>Košík je prázdný</p>
    </c:when>
    <c:otherwise>
        <div class="container-fluid">

            <form method="post" class="form-group">
                <div class="row">
                    <table class="table">
                        <c:forEach var="item" items="${polozky}">
                            <tr>
                                <td><img src="pivo.jpg" width="100" height="100"/></td>
                                <td>Název <strong>${produkty.get(item.key).nazev}</strong></td>
                                <td>Cena za ks: <strong>${produkty.get(item.key).cena}Kč</strong></td>
                                <td>
                                    Počet kusů: <input type="number" name="pocet[${item.key}]" value="${item.value}" />
                                </td>
                                <td>
                                    Cena celkem: <strong>${produkty.get(item.key).cena * item.value}Kč</strong>
                                </td>
                                <td>
                                    <a class="glyphicon glyphicon-remove" id="btn-remove" href="kosik.do?action=removeItem&amp;id=${item.key}"></a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>Celkem položek: <strong>${polozky.size()}</strong> </td>
                            <td></td>
                            <td>Celková cena: <strong>${totalPrice} Kč</strong></td>

                        </tr>
                    </table>
                </div>

                <!-- Objednavka udaje -->
                <div class="row">
                    <hr>
                    <h3>Kontaktní údaje</h3>
                    <div class="col-sm-5">                      
                        <input class="form-control" type="text" name="jmeno" placeholder="Jméno" value="${auth_user}" /><br>
                        <input class="form-control" type="text" name="prijmeni" placeholder="Příjmení" /><br>
                        <input class="form-control" type="text" name="telefon" placeholder="Telefon" /><br>
                        <input class="form-control" type="text" name="email" placeholder="Email" /><br>

                        <div>
                            Doručovací a fakturační adresy se shodují
                            <label><input type="radio" name="adresa"  value="ano"> Ano</label>
                            <label><input type="radio" name="adresa" checked="checked" value="ne"> Ne</label>                            
                        </div>
                        <br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        Doručovací adresa
                        <input class="form-control" type="text" name="ulice" placeholder="Ulice" /><br>
                        <input class="form-control" type="text" name="cp" placeholder="Číslo popisné" /><br>
                        <input class="form-control" type="text" name="mesto" placeholder="Město" /><br>
                        <input class="form-control" type="text" name="psc"  placeholder="PSČ"/><br>

                        <select class="form-control">                       
                            <option>Poštou (bankovní převod)</option>
                            <option>Osobní odběr (platba hotově)</option>
                        </select>
                        <br>
                        <br>
                        <a href="#" class="btn btn-primary btn-lg" id="btn-order" >Objednat</a>
                    </div>
                    <div class="col-sm-5">                        
                        <div class="fakturacni-adr">
                            Fakturační adresa
                            <input class="form-control" type="text" name="ulice" placeholder="Ulice" /><br>
                            <input class="form-control" type="text" name="cp" placeholder="Číslo popisné" /><br>
                            <input class="form-control" type="text" name="mesto" placeholder="Město" /><br>
                            <input class="form-control" type="text" name="psc" placeholder="PSČ" /><br>
                        </div>
                    </div>
                </div>                  
            </form>
        </div>
    </c:otherwise>
</c:choose>