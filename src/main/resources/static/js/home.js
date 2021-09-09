/*aggiorno il link dei veicoli con la data*/   
$(".linkVeicolo")
.each( function() {
    $(this).attr("href", $(this).attr("href")+"/data="+dataURL);
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

/*Prenotazione*/
// rimuovo il popup di modifica clienti
$("#closeTabPre").on("click", function() {
    $("#modificaContainerPrenotazioni").attr("style", "display:none;");
});
// display di modifica clienti
$(".editPrenotazione").on("click", function () {
    console.log(

    );

    // autoinserimento dei valori //
    //questo è uno span
    $("#modificaContainerPrenotazioni").find("#questaPrenotazione").text($(this).parent().parent().find("#idPrenotazione").html());

    //questi sono input
  
    //questa è una data, attenti è un dito lì. non toccare
    $("#modificaContainerPrenotazioni").find("#dataPrenotazione").val($(this).parent().find("#day").html());
    
    // hidden
    $("#modificaContainerPrenotazioni").find("#idForm").val($(this).parent().parent().find("#idPrenotazione").html());
    $("#modificaContainerPrenotazioni").attr("style", "display:block;");

});