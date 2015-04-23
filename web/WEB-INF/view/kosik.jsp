<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


<h2>Košík   <span class="glyphicon glyphicon-shopping-cart"></span></h2>


<c:choose>
    <c:when  test="${polozky.size() == 0}">
        <p>Košík je prázdný</p>
    </c:when>
    <c:otherwise>
        <div class="container-fluid">
            <form action="${base_url}kosik.do" method="post" class="form-group">
                <input type="hidden" name="action" value="order" />
                <div class="row">
                    <table class="table">
                        <c:forEach var="item" items="${polozky}">
                            <tr>
                                <td><img src="${produkty.get(item.key).nazevObrazku}" class="img-responsive" style="height: 100px;"/></td>                                
                                <td>Název <strong>${produkty.get(item.key).nazev}</strong></td>
                                <td>Cena za ks: <strong>${produkty.get(item.key).cena}Kč</strong></td>
                                <td>
                                    Počet kusů: <input type="number" name="pocet[${item.key}]" value="${item.value}" />
                                </td>
                                <td>
                                    Cena celkem: <strong><fmt:formatNumber value="${produkty.get(item.key).cena * item.value}" pattern="#,##0.00" />&nbsp;Kč</strong>
                                </td>
                                <td>
                                    <a class="glyphicon glyphicon-remove" id="btn-remove" href="kosik.do?action=removeItem&amp;id=${item.key}"></a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>Celkem&nbsppoložek: <strong>${polozky.size()}</strong> </td>
                            <td></td>
                            <td>Celková&nbspcena: <strong><fmt:formatNumber value="${totalPrice}" pattern="#,##0.00" />&nbspKč</strong></td>

                        </tr>
                    </table>
                </div>

                <div class="row">
                    <c:if test="${dobaDodani == 0}">
                        Ohledně doby vyřízení objednávky se Vám ozveme.
                    </c:if>
                    <c:if test="${dobaDodani > 0}">
                        Zboží Vám dodáme do ${dobaDodani} dní.
                    </c:if>
                </div>

                <div class="row">
                    <hr>
                    <h3>Doprava</h3>
                    <div class="col-sm-5">
                        <select class="form-control" name="zpusobDoruceni">                    
                            <c:forEach items="${doprava}" var="zpusob">
                                <option value="${zpusob.idZpusobDoruceni}">${zpusob.nazevZpusobu} +${zpusob.cenaDoruceni}Kč</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- Objednavka udaje -->
                <c:if test="${!auth_state}">
                    <div class="row">
                        <hr>
                        <h3>Kontaktní údaje</h3>
                        
                         <c:if test="${errors != null}">
                            Vyplňte prosím všechny údaje.
                            <ul>
                                <c:forEach var="error" items="${errors}">
                                    <li>${error}</li>
                                </c:forEach>
                            </ul>
                        </c:if>
                        
                        <div class="col-sm-5">                      
                            <input class="form-control" type="text" name="jmeno" placeholder="Jméno" value="${zakaznik.jmeno}" /><br>
                            <input class="form-control" type="text" name="prijmeni" placeholder="Příjmení" value="${zakaznik.prijmeni}" /><br>
                            <input class="form-control" type="text" name="telefon" placeholder="Telefon" value="${zakaznik.telefon}" /><br>
                            <input class="form-control" type="text" name="email" placeholder="Email" value="${zakaznik.email}" /><br>
                            <input class="form-control" type="password" name="heslo" placeholder="Heslo" /><br>

                            <div>
                                Doručovací a fakturační adresy se shodují
                                <label><input type="radio" name="stejna_adresa"  value="ano"> Ano</label>
                                <label><input type="radio" name="stejna_adresa" checked="checked" value="ne"> Ne</label>                            
                            </div>
                            <br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            Doručovací adresa
                            <input type="text" name="dorucovaci_ulice" class="form-control" placeholder="Ulice" value="${zakaznik.adresa.dorucovaciUlice}"  /><br />
                            <input type="text" name="dorucovaci_cp" class="form-control" placeholder="Číslo popisné" value="${zakaznik.adresa.dorucovaciCP}"  /><br />
                            <input type="text" name="dorucovaci_mesto" class="form-control" placeholder="Město"  value="${zakaznik.adresa.dorucovaciMesto}"  /><br />
                            <input type="text" name="dorucovaci_psc" class="form-control" placeholder="PSČ" value="${zakaznik.adresa.dorucovaciPSC}"  /><br />

                        </div>
                        <div class="col-sm-5">                        
                            <div class="fakturacni-adr">
                                Fakturační adresa
                                <input type="text" name="fakturacni_ulice" class="form-control" placeholder="Ulice" value="${zakaznik.adresa.fakturacniUlice}" /><br />
                                <input type="text" name="fakturacni_cp" class="form-control" placeholder="Číslo popisné"  value="${zakaznik.adresa.fakturacniCP}" /><br />
                                <input type="text" name="fakturacni_mesto" class="form-control" placeholder="Město"  value="${zakaznik.adresa.fakturacniMesto}" /><br />
                                <input type="text" name="fakturacni_psc" class="form-control" placeholder="PSČ"  value="${zakaznik.adresa.fakturacniPSC}" /><br />
                            </div>
                        </div>
                    </div> 
                </c:if>

                <div class="row">
                    <div class="col-sm-5">   
                        <br />  
                        <input type="submit" class="btn btn-primary btn-lg" id="btn-order" value="Objednat" />
                    </div>
                </div>
            </form>
        </div>
    </c:otherwise>
</c:choose>