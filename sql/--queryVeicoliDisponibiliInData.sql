-- li trova solo se c'è una prenotazione con quella data
-- query per avere lista di veicoli per data

-- prendo solo i veicoli
SELECT * FROM veicoli v 
LEFT JOIN prenotazioni p 
-- che non corrispondono a quelli che hanno lo stesso id 
ON !(p.veicolo_id=v.id)
-- nella data di prenotazione variabile 
WHERE data_prenotazione="2021-09-06"
GROUP BY v.id>=1;

-- prendo solo i veicoli
SELECT *
FROM veicoli v , prenotazioni p 
-- che non corrispondono a quelli che hanno lo stesso id 
-- nella data di prenotazione variabile 
WHERE (p.veicolo_id!=v.id) AND data_prenotazione="2021-09-06"
GROUP BY v.id;



--grazie Allen

SELECT * FROM veicoli v WHERE v.id NOT IN ? (select distinct p.veicolo_id from prenotazioni p where data_prenotazione ="2021-09-06");