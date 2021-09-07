  /*aggiorno il calendario*/
  function aggiornoCalendarioHTML(dataPrenotazione){
    var data= new Date(dataPrenotazione);
    $("#dataPrenotazione").val(data.toISOString().substring(0, 10));



    dataPrenotazione=dataPrenotazione.split("-");
    //console.log(dataPrenotazione);
    $("#giorno").text(dataPrenotazione[2]);
    switch (dataPrenotazione[1]){
        case "01":
        $("#mese").text("Gennaio");
        break;
        case "02":
        $("#mese").text("Febbraio");
        break;
        case "03":
        $("#mese").text("Marzo");
        break;
        case "04":
        $("#mese").text("Aprile");
        break;
        case "05":
        $("#mese").text("Maggio");
        break;
        case "06":
        $("#mese").text("Giugno");
        break;
        case "07":
        $("#mese").text("Luglio");
        break;
        case "08":
        $("#mese").text("Agosto");
        break;
        case "09":
        $("#mese").text("Settembre");
        break;
        case "10":
        $("#mese").text("Ottobre");
        break;
        case "11":
        $("#mese").text("Novembre");
        break;
        case "12":
        $("#mese").text("Dicembre");
        break;
        default:
        $("#mese").text("Errore");
        break;
    }
    
    $("#anno").text(dataPrenotazione[0]);
}
/*fine funzione calendario*/