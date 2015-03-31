<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${vyrobce.nazev}</h1>
<p>${vyrobce.popis}</p>
GPS: ${vyrobce.latitude} ${vyrobce.longtitude} ${vyrobce.altitude}<br />
<h2>Kontakt</h2>
${vyrobce.kontakt.ulice}<br />
${vyrobce.kontakt.cp}<br />
${vyrobce.kontakt.psc}<br />
${vyrobce.kontakt.mesto}<br />
${vyrobce.kontakt.telefon}<br />
${vyrobce.kontakt.www}<br />
${vyrobce.kontakt.email}