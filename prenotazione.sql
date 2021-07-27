CREATE TABLE `prenotazione` (
	`utenteID` INT,
	`veicoloID` INT,
	`dataPrenotazione` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL DEFAULT NULL,
	`idPrenotazione` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`idPrenotazione`)
);

