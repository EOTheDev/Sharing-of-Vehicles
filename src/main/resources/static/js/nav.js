
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
            
            /*recupero il posto del bottone dalla nav*/
            var loginContainer= document.getElementById("login");
            /*creo i nuovi elementi*/
            var alogout= document.createElement("a");
            var logout= document.createElement("button");
            /*setto le classi*/
            alogout.setAttribute("href", "/");
            logout.setAttribute("class", "col-12 btn btn-alert");
            logout.innerHTML="Ciao, "+utente.username;
            
            
            /*svuoto il container*/
            loginContainer.innerHTML="";
            /*appendo i figli*/
            alogout.appendChild(logout);
            loginContainer.appendChild(alogout);
        
                }   
            
            });


