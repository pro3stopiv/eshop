<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    var map;
    function initialize() {
        var mapOptions = {
            zoom: 8,
            center: new google.maps.LatLng(${vyrobce.latitude},${vyrobce.longtitude})
        };
        map = new google.maps.Map(document.getElementById('map'), mapOptions);
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(${vyrobce.latitude},${vyrobce.longtitude}),
            map: map,
            title: '${vyrobce.nazev}'
        });
    }



    google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 ">
            <h1>${vyrobce.nazev}</h1>
            <p>${vyrobce.popis}</p>    
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 ">
            <h2>Kontakt</h2>
            ${vyrobce.kontakt.ulice}<br />
            ${vyrobce.kontakt.cp}<br />
            ${vyrobce.kontakt.psc}<br />
            ${vyrobce.kontakt.mesto}<br />
            ${vyrobce.kontakt.telefon}<br />
            ${vyrobce.kontakt.www}<br />
            ${vyrobce.kontakt.email}
        </div>
        <div class="col-md-8">
            <div id="map"></div>
        </div>
    </div>
</div>