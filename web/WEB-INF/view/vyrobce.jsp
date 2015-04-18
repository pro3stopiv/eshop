<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${vyrobce.nazev}</h1>
<p>${vyrobce.popis}</p>
<script>
    var map;
    function initialize() {
    var mapOptions = {
	zoom: 8,
	center: new google.maps.LatLng(${vyrobce.latitude},${vyrobce.longtitude})
    };
    map = new google.maps.Map(document.getElementById('map'),mapOptions);
    var marker = new google.maps.Marker({
      position: new google.maps.LatLng(${vyrobce.latitude},${vyrobce.longtitude}),
      map: map,
      title: '${vyrobce.nazev}'
  });
}



google.maps.event.addDomListener(window, 'load', initialize);
    </script>
<h2>Kontakt</h2>
${vyrobce.kontakt.ulice}<br />
${vyrobce.kontakt.cp}<br />
${vyrobce.kontakt.psc}<br />
${vyrobce.kontakt.mesto}<br />
${vyrobce.kontakt.telefon}<br />
${vyrobce.kontakt.www}<br />
${vyrobce.kontakt.email}

<div id="map"></div>