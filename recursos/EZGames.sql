-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-05-2018 a las 13:46:19
-- Versión del servidor: 5.7.22-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `EZGames`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ACTUALIZA_PROD` (IN `N_PRECIO` INT, IN `N_ART` VARCHAR(20))  UPDATE PRODUCTOS SET PRECIO=N_PRECIO WHERE NOMBREARTÍCULO=N_ART$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MUESTRA_CLIENTES` ()  SELECT * FROM CLIENTES WHERE POBLACIÓN='BARCELONA'$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `CÓDIGOARTÍCULO` varchar(4) DEFAULT NULL,
  `PLATAFORMA` varchar(11) DEFAULT NULL,
  `NOMBREARTÍCULO` varchar(19) DEFAULT NULL,
  `PRECIO` decimal(10,0) DEFAULT NULL,
  `STOCK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`CÓDIGOARTÍCULO`, `PLATAFORMA`, `NOMBREARTÍCULO`, `PRECIO`, `STOCK`) VALUES
('AR01', 'PC', 'LOL', '7', 4),
('AR03', 'PS4', 'COD', '183', 2),
('AR04', 'XBOXONE', 'FIFA', '107', 8),
('AR77', 'PC', 'CounterStrike', '20', 1),
('AR10', 'PC', 'DragonAge', '25', 7),
('AR11', 'PC', 'NBA2K18', '59', 10),
('AR12', 'PS4', 'MineCraft', '5', 3),
('AR13', 'XBOXONE', '007', '10', 6),
('AR14', 'PS4', 'ShadowOfTheColossus', '45', 13),
('AR15', 'PS4', 'RocketLeague', '19', 30),
('AR16', 'PC', 'LifeIsStrange', '17', 5),
('AR17', 'PC', 'Outlast', '39', 26),
('AR18', 'PS4', 'TheWitcher3', '69', 1),
('AR19', 'Switch', 'SwitchSports', '4', 7),
('AR20', 'XBOXONE', 'ForzaMotorsport', '25', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_pass`
--

CREATE TABLE `usuarios_pass` (
  `ID` int(11) NOT NULL,
  `USUARIOS` varchar(20) NOT NULL,
  `PASSWORD` varchar(256) NOT NULL,
  `ADMINISTRADOR` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios_pass`
--

INSERT INTO `usuarios_pass` (`ID`, `USUARIOS`, `PASSWORD`, `ADMINISTRADOR`) VALUES
(1, 'JUAN', '1234', 0),
(2, 'Maria', '54321', 0),
(12, 'Antonio', '123', 0),
(15, 'Sandra', '123456', 1),
(16, 'Luis', 'hola', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoraciones`
--

CREATE TABLE `valoraciones` (
  `CODIGO` varchar(4) NOT NULL,
  `PRODUCTO` varchar(4) NOT NULL,
  `USUARIO` varchar(10) NOT NULL,
  `TEXTO` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `valoraciones`
--

INSERT INTO `valoraciones` (`CODIGO`, `PRODUCTO`, `USUARIO`, `TEXTO`) VALUES
('VA01', 'AR03', 'Juan', 'Repetitivo e igual que sus predecesores. 3/10'),
('VA02', 'AR03', 'Pepe', 'Me ha gustado porque soy una ratkid 7/10'),
('VA04', 'AR01', 'Kevin', 'Muy adictivo aunque tiene mucho lag'),
('VA05', 'AR03', 'Rodolfo', 'Soy de los mejores y por eso  me gusta el juego'),
('VA06', 'AR13', 'Mariano', 'Me gusta la accion aunque es muy corto'),
('VA07', 'AR77', 'Niko', 'Buen juego si es para jugar con amigos!! 9/10'),
('VA08', 'AR77', 'Alba', 'Me quedo con el COD ya que es mas facil'),
('VA09', 'AR19', 'Marta', 'Muy entretenido para jugar toda la familia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios_pass`
--
ALTER TABLE `usuarios_pass`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios_pass`
--
ALTER TABLE `usuarios_pass`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
