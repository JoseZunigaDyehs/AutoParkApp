-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 11, 2017 at 06:03 PM
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
  `total_boucher` int(50) NOT NULL,
  `id_pago` int(11) NOT NULL,
  `id_envio` int(11) NOT NULL,
  `rut_cliente` int(10) NOT NULL,
  PRIMARY KEY (`id_boucher`),
  KEY `boucher_pago` (`id_pago`),
  KEY `boucher_envio` (`id_envio`),
  KEY `boucher_cliente` (`rut_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boucher`
--

INSERT INTO `boucher` (`id_boucher`, `total_boucher`, `id_pago`, `id_envio`, `rut_cliente`) VALUES
(1, 70000, 1, 1, 197331674),
(2, 321, 2, 1, 197331674),
(3, 50000, 2, 1, 197331674),
(4, 909090, 1, 1, 1234),
(5, 128123, 1, 1, 1234563),
(6, 11000, 2, 1, 123123),
(7, 16000, 3, 1, 176779853),
(8, 6850, 3, 2, 176779853),
(9, 655308, 2, 1, 176779853);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `rut_cliente` int(10) NOT NULL,
  `nombre_cliente` varchar(20) NOT NULL,
  `telefono_cliente` varchar(12) NOT NULL,
  `email_cliente` varchar(50) NOT NULL,
  PRIMARY KEY (`rut_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`rut_cliente`, `nombre_cliente`, `telefono_cliente`, `email_cliente`) VALUES
(1234, 'Arroz', '456456', '123@123.vl'),
(123123, 'lacteos', '555', 'wer@asf.cl'),
(1234563, 'alii', '123456', 'asja@asad.cl'),
(176779853, 'Jose Zuniga', '+5696669995', '456@asd.cl'),
(197331674, 'luciano', '56993986446', 'luciano_16_17@hotmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `envio`
--

DROP TABLE IF EXISTS `envio`;
CREATE TABLE IF NOT EXISTS `envio` (
  `id_envio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_envio` varchar(20) NOT NULL,
  PRIMARY KEY (`id_envio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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
  `link_estacionamiento` varchar(500) NOT NULL,
  PRIMARY KEY (`id_estacionamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estacionamiento`
--

INSERT INTO `estacionamiento` (`id_estacionamiento`, `nombre_estacionamiento`, `link_estacionamiento`) VALUES
(1, 'Parking Saba Santa Lucía', 'https://www.google.cl/maps/place/Parking+Saba+Santa+Luc%C3%ADa+Santiago+de+Chile/@-33.4381031,-70.6457688,17z/data=!4m5!3m4!1s0x9662c598c66fcf53:0xa7d9a7f6f1f0f626!8m2!3d-33.4381031!4d-70.6435801'),
(2, 'Estacionamiento Agustinas', 'https://www.google.cl/maps/place/Estacionamiento+Agustinas/@-33.4380941,-70.6457688,17z/data=!4m8!1m2!2m1!1sEstacionamiento+Agustinas!3m4!1s0x9662c59f50bda78f:0x382dc06d9b7aec67!8m2!3d-33.4402032!4d-70.6450165'),
(3, 'Estacionamientos Serrano', 'https://www.google.cl/maps/place/Estacionamientos+Serrano/@-33.4452265,-70.650776,17z/data=!4m12!1m6!3m5!1s0x9662c5a09b37b075:0x9ef6ebd14ee48a54!2sEstacionamientos+Serrano!8m2!3d-33.4452265!4d-70.6492284!3m4!1s0x9662c5a09b37b075:0x9ef6ebd14ee48a54!8m2!3d-33.4452265!4d-70.6492284'),
(4, 'Estacionamiento Saba', 'https://www.google.cl/maps/place/Estacionamiento+Saba/@-33.4391071,-70.6432368,17.25z/data=!4m8!1m2!2m1!1sEstacionamientos!3m4!1s0x0:0x9a6c89b272441fd0!8m2!3d-33.4384708!4d-70.643777'),
(5, 'Estacionamiento E-Lira 21', 'https://www.google.cl/maps/place/Estacionamiento+E-Lira+21/@-33.4416338,-70.6423853,17.25z/data=!4m8!1m2!2m1!1sEstacionamientos!3m4!1s0x0:0xc84d3cc8c63c6f3f!8m2!3d-33.4414762!4d-70.641654'),
(6, 'Miraflores 235 Parking', 'https://www.google.cl/maps/place/Miraflores+235+Parking/@-33.4400504,-70.645916,19.13z/data=!4m8!1m2!2m1!1sEstacionamientos!3m4!1s0x0:0x5399e59a78fa1c9c!8m2!3d-33.4399009!4d-70.645158');

-- --------------------------------------------------------

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `id_pago` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_pago` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
  `precio_ticket` int(50) NOT NULL,
  `id_estacionamiento` int(11) NOT NULL,
  `estado_ticket` int(11) NOT NULL,
  `id_boucher` int(11) NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `ticket_estacionamiento` (`id_estacionamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `precio_ticket`, `id_estacionamiento`, `estado_ticket`, `id_boucher`) VALUES
(1, 10000, 1, 1, 1),
(2, 50000, 2, 1, 1),
(3, 10000, 2, 1, 1),
(4, 321, 2, 1, 2),
(5, 50000, 1, 1, 3),
(7, 454545, 1, 1, 4),
(8, 454545, 2, 1, 4),
(9, 5000, 1, 1, 5),
(10, 123123, 2, 1, 5),
(11, 5000, 1, 1, 6),
(12, 6000, 2, 1, 6),
(13, 5000, 1, 1234560, 0),
(14, 5000, 2, 1234560, 0),
(15, 6500, 4, 1, 7),
(16, 7000, 2, 1, 7),
(17, 2500, 6, 1, 7),
(18, 500, 2, 1, 8),
(19, 5500, 4, 1, 8),
(20, 850, 5, 1, 8),
(21, 654, 1, 1, 9),
(22, 654654, 5, 1, 9);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boucher`
--
ALTER TABLE `boucher`
  ADD CONSTRAINT `boucher_cliente` FOREIGN KEY (`rut_cliente`) REFERENCES `cliente` (`rut_cliente`),
  ADD CONSTRAINT `boucher_envio` FOREIGN KEY (`id_envio`) REFERENCES `envio` (`id_envio`),
  ADD CONSTRAINT `boucher_pago` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_estacionamiento` FOREIGN KEY (`id_estacionamiento`) REFERENCES `estacionamiento` (`id_estacionamiento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
