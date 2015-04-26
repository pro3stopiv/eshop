<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<table class="table table-hover">
    <thead>
    <th>ID objednávky</th>
    <th>Stav objednávky</th>
    <th>Datum</th>
    <th>Zákazník</th>
    <th>Celková cena</th>
</thead>


<c:forEach items="${objednavky}" var="objednavka">
    <c:if test="${(objednavka.stavObjednavky == 'Storno')}">
        <tr class="bg-danger">
    </c:if>
    <c:if test="${(objednavka.stavObjednavky == 'Vyřízená')}">
        <tr class="bg-success">
    </c:if>
    <c:if test="${(objednavka.stavObjednavky == 'Zpracovává se')}">
        <tr class="bg-warning">
    </c:if>
    <c:if test="${(objednavka.stavObjednavky == 'Nová')}">
        <tr class="bg-info">
    </c:if>           
    <c:if test="${(objednavka.stavObjednavky == '')}">
        <tr>
    </c:if>            
            
        <td>
            <a href="${base_url}objednavka.do?action=showEdit&amp;id=${objednavka.idObjednavka}">
                ${objednavka.idObjednavka}  

            </a>
        </td>
        <td>
            ${objednavka.stavObjednavky}
        </td>

        <td><fmt:formatDate value="${objednavka.datum}" pattern="dd.MM. yyyy" /></td>

        <td><a href="${base_url}zakaznik.do?action=showEdit&amp;id=${objednavka.zakaznik.idZakaznik}">${objednavka.zakaznik.jmeno} ${objednavka.zakaznik.prijmeni}</a></td>
        <td><fmt:formatNumber value="${objednavka.celkovaCena}" pattern="#,##0.00 Kč" /></td>
    </tr>
   
</c:forEach>
</table>
