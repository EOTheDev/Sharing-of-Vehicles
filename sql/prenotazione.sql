/*Author Giancarlo Borreo*/

CREATE TABLE `prenotazione` (
	`utente_id` INT,
	`veicolo_id` INT,
	`data_prenotazione` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL DEFAULT NULL,
	`id_prenotazione` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id_prenotazione`)
);

