// rimuovo il popup di modifica veicoli
$("#closeTabVei").on("click", function() {
    $("#modificaContainerVeicoli").attr("style", "display:none;");
});
// display di modifica veicoli
$(".editVeicolo").on("click", function () {
    console.log($(this).parent().parent().find("#modello").html());

    // autoinserimento dei valori //
    //questo è uno span
    $("#modificaContainerVeicoli").find("#questoVeicolo").text($(this).parent().parent().find("#modello").html());

    //questi sono input
    $("#modificaContainerVeicoli").find("#modelloForm").val($(this).parent().parent().find("#modello").html());
    $("#modificaContainerVeicoli").find("#tipoVeicoloForm").val($(this).parent().parent().find("#tipologia").html());
    $("#modificaContainerVeicoli").find("#alimentazioneForm").val($(this).parent().parent().find("#alimentazione").html());
    $("#modificaContainerVeicoli").find("#descrizioneForm").val($(this).parent().parent().find("#descrizione").html());
    $("#modificaContainerVeicoli").find("#indirizzoForm").val($(this).parent().parent().find("#posizione").html());
    $("#modificaContainerVeicoli").find("#prezzoForm").val($(this).parent().parent().find("#tariffa").html());
    
    $("#modificaContainerVeicoli").find("#coloreForm").val($(this).parent().parent().find("#colore").html());
    // hidden
    $("#modificaContainerVeicoli").find("#idForm").val($(this).parent().parent().find("#idVeicolo").html());
    // percorso immagine per utente
    $("#modificaContainerVeicoli").find("#percorsoImmagineForm").text($(this).parent().parent().find("#urlImmagine").html());

    $("#modificaContainerVeicoli").attr("style", "display:block;");

});

/*CLIENTI*/
// rimuovo il popup di modifica clienti
$("#closeTabCli").on("click", function() {
    $("#modificaContainerClienti").attr("style", "display:none;");
});
// display di modifica clienti
$(".editCliente").on("click", function () {
    console.log($(this).parent().parent().find("#modello").html());

    // autoinserimento dei valori //
    //questo è uno span
    $("#modificaContainerClienti").find("#questoCliente").text($(this).parent().parent().find("#username").html());

    //questi sono input
    $("#modificaContainerClienti").find("#username").val($(this).parent().parent().find("#username").html());
    $("#modificaContainerClienti").find("#nome").val($(this).parent().parent().find("#nome").html());
    $("#modificaContainerClienti").find("#cognome").val($(this).parent().parent().find("#cognome").html());
    $("#modificaContainerClienti").find("#tipo").val($(this).parent().parent().find("#ruolo").html());
    $("#modificaContainerClienti").find("#email").val($(this).parent().parent().find("#email").html());
    //questa è una data, attenti è un dito lì. non toccare
    $("#modificaContainerClienti").find("#dateBirth").val($(this).parent().parent().find("#dataNascita").text());
    $("#modificaContainerClienti").find("#prezzoForm").val($(this).parent().parent().find("#tariffa").html());
    // hidden
    $("#modificaContainerClienti").find("#idForm").val($(this).parent().parent().find("#id").html());
    $("#modificaContainerClienti").attr("style", "display:block;");

});







// var visualizza=document.getElementById("visualizzo");
// var tableContainer=document.getElementById("tableContainer");


// $("#visualizzo").on("change", function () {
//     if ($("#visualizzo").val()=="-") {
//         console.log("sono qui nel change");
//         var x= document.getElementById("pizzaBoy");
//         x.innerHTML='<i class="fas fa-arrow-down"></i>';
//         //nulla
//         $("#tableContainer").empty();
//     } else if($("#visualizzo").val()=="prenotazioni") {
//         $("#pizzaBoy").text("le tue prenotazioni");
//         tableContainer.innerHTML='<table class="table table-striped" id="prenotazioni"><h3>Le tue prenotazioni</h3><tr><th>Referente</th><th>Numero prenotazione</th><th>Veicolo</th><th>Risparmio in CO2</th><th>Data</th><th>Tariffa</th><th>Interagisci</th></tr><tr th:each="prenotazione:${prenotazioni}"><td><span id="nome" th:text="${prenotazione.utenteId.nome}">Mario</span> <span id="cognome" th:text="${prenotazione.utenteId.cognome}">Rossi</span></td><td><span id="idPrenotazione"  th:text="${prenotazione.id}">X1A14B33</span></td><td><span id="veicolo" th:text="${prenotazione.veicoloId.modello}">Bici</span></td><td><span id="pesoCO2" th:text="${prenotazione.veicoloId.pesoCo2}">0.8</span> g/m3</td><td><span id="giorno" th:text="${prenotazione.dataPrenotazione}">3</span></td><td><span id="tariffa" th:text="${prenotazione.veicoloId.prezzo}">10</span> €</td><td><button class="btn edit"><i class="fas fa-edit"></i></button> </i><button class="btn delete"><i class="fas fa-trash"></i></button></i></td></tr></table>';
//     } else if($("#visualizzo").val()=="clienti") {
//         $("#pizzaBoy").text("i tuoi clienti");
//         tableContainer.innerHTML=' <table class="table table-striped" id="clienti">        <h3>I tuoi clienti        </h3>        <tr><th>Username</th><th>Nome</th><th>Cognome</th><th>Email</th><th>Età</th><th>Data di iscrizione</th><th>Soldi spesi</th><th>Emissioni totali</th><th>Emissioni in percentuale</th><th>Interagisci</th></tr><tr><td><span id="username">elDiablo23</span></td><td><span id="nome">Mario</span></td><td><span id="cognome">Rossi</span></td><td><span id="email">mariorossi@email.ru</span></td><td><span id="dataNascita">19</span></td><td><span id="iscrizione">16/12/2020</span></td><td><span id="totSpesaUtente">235,05</span> €</td><td><span id="totEmissioni">210</span> g/m3</td><td><span id="emissioniPercentuale">0.9</span> g/m3</td><td><button class="btn edit"><i class="fas fa-edit"></i></button> </i><button class="btn delete"><i class="fas fa-trash"></i></button></i></td></tr></table>'
//     } else if($("#visualizzo").val()=="veicoli") {
//         $("#pizzaBoy").text("i tuoi veicoli");
//         tableContainer.innerHTML='        <table class="table table-striped" id="veicoli"><h3>I tuoi veicoli</h3><tr><th>id</th><th>Tipo veicolo</th><th>Alimentazione</th><th>Descrizione</th><th>Ultima posizione</th><th>Immagine</th><th>Tariffa</th><th>Incasso Totale</th><th>E/R per viaggio</th><th>E/R totali</th><th>Interagisci</th></tr><tr><td><span id="idVeicolo">15</span></td><td><span id="tipologia">Bici</span></td><td><span id="alimentazione">Human Power</span></td><td><span id="descrizione">Bici rossa raggiante, il mezzo più sostenibile che ci sia</span></td><td><span id="posizione">via del Campo, 19, Torino</span></td><td><img src="img/veicolo.jpg" alt="immagine del veicolo" srcset=""></td><td><span id="tariffa">10</span> €/g</td><td><span id="incassoVeicolo">2500</span> €</td><td><span id="emissioniPercentuale">1</span> g/m3</td><td><span id="totEmissioni">25</span> g/m3</td><td><button class="btn edit"><i class="fas fa-edit"></i></button> </i><button class="btn delete"><i class="fas fa-trash"></i></button></i></td></tr></table>';

//     }
// })








