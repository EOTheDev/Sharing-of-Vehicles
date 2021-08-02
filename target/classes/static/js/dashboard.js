var visualizza=document.getElementById("visualizzo");
var tableContainer=document.getElementById("tableContainer");


$("#visualizzo").on("change", function () {
    if ($("#visualizzo").val()=="-") {
        console.log("sono qui nel change");
        var x= document.getElementById("pizzaBoy");
        x.innerHTML='<i class="fas fa-arrow-down"></i>';
        //nulla
        $("#tableContainer").empty();
    } else if($("#visualizzo").val()=="prenotazioni") {
        $("#pizzaBoy").text("le tue prenotazioni");
        tableContainer.innerHTML=' <table class="table table-striped" id="prenotazioni"><h3>Le tue prenotazioni</h3>        <tr>            <th>Referente</th><th>Numero prenotazione</th><th>Veicolo</th><th>Risparmio in CO2</th><th>Data</th><th>Tariffa</th><th>Interagisci</th></tr><tr><td><span id="nome">Mario</span> <span id="cognome">Rossi</span></td><td><span id="idPrenotazione">X1A14B33</span></td><td><span id="veicolo">Bici</span></td><td><span id="pesoCO2">0.8</span> g/m3</td><td><span id="giorno">3</span></td><td><span id="tariffa">10</span> €</td><td><button class="btn edit"><i class="fas fa-edit"></i></button> </i><button class="btn delete"><i class="fas fa-trash"></i></button></i></td></tr>';
    } else if($("#visualizzo").val()=="clienti") {
        $("#pizzaBoy").text("i tuoi clienti");
        tableContainer.innerHTML=' <table class="table table-striped" id="clienti">        <h3>I tuoi clienti        </h3>        <tr><th>Username</th><th>Nome</th><th>Cognome</th><th>Email</th><th>Età</th><th>Data di iscrizione</th><th>Soldi spesi</th><th>Emissioni totali</th><th>Emissioni in percentuale</th><th>Interagisci</th></tr><tr><td><span id="username">elDiablo23</span></td><td><span id="nome">Mario</span></td><td><span id="cognome">Rossi</span></td><td><span id="email">mariorossi@email.ru</span></td><td><span id="dataNascita">19</span></td><td><span id="iscrizione">16/12/2020</span></td><td><span id="totSpesaUtente">235,05</span> €</td><td><span id="totEmissioni">210</span> g/m3</td><td><span id="emissioniPercentuale">0.9</span> g/m3</td><td><button class="btn edit"><i class="fas fa-edit"></i></button> </i><button class="btn delete"><i class="fas fa-trash"></i></button></i></td></tr></table>'
    } else if($("#visualizzo").val()=="veicoli") {
        $("#pizzaBoy").text("i tuoi veicoli");
        tableContainer.innerHTML='        <table class="table table-striped" id="veicoli"><h3>I tuoi veicoli</h3><tr><th>id</th><th>Tipo veicolo</th><th>Alimentazione</th><th>Descrizione</th><th>Ultima posizione</th><th>Immagine</th><th>Tariffa</th><th>Incasso Totale</th><th>E/R per viaggio</th><th>E/R totali</th><th>Interagisci</th></tr><tr><td><span id="idVeicolo">15</span></td><td><span id="tipologia">Bici</span></td><td><span id="alimentazione">Human Power</span></td><td><span id="descrizione">Bici rossa raggiante, il mezzo più sostenibile che ci sia</span></td><td><span id="posizione">via del Campo, 19, Torino</span></td><td><img src="img/veicolo.jpg" alt="immagine del veicolo" srcset=""></td><td><span id="tariffa">10</span> €/g</td><td><span id="incassoVeicolo">2500</span> €</td><td><span id="emissioniPercentuale">1</span> g/m3</td><td><span id="totEmissioni">25</span> g/m3</td><td><button class="btn edit"><i class="fas fa-edit"></i></button> </i><button class="btn delete"><i class="fas fa-trash"></i></button></i></td></tr></table>';

    }
})








