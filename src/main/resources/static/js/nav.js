
// aggiungo html
$(function() {
    $("#navbarContainer").load("/html/nav.html");
    $("#footerContainer").load("/html/footer.html");
})
// aggiungo il css della navigazione
var link = document.createElement('link');
link.setAttribute('rel', 'stylesheet');
link.setAttribute('href', '/css/nav.css');
document.head.appendChild(link);