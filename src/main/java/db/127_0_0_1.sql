-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2023 at 03:54 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca_tecnica`
--
CREATE DATABASE IF NOT EXISTS `biblioteca_tecnica` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `biblioteca_tecnica`;

-- --------------------------------------------------------

--
-- Table structure for table `libro`
--

CREATE TABLE `libro` (
  `id` int(11) NOT NULL,
  `nombre` varchar(65) NOT NULL,
  `autor` varchar(40) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `genero` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `libro`
--

INSERT INTO `libro` (`id`, `nombre`, `autor`, `descripcion`, `genero`) VALUES
(16, 'Cien años de soledad', 'Gabriel García Márquez', 'Esta obra maestra del realismo mágico narra la historia de la familia Buendía a lo largo de varias generaciones en el ficticio pueblo de Macondo.', NULL),
(17, '1984', 'George Orwell', 'Una distopía clásica que describe un mundo totalitario donde el gobierno controla toda la información y ejerce una vigilancia constante sobre sus ciudadanos.', NULL),
(18, 'El principito', 'Antoine de Saint-Exupéry', 'Un cuento poético y filosófico que sigue las aventuras de un joven príncipe mientras viaja de planeta en planeta, explorando temas de amor y amistad.', NULL),
(19, 'El señor de los anillos', 'J.R.R. Tolkien', 'Una épica trilogía de fantasía que sigue la historia de la Tierra Media y la lucha por destruir un poderoso anillo que podría sumir al mundo en la oscuridad.', NULL),
(20, 'Matar a un ruiseñor', 'Harper Lee', 'Ambientada en el sur de Estados Unidos, esta novela aborda temas de raza y justicia a través de la historia de la defensa de un hombre negro falsamente acusado de violación.', NULL),
(26, 'sdfasdf', 'asdasasdasd', ' asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa asfqwrqweasdqwdasaa', 'Diccionarios en inglés');

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `dni_socio` varchar(8) NOT NULL,
  `id_libro` int(11) NOT NULL,
  `date_start` date NOT NULL DEFAULT current_timestamp(),
  `date_end` date NOT NULL,
  `state` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `socio`
--

CREATE TABLE `socio` (
  `dni` varchar(8) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `surname` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `socio_pedido` (`dni_socio`),
  ADD KEY `libro_pedido` (`id_libro`);

--
-- Indexes for table `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `libro_pedido` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`),
  ADD CONSTRAINT `socio_pedido` FOREIGN KEY (`dni_socio`) REFERENCES `socio` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
