-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 29, 2021 alle 12:02
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
  `modello` varchar(50) NOT NULL,
  `descrizione` varchar(225) DEFAULT NULL,
  `alimentazione` varchar(10) DEFAULT NULL,
  `indirizzo` varchar(200) DEFAULT NULL,
  `latitudine` decimal(10,7) NOT NULL,
  `longitudine` decimal(10,7) NOT NULL,
  `immagine` varchar(225) DEFAULT NULL,
  `peso_co2` decimal(50,0) DEFAULT NULL,
  `prezzo` decimal(65,0) DEFAULT NULL,
  `utente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `veicoli`
--

INSERT INTO `veicoli` (`id`, `ruote`, `tipologia`, `modello`, `descrizione`, `alimentazione`, `indirizzo`, `latitudine`, `longitudine`, `immagine`, `peso_co2`, `prezzo`, `utente_id`) VALUES
(0, 4, 'auto', 'panda', '1200cc', 'elettrica', 'Via Roma, 15, 10123 Torino', '45.0701782', '7.6845458', 'panda.jpg', '2', '20', 1),
(1, 4, 'auto', 'Lamborghini', 'L\'auto più bella del mondo, raggiante e sfuggente', 'elettrica', 'Via Giuseppe Gardini, 8, 14100 Asti ', '44.8991380', '8.2060080', 'https://www.gelestatic.it/thimg/-bNdLgCtNRuKA4j9ecawOqOPUa8=/fit-in/960x540/filters:format(webp)/https%3A//www.lastampa.it/image/contentid/policy%3A1.39001420%3A1592925134/P90285406_highRes_the-new-bmw-i8-coupe.jpg%3Ff%3Ddeta', '1', '150', 1);

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
