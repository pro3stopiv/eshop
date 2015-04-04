<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}zpusob_doruceni.do">
    <table>
        <tr>
            <td>Název zp&#367;sobu doru&#269;ení</td>
            <td><input name="nazev" <c:if test="${zpusob_doruceni != null}">value="${zpusob_doruceni.nazevZpusobu}"</c:if> /></td>
        </tr>
        <tr>
            <td>Cena doru&#269;ení</td>
            <td>
                <textarea name="cena"><c:if test="${zpusob_doruceni != null}">${zpusob_doruceni.cenaDoruceni}</c:if></textarea> K&#269;
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${zpusob_doruceni != null}">
                    <input type="hidden" name="id" value="${zpusob_doruceni.idZpusobDoruceni}" />
                </c:if>
                <input type="hidden" name="action" value="edit" />
                <input type="submit" />
            </td>
        </tr>
    </table>
</form>