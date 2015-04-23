<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <a href="${base_url}produkt.do?action=showEdit" class="btn btn-primary">Nový produkt</a>
<table class="table table-hover">
    <thead>
	<tr>
	    <th>Obrázek</th>
	    <th>Název</th>
	    <th>Cena</th>
	    <th>Doba dodání</th>
	    <th>Obsah alkoholu</th>
	    <th>Výrobce</th>
	    <th>Kategorie</th>
	    <th>Smazání</th>
	</tr>
    </thead>
    <c:forEach items="${produkty}" var="produkt">
        <tr>
            <td><div class="img-responsive"><img src="${produkt.nazevObrazku}" class="img-responsive" alt="${produkt.nazev}" style="height: 80px;" /></div></td>
            <td><a href="${base_url}produkt.do?action=showEdit&amp;id=${produkt.idProdukt}">${produkt.nazev}</a></td>
	    <td>${produkt.cena} K&#269;</td>
	    <td>${produkt.dobaDodani} dní</td>
	    <td>${produkt.obsahAlkoholu} %</td>
	    <td><a href="${base_url}vyrobce.do?action=showEdit&amp;id=${produkt.vyrobce.idVyrobce}">${produkt.vyrobce.nazev}</a></td>
	    <td>
		<c:forEach items="${produkt.kategorie}" var="kat">
		    <a href="${base_url}kategorie.do?action=showEdit&amp;id=${kat.kategorie.idKategorie}">${kat.kategorie.nazev}</a><br />
		</c:forEach>
	    </td>
	    <td><a href="${base_url}produkt.do?action=delete&amp;id=${produkt.idProdukt}" class="btn btn-danger">smazat</a></td>
    </tr>
    </c:forEach>
</table>
