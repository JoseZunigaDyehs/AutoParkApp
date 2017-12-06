-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 06, 2017 at 02:40 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `autopark`
--

-- --------------------------------------------------------

--
-- Table structure for table `boucher`
--

DROP TABLE IF EXISTS `boucher`;
CREATE TABLE IF NOT EXISTS `boucher` (
  `id_boucher` int(11) NOT NULL AUTO_INCREMENT,
  `total_boucher` varchar(25) NOT NULL,
  `id_pago` int(11) NOT NULL,
  `id_envio` int(11) NOT NULL,
  `id_ticket` int(11) NOT NULL,
  PRIMARY KEY (`id_boucher`),
  KEY `id_pago` (`id_pago`),
  KEY `id_envio` (`id_envio`),
  KEY `id_ticket` (`id_ticket`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `rut_cliente` varchar(10) NOT NULL,
  `nombre_cliente` varchar(20) NOT NULL,
  `telefono_cliente` varchar(12) NOT NULL,
  `email_cliente` varchar(50) NOT NULL,
  `id_boucher` varchar(50) NOT NULL,
  PRIMARY KEY (`rut_cliente`),
  KEY `id_boucher` (`id_boucher`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `envio`
--

DROP TABLE IF EXISTS `envio`;
CREATE TABLE IF NOT EXISTS `envio` (
  `id_envio` int(11) NOT NULL,
  `nombre_envio` varchar(25) NOT NULL,
  PRIMARY KEY (`id_envio`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `envio`
--

INSERT INTO `envio` (`id_envio`, `nombre_envio`) VALUES
(1, 'Correo electrónico'),
(2, 'Dirección particular');

-- --------------------------------------------------------

--
-- Table structure for table `estacionamiento`
--

DROP TABLE IF EXISTS `estacionamiento`;
CREATE TABLE IF NOT EXISTS `estacionamiento` (
  `id_estacionamiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_estacionamiento` varchar(100) NOT NULL,
  `longitud_estacionamiento` varchar(50) NOT NULL,
  `latitud_estacionamiento` varchar(50) NOT NULL,
  PRIMARY KEY (`id_estacionamiento`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estacionamiento`
--

INSERT INTO `estacionamiento` (`id_estacionamiento`, `nombre_estacionamiento`, `longitud_estacionamiento`, `latitud_estacionamiento`) VALUES
(1, 'Parking Saba Santa Lucía Santiago de Chile', '-33.4380834', '-70.7136202,12z'),
(2, 'Estacionamiento Agustinas', '-33.4401835', '-70.7150566,12z');

-- --------------------------------------------------------

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `id_pago` int(11) NOT NULL,
  `nombre_pago` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pago`
--

INSERT INTO `pago` (`id_pago`, `nombre_pago`) VALUES
(1, 'Transferencia'),
(2, 'Pago en linea'),
(3, 'Orden de compra');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id_ticket` int(11) NOT NULL AUTO_INCREMENT,
  `precio_ticket` int(11) NOT NULL,
  `id_estacionamiento` int(11) NOT NULL,
  `estado_ticket` int(11) NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `id_estacionamiento` (`id_estacionamiento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
