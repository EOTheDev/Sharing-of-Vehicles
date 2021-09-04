-- query per avere lista di veicoli per data

-- prendo solo i veicoli
SELECT * FROM veicoli v 
LEFT JOIN prenotazioni p 
-- che non corrispondono
-- a quelli che hanno lo stesso id 
ON !(veicolo_id=v.id)
-- nella data di prenotazione variabile 
WHERE data_prenotazione="2021-07-13";
-- li trova solo se c'è una prenotazione con quella data
