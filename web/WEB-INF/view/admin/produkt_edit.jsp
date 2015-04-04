<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}produkt.do">
    <table>
        <tr>
            <td>N�zev</td>
            <td><input name="nazev" <c:if test="${produkt != null}">value="${produkt.nazev}"</c:if> /></td>
        </tr>
	<tr>
            <td>Cena</td>
            <td><input name="cena" <c:if test="${produkt != null}">value="${produkt.cena}"</c:if> /></td>
        </tr>
        <tr>
            <td>Popis</td>
            <td>
                <textarea name="popis"><c:if test="${produkt != null}">${produkt.popis}</c:if></textarea>
            </td>
        </tr>
	<tr>
            <td>Doba dod�n�</td>
            <td><input name="doba_dodani" <c:if test="${produkt != null}">value="${produkt.dobaDodani}"</c:if> /></td>
        </tr>
	<tr>
            <td>Obsah alkoholu</td>
            <td><input name="obsah_alkoholu" <c:if test="${produkt != null}">value="${produkt.obsahAlkoholu}"</c:if> /></td>
        </tr>
	<tr>
            <td>Obr�zek</td>
            <td>
		<c:if test="${produkt != null}">
		    <img src="${produkt.nazevObrazku}" alt="obrazek" />
		</c:if>
		<input type="file" name="obrazek" />
	    </td>
        </tr>
	<tr>
            <td>V�robce</td>
            <td>
		<select name="vyrobce">
		<c:forEach items="${vyrobci}" var="vyrobce">
		    <option value="${vyrobce.idVyrobce}"<c:if test="${vyrobce.idVyrobce == produkt.vyrobce.idVyrobce}"> selected="selected"</c:if>>${vyrobce.nazev}</option>
		</c:forEach>
		</select>
	    </td>
        </tr>
	<tr>
            <td>Kategorie</td>
            <td>
		<c:forEach items="${kategorie}" var="kategor">
		    <input type="checkbox" name="kategorie[${kategor.idKategorie}]" <c:if test="${produkt.hasKategorie(kategor)}">checked="checked"</c:if> />${kategor.nazev}
		</c:forEach>
	    </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${produkt != null}">
                    <input type="hidden" name="id" value="${produkt.idProdukt}" />
                </c:if>
                <input type="hidden" name="action" value="edit" />
                <input type="submit" />
            </td>
        </tr>
    </table>
</form>