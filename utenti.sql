CREATE TABLE `Utenti` (
	`utenteID` INT(50),
	`nome` VARCHAR(50),
	`cognome` VARCHAR(50),
	`annoDiNascita` YEAR,
	`dataIscrizione` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL DEFAULT NULL
);
DROP TABLE `Utenti`;
CREATE TABLE `Utenti` (
	`userID` INT(50),
	`nome` VARCHAR(50),
	`cognome` VARCHAR(50),
	`email` VARCHAR(50),
	`firma` VARCHAR(50),
	`password` VARCHAR(50),
	`dataIscrizione` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL DEFAULT NULL
);
