<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}vyrobce.do" class="form-horizontal">
    <h2>Informace o výrobci</h2>
    <table>
        <tr>
            <td>Název</td>
            <td><input name="nazev" <c:if test="${vyrobce != null}">value="${vyrobce.nazev}"</c:if> /></td>
        </tr>
        <tr>
            <td>Popis</td>
            <td>
                <textarea name="popis"><c:if test="${vyrobce != null}">${vyrobce.popis}</c:if></textarea>
            </td>
        </tr>
        <tr>
            <td>Latitude</td>
            <td><input name="latitude" <c:if test="${vyrobce != null}">value="${vyrobce.latitude}"</c:if> /></td>
        </tr>
        <tr>
            <td>Longtitude</td>
            <td><input name="longtitude" <c:if test="${vyrobce != null}">value="${vyrobce.longtitude}"</c:if> /></td>
        </tr>
        <tr>
            <td>Altitude</td>
            <td><input name="altitude" <c:if test="${vyrobce != null}">value="${vyrobce.altitude}"</c:if> /></td>
        </tr>
        
    </table>
	<h2>Kontakt</h2>
	<table>
	    <tr>
		<td>Ulice</td>
		<td><input name="ulice" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.ulice}"</c:if> /></td>
	    </tr>
	    <tr>
		<td>&#268;íslo popisné</td>
		<td><input name="cp" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.cp}"</c:if> /></td>
	    </tr>
	    <tr>
		<td>M&#283;sto</td>
		<td><input name="mesto" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.mesto}"</c:if> /></td>
	    </tr>
	    <tr>
		<td>PS&#268;</td>
		<td><input name="psc" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.psc}"</c:if> /></td>
	    </tr>
	    <tr>
		<td>Telefon</td>
		<td><input name="telefon" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.telefon}"</c:if> /></td>
	    </tr>
	    <tr>
		<td>WWW</td>
		<td><input name="www" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.www}"</c:if> /></td>
	    </tr>
	    <tr>
		<td>e-mail</td>
		<td><input name="email" <c:if test="${vyrobce != null}">value="${vyrobce.kontakt.email}"</c:if> /></td>
	    </tr>
	
	
	
	<tr>
            <td colspan="2">
                <c:if test="${vyrobce != null}">
                    <input type="hidden" name="id" value="${vyrobce.idVyrobce}" />
                </c:if>
                <input type="hidden" name="action" value="edit" />
                <input type="submit" />
            </td>
        </tr>
	</table>
</form>