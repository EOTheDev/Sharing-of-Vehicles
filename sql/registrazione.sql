CREATE TABLE `utenti` (
  `UltimaModifica` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `UserID` varchar(16) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Firma` text DEFAULT NULL,
  `Tipo` varchar(1) NOT NULL,
  `Nome` varchar(40) DEFAULT NULL,
  `Cognome` varchar(40) DEFAULT NULL,
  `Nascita` varchar(10) DEFAULT NULL,
  `Email` varchar(40) NOT NULL,
  `DataIscrizione` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `IDX_Utente_1` (`UserID`)
)