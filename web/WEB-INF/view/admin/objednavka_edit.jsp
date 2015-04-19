<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid">
    <form method="post" action="${base_url}objednavka.do" class="well">
        <div class="row">
            <h2 style="text-align: center;">Obsah objednávky</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Název zboží</th>
                        <th>Počet kusů</th>
                        <th>Cena za kus</th>
                        <th>Cena za všechny</th>
                    </tr>
                </thead>
                <c:forEach items="${objednavka.produkty}" var="produkt">
                    <tr>
                        <td><a href="${base_url}produkt.do?action=showEdit&amp;id=${produkt.produkt.idProdukt}">${produkt.produkt.nazev} (${produkt.produkt.idProdukt})</a></td>
                        <td>${produkt.pocetKusu}</td>
                        <td>${produkt.cena} K&#269;</td>
                        <td>${produkt.cena * produkt.pocetKusu} K&#269;</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3"><b>Doprava:</b> ${objednavka.zpusobDoruceni.nazevZpusobu}</td>
                    <td>${objednavka.cenaDoruceni} K&#269;</td>
                </tr>
                <tr>               
                    <td colspan="3"><b>Cena celkem:</b></td>
                    <td>${objednavka.celkovaCena} K&#269;</td>
                </tr>
            </table>
        </div>

        <hr style="width: 100%; height: 1px; background-color: gray;" />

        <div class="row">
            <h2 style="text-align: center;">Informace o zákazníkovi</h2>                    
            <table class="table">      
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Jméno</th>
                        <th>P&#345;íjmení</th>
                        <th>E-mail</th>
                        <th>Telefon</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${objednavka.zakaznik.idZakaznik}</td>
                        <td>${objednavka.zakaznik.jmeno}</td>
                        <td>${objednavka.zakaznik.prijmeni}</td>                    
                        <td>${objednavka.zakaznik.email}</td>
                        <td>${objednavka.zakaznik.telefon}</td>
                    </tr>
                </tbody>
            </table>            
        </div>

        <hr style="width: 100%; height: 1px; background-color: gray;" />

        <div class="row adresy">
            <h2 style="text-align: center;">Adresa</h2>                    
            <div class="col-md-6">              
                <table class="pull-left">
                    <caption>Doručovací</caption>
                    <tr>    
                        <td>
                            ${objednavka.zakaznik.adresa.dorucovaciUlice} ${objednavka.zakaznik.adresa.dorucovaciCP}<br />
                            ${objednavka.zakaznik.adresa.dorucovaciPSC} ${objednavka.zakaznik.adresa.dorucovaciMesto}
                        </td>
                    </tr>
                </table>
            </div>
            <div class="col-md-6">
                <table class="pull-right">
                    <caption>Fakturační</caption>
                    <tr>    
                        <td>
                            ${objednavka.zakaznik.adresa.fakturacniUlice} ${objednavka.zakaznik.adresa.fakturacniCP}<br />
                            ${objednavka.zakaznik.adresa.fakturacniPSC} ${objednavka.zakaznik.adresa.fakturacniMesto}
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <hr style="width: 100%; height: 1px; background-color: gray;" />

        <div class="row adresy">
            <h2 style="text-align: center;">Informace o objednávce</h2>
            <div class="col-md-offset-3">
                <div class="col-md-6">
                    <table class="table">
                        <tr>
                            <td>Datum objednávky:</td>
                            <td>${objednavka.datum}</td>
                        </tr>
                        <tr>
                            <td>Stav</td>
                            <td>
                                <select name="stav">
                                    <c:forEach begin="0" end="${objednavka.pocetStavuObjednavky-1}" var="i">
                                        <option value="${i+1}" <c:if test="${objednavka.stav == i+1}"> selected="selected"</c:if>>${objednavka.stavyObjednavky[i]}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Celková cena</td>
                            <td>${objednavka.celkovaCena} K&#269;</td>
                        </tr>                
                    </table>
                </div>
            </div>
        </div>

        <hr style="width: 100%; height: 1px; background-color: gray;" />

        <div class="row-centered">
            <c:if test="${objednavka != null}">
                <input type="hidden" name="id" value="${objednavka.idObjednavka}" />
            </c:if>
            <input type="hidden" name="action" value="edit" />
            <input type="submit" class="btn bg-primary btn-lg" />
        </div>
    </form>
</div>