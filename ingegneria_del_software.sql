-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 16, 2022 alle 09:45
-- Versione del server: 10.4.22-MariaDB
-- Versione PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ingegneria_del_software`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `aereo`
--

CREATE TABLE `aereo` (
  `codice_aereo` bigint(20) NOT NULL,
  `num_bagagli_cabina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `aereo`
--

INSERT INTO `aereo` (`codice_aereo`, `num_bagagli_cabina`) VALUES
(0, 1),
(666, 55),
(1234, 20);

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `codice_fiscale` varchar(255) NOT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `psw` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`codice_fiscale`, `cognome`, `nome`, `psw`, `email`) VALUES
('ab123ba', 'belotti', 'ale', '123', 'ale@gmail'),
('ct123tc', 'tironi', 'cristian', 'abc', 'tiru@gmail');

-- --------------------------------------------------------

--
-- Struttura della tabella `compagni_viaggio`
--

CREATE TABLE `compagni_viaggio` (
  `codice_fiscale_cliente` varchar(255) NOT NULL,
  `codice_fiscale_amico` varchar(255) DEFAULT NULL,
  `codice_volo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(22);

-- --------------------------------------------------------

--
-- Struttura della tabella `operatore`
--

CREATE TABLE `operatore` (
  `email` varchar(255) NOT NULL,
  `psw` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cf` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `operatore`
--

INSERT INTO `operatore` (`email`, `psw`, `cognome`, `nome`, `cf`) VALUES
('op', 'op', 'Ciao', 'Mario', '');

-- --------------------------------------------------------

--
-- Struttura della tabella `posto`
--

CREATE TABLE `posto` (
  `codice_aereo` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `prenotato` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `prenotazione`
--

CREATE TABLE `prenotazione` (
  `codice_fiscale` varchar(255) NOT NULL,
  `codice_volo` bigint(20) NOT NULL,
  `biglietto_prioritario` bit(1) NOT NULL,
  `num_posto` int(11) NOT NULL,
  `pasto` bit(1) NOT NULL,
  `peso_bagaglio` double NOT NULL,
  `valigia_cabina` bit(1) NOT NULL,
  `prezzo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prenotazione`
--

INSERT INTO `prenotazione` (`codice_fiscale`, `codice_volo`, `biglietto_prioritario`, `num_posto`, `pasto`, `peso_bagaglio`, `valigia_cabina`, `prezzo`) VALUES
('ab123ba', 17, b'0', 0, b'0', 0, b'0', 150),
('ab123ba', 19, b'1', 2, b'0', 0, b'0', 195),
('ab123ba', 21, b'0', 1, b'0', 0, b'0', 20),
('ct123tc', 17, b'0', 2, b'0', 0, b'0', 150),
('ct123tc', 19, b'1', 2, b'1', 0, b'0', 205);

-- --------------------------------------------------------

--
-- Struttura della tabella `volo`
--

CREATE TABLE `volo` (
  `codice_volo` bigint(20) NOT NULL,
  `aeroporto_arrivo` varchar(255) DEFAULT NULL,
  `aeroporto_partenza` varchar(255) DEFAULT NULL,
  `codice_aereo` bigint(20) DEFAULT NULL,
  `orario` datetime DEFAULT NULL,
  `prezzo` double NOT NULL,
  `posti_disp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `volo`
--

INSERT INTO `volo` (`codice_volo`, `aeroporto_arrivo`, `aeroporto_partenza`, `codice_aereo`, `orario`, `prezzo`, `posti_disp`) VALUES
(17, 'berlino', 'bergamo', 1234, '2022-01-31 01:30:00', 150, 0),
(18, 'berlino', 'palermo', 0, '2022-02-05 03:45:00', 5, 0),
(19, 'berlino', 'sretsert', 1234, '2022-01-31 01:44:00', 150, 0),
(20, 'parigi', 'bergamo', 666, '2022-01-31 02:52:00', 5, 0),
(21, 'dubai', 'palermo', 666, '2022-03-22 15:28:00', 20, 0);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `aereo`
--
ALTER TABLE `aereo`
  ADD PRIMARY KEY (`codice_aereo`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codice_fiscale`);

--
-- Indici per le tabelle `compagni_viaggio`
--
ALTER TABLE `compagni_viaggio`
  ADD PRIMARY KEY (`codice_fiscale_cliente`);

--
-- Indici per le tabelle `operatore`
--
ALTER TABLE `operatore`
  ADD PRIMARY KEY (`email`);

--
-- Indici per le tabelle `posto`
--
ALTER TABLE `posto`
  ADD PRIMARY KEY (`codice_aereo`);

--
-- Indici per le tabelle `prenotazione`
--
ALTER TABLE `prenotazione`
  ADD PRIMARY KEY (`codice_fiscale`,`codice_volo`);

--
-- Indici per le tabelle `volo`
--
ALTER TABLE `volo`
  ADD PRIMARY KEY (`codice_volo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
