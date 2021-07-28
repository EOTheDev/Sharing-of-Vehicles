CREATE TABLE `Veicolo` (
	`id` INT(50) NOT NULL AUTO_INCREMENT,
	`ruote` TINYINT(50),
	`tipologia` VARCHAR(10),
	`descrizione` VARCHAR(225),
	`alimentazione` VARCHAR(10),
	`posizione_attuale` VARCHAR(200),
	`immagine` VARCHAR(225),
	`peso_co2` DECIMAL(50),
	`prezzo` DECIMAL(65),
	`user_id` INT(50),
	PRIMARY KEY (`id`)
);