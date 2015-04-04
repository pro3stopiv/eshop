<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${base_url}kategorie.do">
    <table>
        <tr>
            <td>Název</td>
            <td><input name="nazev" <c:if test="${kategorie != null}">value="${kategorie.nazev}"</c:if> /></td>
        </tr>
        <tr>
            <td>Popis</td>
            <td>
                <textarea name="popis"><c:if test="${kategorie != null}">${kategorie.popis}</c:if></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${kategorie != null}">
                    <input type="hidden" name="id" value="${kategorie.idKategorie}" />
                </c:if>
                <input type="hidden" name="action" value="edit" />
                <input type="submit" />
            </td>
        </tr>
    </table>
</form>