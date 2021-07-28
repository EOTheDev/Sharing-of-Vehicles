-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 28, 2021 alle 11:57
-- Versione del server: 10.4.19-MariaDB
-- Versione PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_work`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `userID` varchar(16) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firma` text DEFAULT NULL,
  `tipo` varchar(1) NOT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `cognome` varchar(40) DEFAULT NULL,
  `nascita` varchar(10) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `data_iscrizione` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`userID`, `password`, `firma`, `tipo`, `nome`, `cognome`, `nascita`, `email`, `data_iscrizione`) VALUES
('Amministratore', 'Amministratore', 'Amministratore dei servizi', 'A', 'Paolino', 'Paperino', '20/08/1900', 'paolino.paperino@paperopoli.com ', '2005-12-31 22:00:00'),
('UtenteRegistrato', 'UtenteRegistrato1', 'Utente con diritti minimi', 'B', 'Mauro', 'Pierini01', '20/08/1987', 'Mauro.Pierini@paperopoli.com ', '2021-07-28 05:35:17');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `IDX_Utente_1` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
