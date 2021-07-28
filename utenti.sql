CREATE TABLE `Utenti` (
	`utenteID` INT(50),
	`nome` VARCHAR(50),
	`cognome` VARCHAR(50),
	`annoDiNascita` YEAR,
	`dataIscrizione` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL DEFAULT NULL
);
