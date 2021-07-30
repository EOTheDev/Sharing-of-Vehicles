-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 30, 2021 alle 18:30
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
-- Struttura della tabella `prenotazioni`
--

CREATE TABLE `prenotazioni` (
  `utente_id` int(11) DEFAULT NULL,
  `veicolo_id` int(11) DEFAULT NULL,
  `data_prenotazione` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prenotazioni`
--

INSERT INTO `prenotazioni` (`utente_id`, `veicolo_id`, `data_prenotazione`, `id`) VALUES
(1, 1, '2021-07-12 22:00:00', 1),
(1, 1, '2021-07-30 08:14:09', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `id` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firma` text DEFAULT NULL,
  `tipo` varchar(1) NOT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `cognome` varchar(40) DEFAULT NULL,
  `nascita` varchar(10) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `data_iscrizione` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`id`, `username`, `password`, `firma`, `tipo`, `nome`, `cognome`, `nascita`, `email`, `data_iscrizione`) VALUES
(1, 'Admin', 'Amministratore', 'Amministratore dei servizi', 'A', 'Paolino', 'Paperino', '20/08/1900', 'paolino.paperino@paperopoli.com ', '2005-12-31 22:00:00'),
(2, 'User', 'UtenteRegistrato1', 'Utente con diritti minimi', 'B', 'Mauro', 'Pierini01', '20/08/1987', 'Mauro.Pierini@paperopoli.com ', '2021-07-28 05:35:17'),
(4, 'edoardo.porta', 'ciao15', 'Cliente dal null', 'A', 'Edoardo', 'Orta', '2021-07-17', 'edoardo.orta.17@gmail.com', '2021-07-30 12:31:32');

-- --------------------------------------------------------

--
-- Struttura della tabella `veicoli`
--

CREATE TABLE `veicoli` (
  `id` int(50) NOT NULL,
  `ruote` tinyint(50) DEFAULT NULL,
  `tipologia` varchar(50) DEFAULT NULL,
  `modello` varchar(50) DEFAULT NULL,
  `descrizione` varchar(225) DEFAULT NULL,
  `alimentazione` varchar(50) DEFAULT NULL,
  `indirizzo` varchar(200) DEFAULT NULL,
  `latitudine` decimal(10,7) NOT NULL,
  `longitudine` decimal(10,7) NOT NULL,
  `immagine` varchar(225) DEFAULT NULL,
  `peso_co2` decimal(3,2) DEFAULT NULL,
  `prezzo` decimal(7,2) DEFAULT NULL,
  `utente_id` int(11) NOT NULL,
  `colore` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `veicoli`
--

INSERT INTO `veicoli` (`id`, `ruote`, `tipologia`, `modello`, `descrizione`, `alimentazione`, `indirizzo`, `latitudine`, `longitudine`, `immagine`, `peso_co2`, `prezzo`, `utente_id`, `colore`) VALUES
(0, 2, 'auto', 'Fiat Panda', 'L\'auto più bella del mondo, raggiante e sfuggente', 'Benzina', 'Corso G. Ferraris', '136.2566000', '69.2225600', '../imgs/lamborghini.png', '0.00', '20.00', 1, '#BBDEF0'),
(1, 4, 'auto', 'BMW I8', 'L\'auto più bella del mondo, raggiante e sfuggente', 'Elettrica', 'Via del Campo, Torino', '8.2060080', '44.8991380', '../imgs/BMWI8.png', '0.40', '150.00', 1, '#F2ABA6'),
(2, 2, 'Bici', 'BMX 360 Power', 'La bici più spettacolare di sempre, che ti permette di fare i migliori trick', 'Human Power', 'Via Zaia, Venezia', '15.6455200', '23.6654800', '../imgs/bmx.png', '1.00', '15.00', 2, '#ADFFFF'),
(5, 0, 'bici', 'stampelle power 2000', 'le stampelle più belle del mondo', 'human power', 'via domodossola', '15.6665000', '125.6548000', '../imgs/stampelle.png', '1.00', '0.50', 1, '#d22a1e'),
(20, 2, 'monopattino', 'Kinky Segway 500', 'The fastest ever built scooter, it will take you and your doggo to the moon', 'elettrica', 'corso roboaente, 56, Vittorio Veneto', '64.5888121', '12.3654568', '../imgs/segway.png', '0.95', '35.59', 4, '#FBD99D');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `prenotazioni`
--
ALTER TABLE `prenotazioni`
  ADD PRIMARY KEY (`id`),
  ADD KEY `utenteID` (`utente_id`,`veicolo_id`),
  ADD KEY `veicoloID` (`veicolo_id`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `IDX_Utente_1` (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

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
-- AUTO_INCREMENT per la tabella `prenotazioni`
--
ALTER TABLE `prenotazioni`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `prenotazioni`
--
ALTER TABLE `prenotazioni`
  ADD CONSTRAINT `prenotazioni_ibfk_1` FOREIGN KEY (`veicolo_id`) REFERENCES `veicoli` (`id`),
  ADD CONSTRAINT `prenotazioni_ibfk_2` FOREIGN KEY (`utente_id`) REFERENCES `utenti` (`id`);

--
-- Limiti per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  ADD CONSTRAINT `veicoli_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utenti` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
