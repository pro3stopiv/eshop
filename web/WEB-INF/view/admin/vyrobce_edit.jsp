<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post">
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
        <tr>
            <td colspan="2">
                <c:if test="${vyrobce != null}">
                    <input type="hidden" name="id" value="${vyrobce.idVyrobce}" />
                </c:if>
                <input type="submit" />
            </td>
        </tr>
    </table>
</form>