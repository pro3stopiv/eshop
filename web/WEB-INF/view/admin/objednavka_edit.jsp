<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}objednavka.do">
<h2>Obsah objedn�vky</h2>
<table>
    <thead>
	<tr>
	<th>N�zev zbo&#158;�(K�d zbo&#158;�)</th>
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

<h2>Informace o z�kazn�kovi</h2>
<table>
    <tr>
	<td>ID</td>
	<td>${objednavka.zakaznik.idZakaznik}</td>
    </tr>
    <tr>
	<td>Jm�no</td>
	<td>${objednavka.zakaznik.jmeno}</td>
    </tr>
    <tr>
	<td>P&#345;�jmen�</td>
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
	<td>Doru&#269;ovac�</td>
	<td>
	    ${objednavka.zakaznik.adresa.dorucovaciUlice} ${objednavka.zakaznik.adresa.dorucovaciCP}<br />
	    ${objednavka.zakaznik.adresa.dorucovaciPSC} ${objednavka.zakaznik.adresa.dorucovaciMesto}
	</td>
    </tr>
    <tr>
	<td>Faktura&#269;n�</td>
	<td>
	    ${objednavka.zakaznik.adresa.fakturacniUlice} ${objednavka.zakaznik.adresa.fakturacniCP}<br />
	    ${objednavka.zakaznik.adresa.fakturacniPSC} ${objednavka.zakaznik.adresa.fakturacniMesto}
	</td>
    </tr>
</table>
<h2>Informace o objedn�vce</h2>
<table>
    <tr>
	<td>Datum objedn�vky:</td>
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
	<td>Celkov� cena</td>
	<td>${objednavka.celkovaCena} K&#269;</td>
    </tr>
</table>
<c:if test="${objednavka != null}">
    <input type="hidden" name="id" value="${objednavka.idObjednavka}" />
</c:if>
<input type="hidden" name="action" value="edit" />
<input type="submit" />
</form>