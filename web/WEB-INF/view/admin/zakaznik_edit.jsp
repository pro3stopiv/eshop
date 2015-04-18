<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}zakaznik.do">
    <table>
	<caption>Údaje o zákazníkovi</caption>
        <tr>
            <td>Jméno</td>
            <td><input name="jmeno" <c:if test="${zakaznik != null}">value="${zakaznik.jmeno}"</c:if> /></td>
        </tr>
        <tr>
            <td>P&#345;íjmení</td>
            <td>
                <input name="prijmeni" <c:if test="${zakaznik != null}">value="${zakaznik.prijmeni}"</c:if> />
            </td>
        </tr>
	<tr>
	    <td>E-mail</td>
	    <td><input name="email" type="email" <c:if test="${zakaznik != null}">value="${zakaznik.email}"</c:if> /></td>
	</tr>
	<tr>
	    <td>Telefon</td>
	    <td><input name="telefon" <c:if test="${zakaznik != null}">value="${zakaznik.telefon}"</c:if> /></td>
	</tr>
    </table>
    <table>
	<caption>Adresy</caption>
	<tr>
	    <td colspan="2"><b>Doru&#269;ovací</b></td>
	</tr>
	<tr>
	    <td>Ulice</td>
	    <td>
		<input name="dorucovaciUlice" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciUlice}"</c:if> />
	    </td>
	</tr>
	<tr>
	    <td>&#268;íslo popisné</td>
	    <td><input name="dorucovaciCP" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciCP}"</c:if> /></td>
	</tr>
	<tr>
	    <td>M&#283;sto</td>
	    <td><input name="dorucovaciMesto" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciMesto}"</c:if> /></td>
	</tr>
	<tr>
	    <td>PS&#268;</td>
	    <td><input name="dorucovaciPSC" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.dorucovaciPSC}"</c:if> /></td>
	</tr>
	
	
	<tr>
	    <td colspan="2"><b>Faktura&#269;ní</b></td>
	</tr>
	<tr>
	    <td>Ulice</td>
	    <td>
		<input name="fakturacniUlice" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniUlice}"</c:if> />
	    </td>
	</tr>
	<tr>
	    <td>&#268;íslo popisné</td>
	    <td><input name="fakturacniCP" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniCP}"</c:if> /></td>
	</tr>
	<tr>
	    <td>M&#283;sto</td>
	    <td><input name="fakturacniMesto" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniMesto}"</c:if> /></td>
	</tr>
	<tr>
	    <td>PS&#268;</td>
	    <td><input name="fakturacniPSC" <c:if test="${zakaznik != null}">value="${zakaznik.adresa.fakturacniPSC}"</c:if> /></td>
	</tr>
	
    </table>
       
                <c:if test="${zakaznik != null}">
                    <input type="hidden" name="id" value="${zakaznik.idZakaznik}" />
                </c:if>
                <input type="hidden" name="action" value="edit" />
                <input type="submit" />
            
</form>