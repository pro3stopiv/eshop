<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>${produkt.nazev}</h1>
<p>Cena: ${produkt.cena}Kč</p>
<p>Popis: ${produkt.popis}</p>
<p>Doba dodání: ${produkt.dobaDodani} dní</p>
<p>Obsah alkoholu: ${produkt.obsahAlkoholu}%</p>
${produkt.nazevObrazku}<br />

<h2>Objednat</h2>
<form method="post">
    <input type="hidden" name="id_produkt" value="${produkt.idProdukt}" />
    <input type="number" name="pocet" value="1" />
    <input type="hidden" name="action" value="addToCart" />
    <input type="submit" value="Přidat do košíku" />
</form>

<p>Výrobce: <a href="./vyrobce.do?id=${produkt.vyrobce.idVyrobce}">${produkt.vyrobce.nazev}</a></p>