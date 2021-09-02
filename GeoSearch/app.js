/*Author Giancarlo Borreo*/

console.log("hello");
var mymap = L.map('mapid').setView([51.505, -0.09], 1);
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoiZ2lhbmNhcmxvYm9ycmVvIiwiYSI6ImNrdDJwdDd4bjBtaWQyb3VsNXp6OXRyZzMifQ.G-UIgr_4U5toqiqFrURN6w', {
    id: 'mapbox/streets-v11',
    accessToken: 'pk.eyJ1IjoiZ2lhbmNhcmxvYm9ycmVvIiwiYSI6ImNrdDJwdDd4bjBtaWQyb3VsNXp6OXRyZzMifQ.G-UIgr_4U5toqiqFrURN6w'
}).addTo(mymap);

var latlng;

function onMapClick(e) {
    latlng = e.latlng;    
    alert("You clicked the map at " + e.latlng);
    console.log(latlng)
}


// var popup = L.popup();

// function onMapClick(e) {
//     popup
//         .setLatLng(e.LatLng)
//         .setContent("You clicked the map at " + e.latlng.toString())
//         .openOn(mymap);
    
    
// }
mymap.on('click', onMapClick);

var pinIcon = L.icon({
    iconUrl: 'pin.jpg',

    iconSize:     [38, 95], // size of the icon
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});

L.Control.geocoder().addTo(mymap);