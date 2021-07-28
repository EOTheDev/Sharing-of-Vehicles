-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 28, 2021 alle 16:20
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
-- Struttura della tabella `veicoli`
--

CREATE TABLE `veicoli` (
  `id` int(50) NOT NULL,
  `ruote` tinyint(50) DEFAULT NULL,
  `tipologia` varchar(10) DEFAULT NULL,
  `descrizione` varchar(225) DEFAULT NULL,
  `alimentazione` varchar(10) DEFAULT NULL,
  `posizione_attuale` varchar(200) DEFAULT NULL,
  `immagine` varchar(225) DEFAULT NULL,
  `peso_co2` decimal(50,0) DEFAULT NULL,
  `prezzo` decimal(65,0) DEFAULT NULL,
  `utente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `veicoli`
--

INSERT INTO `veicoli` (`id`, `ruote`, `tipologia`, `descrizione`, `alimentazione`, `posizione_attuale`, `immagine`, `peso_co2`, `prezzo`, `utente_id`) VALUES
(0, 2, 'auto', 'panda', 'elettrica', 'torino', 'panda.jpg', '1', '20', 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `veicoli`
--
ALTER TABLE `veicoli`
  ADD PRIMARY KEY (`id`),
  ADD KEY `utente_id` (`utente_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  ADD CONSTRAINT `veicoli_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utenti` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
