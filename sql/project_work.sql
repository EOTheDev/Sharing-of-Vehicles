-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 09, 2021 alle 01:45
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
(1, 27, '2021-09-07 14:34:33', 1),
(1, 31, '2021-09-07 14:34:41', 2),
(18, 30, '2021-09-07 14:34:45', 4),
(18, 27, '2021-09-07 14:34:49', 14),
(18, 31, '2021-09-07 14:34:51', 15),
(18, 30, '2021-09-07 14:34:54', 16),
(18, 27, '2021-09-07 14:34:56', 17),
(18, 31, '2021-09-07 14:35:00', 18),
(18, 1, '2021-09-09 22:00:00', 19);

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
(1, 'Admin', 'Amministratore', 'Amministratore dei servizi', 'A', 'Paolino', 'Paperino', '1975-08-20', 'paolino.paperino@paperopoli.com ', '2005-12-31 22:00:00'),
(2, 'User', 'UtenteRegistrato1', 'Utente con diritti minimi', 'B', 'Mauro', 'Pierini', '1987-04-12', 'Mauro.Pierini@paperopoli.com', '2021-07-27 22:00:00'),
(4, 'leonardo.porta', 'ciao15', 'Cliente dal null', 'A', 'Edoardo', 'Orta', '2021-07-17', 'edoardo.orta.17@gmail.com', '2021-07-30 12:31:32'),
(18, 'romavictrix', 'roma', 'Cliente dal null', 'B', 'Edoardo', 'Orta', '2021-06-08', 'edo17maggio@gmail.com', '2021-08-10 22:00:00'),
(21, 'app_generation', 'ciao15', 'Cliente dal null', 'B', 'Edoardo', 'Orta', '2021-09-30', 'edo17maggio@yahoo.it', '2021-09-01 22:00:00'),
(26, 'CascinaMarcella', 'pizzapazza', 'Cliente dal null', 'B', 'Cascina', 'Marcella', '2021-09-28', 'cascinamarcellanoreply@gmail.com', '2021-09-02 22:00:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `veicoli`
--

CREATE TABLE `veicoli` (
  `id` int(50) NOT NULL,
  `ruote` tinyint(50) DEFAULT NULL,
  `tipologia` varchar(50) DEFAULT NULL,
  `modello` varchar(50) DEFAULT NULL,
  `descrizione` varchar(2000) DEFAULT NULL,
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
(1, 4, 'Auto', 'BMW I8', 'L\'auto più bella del mondo, raggiante e sfuggente', 'Elettrica', 'Via del Campo, Torino', '12.0000000', '12.0000000', 'veicolo.png', '0.60', '150.00', 1, '#F2ABA6'),
(26, 0, 'Auto', 'Fiat Panda', 'Vettura a 5 porte di piccole dimensioni, perfetta per spostamenti agevoli in citta e per trovare parcheggio. Inoltre nonostante utilizzi benzina e diesel consuma sempre in misura minore rispetto ad altre vetture di dimensioni maggiore.', 'Benzina', 'Corso G. Ferraris', '12.0000000', '12.0000000', 'veicolo.png', '0.00', '200.00', 4, '#BBDEF0'),
(27, 0, 'Bici', 'Stampelle Power 2000', 'Autonomia dettata dalla costituzione fisica dell\'utilizzatore, per la stabilità dei quadrupedi mantenendo comunque una postura eretta; Miglior mezzo da utilizzare camminando, oltre che ottima arma di difesa.', 'Human power', 'Via Domodossola, Novara', '12.0000000', '12.0000000', 'veicolo.png', '1.00', '0.60', 4, '#F2ABA6'),
(28, 0, 'Monopattino', 'Kinky Segway 500', 'Sistema elettrico: MIKMOTOR con centralina 25A con sistema di raffreddamento. Telaio: lega di alluminio 6061 con verniciatura di alta qualità. Forcella: regolabile a 2 funzioni, in alluminio MOZO. Impianto frenante: tektro auriga idraulico.', 'Elettrica', 'Corso Roboante, 56, Vittorio Veneto', '12.0000000', '12.0000000', 'veicolo.png', '0.95', '10.50', 4, '#ADFFFF'),
(30, 0, 'Bici', 'BMX 360 Power', ' Al freno elettrico anteriore si affianca un comodo freno a disco posteriore, per arrestare la corsa in tutta sicurezza.\r\nPerfetta per una continua interazione fra giovani.', 'Human power', 'Via Zaia, Venezia', '12.0000000', '12.0000000', 'veicolo.png', '1.00', '15.99', 4, '#d22a1e'),
(31, 0, 'Auto', 'Nissan Leaf', 'La prima concept car ad implementare un motore elettrico. Non poteva mancare nel nostro repertorio. Solo qualità.', 'Elettrica', 'Ka Ri To, 659 Nagasaki', '12.0000000', '12.0000000', 'veicolo.png', '0.60', '90.00', 4, '#ADFFFF'),
(34, 0, 'Moto', 'RGNT Scrambler', 'ELECTRIC TORQUE. TIMELESS DESIGN.\r\nOra la tua coscienza può essere pulita come la tua corsa. Un\'ode al design delle classic; fatta in Svezia per gli individualisti urbani.', 'Elettrica', 'Kungsbacka, 135 Svezia', '12.0000000', '12.0000000', 'veicolo.png', '0.90', '79.95', 4, '#BBDEF0');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT per la tabella `veicoli`
--
ALTER TABLE `veicoli`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

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
