<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${produkt.nazev}</h1>
${produkt.cena}<br />
${produkt.popis}<br />
${produkt.dobaDodani}<br />
${produkt.obsahAlkoholu}<br />
${produkt.nazevObrazku}<br />
<a href="./vyrobce.do?id=${produkt.vyrobce.idVyrobce}">${produkt.vyrobce.nazev}</a>