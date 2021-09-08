

// aggiungo solo footer
$(function() {
    $("#footerContainer").load("/html/footer.html");
    
})
// aggiungo il css della navigazione
var link = document.createElement('link');
link.setAttribute('rel', 'stylesheet');
link.setAttribute('href', '/css/nav.css');
document.head.appendChild(link);




/* mantengo il login*/
window.addEventListener('DOMContentLoaded', (event) => {
    console.log("sono in dom loaded");
    if (utente!=null){
            // $(".dropdown-toggle").dropdown();



            /*recupero il posto del bottone dalla nav*/
            var loginContainer= document.getElementById("login");
            /*creo i nuovi elementi*/
            var alogout= document.createElement("a");
            var aPrenotazioni= document.createElement("a");
            var button= document.createElement("button");
            var aCont= document.createElement("div");
            /*setto le classi*/
            loginContainer.setAttribute("class", "dropdown");
            button.setAttribute("class", "col-12 btn btn-alert dropdown-toggle");
            button.setAttribute("id","dropdownMenuButton");
            button.setAttribute("data-toggle","dropdown");
            button.setAttribute("aria-haspopup","true");
            button.setAttribute("aria-expanded","false");

            
            aCont.setAttribute("class", "dropdown-menu")
            aCont.setAttribute("aria-labelledby", "dropdownMenuButton")
            
            aPrenotazioni.setAttribute("class","dropdown-item");
            if (utente.tipo=="B") {
                aPrenotazioni.setAttribute("href", "/utente/"+utente.id);
                aPrenotazioni.innerHTML="Prenotazioni";
            } else { //utente admin
                aPrenotazioni.setAttribute("href", "/dashboard/"+utente.id);
                aPrenotazioni.innerHTML="Dashboard";
            }

            alogout.setAttribute("class","dropdown-item");
            alogout.setAttribute("href", "/");
            alogout.innerHTML="Logout";

            
            /*svuoto il container*/
            loginContainer.innerHTML="";
            /*appendo i figli*/
            aCont.appendChild(alogout);
            aCont.appendChild(aPrenotazioni);
            loginContainer.appendChild(button);
            loginContainer.appendChild(aCont);
            button.innerHTML="Ciao, "+utente.username;
        
            }   
});



