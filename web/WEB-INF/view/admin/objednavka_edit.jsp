<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}objednavka.do">
<h2>Obsah objednávky</h2>
<table>
    <thead>
	<tr>
	<th>Název zbo&#158;í(Kód zbo&#158;í)</th>
	<th>Po&#269;et kus&#367;</th>
	<th>Cena za kus</th>
	<th>Cena za v&#154;echny</th>
	</tr>
    </thead>
    <c:forEach items="${objednavka.produkty}" var="produkt">
	<tr>
	    <td>${produkt.produkt.nazev} (${produkt.produkt.idProdukt})</td>
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

<h2>Informace o zákazníkovi</h2>
<table>
    <tr>
	<td>ID</td>
	<td>${objednavka.zakaznik.idZakaznik}</td>
    </tr>
    <tr>
	<td>Jméno</td>
	<td>${objednavka.zakaznik.jmeno}</td>
    </tr>
    <tr>
	<td>P&#345;íjmení</td>
	<td>${objednavka.zakaznik.prijmeni}</td>
    </tr>
    <tr>
	<td>E-mail</td>
	<td>${objednavka.zakaznik.email}</td>
    </tr>
    <tr>
	<td>Telefon</td>
	<td>${objednavka.zakaznik.telefon}</td>
    </tr>
</table>

<h2>Adresa</h2>
<table>
    <tr>
	<td>Doru&#269;ovací</td>
	<td>
	    ${objednavka.zakaznik.adresa.dorucovaciUlice} ${objednavka.zakaznik.adresa.dorucovaciCP}<br />
	    ${objednavka.zakaznik.adresa.dorucovaciPSC} ${objednavka.zakaznik.adresa.dorucovaciMesto}
	</td>
    </tr>
    <tr>
	<td>Faktura&#269;ní</td>
	<td>
	    ${objednavka.zakaznik.adresa.fakturacniUlice} ${objednavka.zakaznik.adresa.fakturacniCP}<br />
	    ${objednavka.zakaznik.adresa.fakturacniPSC} ${objednavka.zakaznik.adresa.fakturacniMesto}
	</td>
    </tr>
</table>
<h2>Informace o objednávce</h2>
<table>
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
<c:if test="${objednavka != null}">
    <input type="hidden" name="id" value="${objednavka.idObjednavka}" />
</c:if>
<input type="hidden" name="action" value="edit" />
<input type="submit" />
</form>