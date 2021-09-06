/*aggiorno il link dei veicoli con la data*/   
    $(".linkVeicolo")
    .each( function() {
        $(this).attr("href", $(this).attr("href")+"/data="+dataURL);
    });