-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-10-2023 a las 19:14:50
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `nit` varchar(20) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `genero` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `nombre`, `nit`, `correo`, `genero`) VALUES
(1, 'Juan Perez', '12345678', 'juan.perez@example.com', 'masculino'),
(2, 'Ana Rodriguez', '23456789', 'ana.rodriguez@example.com', 'femenino'),
(3, 'Pedro Sanchez', '34567890', 'pedro.sanchez@example.com', 'masculino'),
(4, 'María López', '45678901', 'maria.lopez@example.com', 'femenino'),
(5, 'Carlos García', '56789012', 'carlos.garcia@example.com', 'masculino'),
(6, 'Julian', '78458', 'Julis@perro.com', 'M'),
(7, 'Derick', '78547', 'Valorant4life@lol.com', 'M'),
(8, 'Banjo', '784514', 'Pirateisland@rare.com', 'M'),
(9, 'Kazooie', '856324', 'Mole@rare.com', 'F'),
(10, 'Estuardo', '58584848', 'Guerra@gmail.com', 'M'),
(241, 'Gwen', '75467416', 'Lolsito.com.edu.gt', 'F'),
(254, 'Kirbie', '67184', 'kcarlaw12@telegraph.co.uk', 'F'),
(255, 'Danila', '13958', 'dbigadike0@live.com', 'F'),
(260, 'Tilda', '26662', 'tventurolij@drupal.org', 'F'),
(266, 'Linoel', '31507', 'llinderx@w3.org', 'M'),
(277, 'Ann', '93847', 'aklammtk@usda.gov', 'F'),
(292, 'Juline', '31922', 'jlindes@cisco.com', 'F'),
(299, 'Sett', '478121551', 'Lolillo@Sett.com', 'm'),
(306, 'Frederigo', '44145', 'fodegaardg@wikimedia.org', 'M'),
(317, 'Ev', '69186', 'ethulborne@indiegogo.com', 'M'),
(362, 'Sallyanne', '11363', 'slaythamw@free.fr', 'F'),
(380, 'Gwendolin', '17298', 'gpavolini1@usa.gov', 'F'),
(384, 'Calvin', '17665', 'cbunner18@ihg.com', 'M'),
(388, 'Gary', '74900', 'gconersz@elegantthemes.com', 'M'),
(403, 'Sonnnie', '63371', 'sgilcriesta@jimdo.com', 'F'),
(415, 'Esma', '15758', 'esomerledi@google.com.br', 'F'),
(466, 'Meredeth', '71308', 'mbagger10@cam.ac.uk', 'M'),
(468, 'Jo', '27244', 'jandreaccio7@creativecommons.org', 'M'),
(469, 'Henrie', '13947', 'hloxton19@hexun.com', 'F'),
(477, 'Gannon', '9285', 'gjubb15@gmpg.org', 'M'),
(491, 'Carine', '27034', 'cthurlbeck14@about.me', 'F'),
(501, 'Kev', '11004', 'kmastermanc@dailymail.co.uk', 'M'),
(558, 'Tallie', '29280', 'tskaidm@1688.com', 'M'),
(594, 'Ada', '32132', 'adarinton1d@utexas.edu', 'F'),
(608, 'Keary', '11706', 'kyerrillq@marriott.com', 'M'),
(620, 'Cari', '19239', 'cwalch6@examiner.com', 'F'),
(622, 'Trevor', '31783', 'ttripleto@barnesandnoble.com', 'M'),
(625, 'Aigneis', '14490', 'aeddowd@google.co.jp', 'F'),
(652, 'Opalina', '20201', 'oreedyhough11@hexun.com', 'F'),
(658, 'Cecile', '1757', 'cdeamayay@soup.io', 'F'),
(679, 'Andria', '77579', 'ahargittb@cargocollective.com', 'F'),
(710, 'Hollis', '86839', 'hweatherburn1c@about.me', 'M'),
(712, 'Liane', '19212', 'lmacfadyen9@soup.io', 'F'),
(716, 'Patricia', '54186', 'padamovsky2@springer.com', 'F'),
(729, 'Sheilakathryn', '17134', 'sbreakeyr@amazon.co.uk', 'F'),
(754, 'Angela', '77777789', 'Angela21@pato.com', 'F'),
(757, 'Sibbie', '71143', 'snevinsonp@springer.com', 'F'),
(776, 'Elora', '90205', 'ebebbell1a@yahoo.com', 'F'),
(792, 'Gina', '58677', 'grandalson8@slate.com', 'F'),
(815, 'Liva', '8844', 'lbulgerh@cloudflare.com', 'F'),
(819, 'Terrell', '34286', 'tlangfatu@pcworld.com', 'M'),
(853, 'Gwenette', '88203', 'geverlyf@nytimes.com', 'F'),
(857, 'Fraze', '65406', 'fyakubovich17@sciencedaily.com', 'M'),
(874, 'Mignon', '74836', 'mmacquakert@oaic.gov.au', 'F'),
(890, 'Juli', '98373', 'jcluettn@opensource.org', 'F'),
(909, 'Dar', '39743', 'dolcot16@woothemes.com', 'M'),
(920, 'Ralina', '99680', 'rpeers5@kickstarter.com', 'F'),
(956, 'Russell', '56081', 'rperin13@jigsy.com', 'M'),
(961, 'Jessie', '5050', 'jmegaheyv@ebay.com', 'M'),
(962, 'Willie', '86040', 'wjeskins3@ehow.com', 'F'),
(966, 'Brana', '65763', 'bsparel@opensource.org', 'F'),
(979, 'Reinaldo', '25628', 'rdoidge4@w3.org', 'M'),
(989, 'Zebedee', '41234', 'zaurelius1b@stanford.edu', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `descripcion`, `cantidad`, `precio`) VALUES
(1, 'Laptop Lenovo', 'lap', 10, '900.00'),
(2, 'Smartphone Samsung', 'Smartphone Samsung Galaxy S20 con pantalla de 6.2 pulgadas y cámara trasera de 64MP', 20, '700.00'),
(3, 'Impresora HP', 'Impresora multifunción HP con escáner, copiadora y conexión Wi-Fi', 5, '250.00'),
(4, 'Mouse inalámbrico', 'Mouse óptico inalámbrico con receptor USB', 30, '20.00'),
(5, 'Disco duro externo', 'Disco duro externo de 1TB de capacidad y conexión USB 3.0', 15, '100.00'),
(6, 'monitor', 'gaming 120hz', 10, '1500.99'),
(7, 'vasito', 'awita', 70, '7.50'),
(8, 'Nintendo Switch', 'Pa jugar', 41, '2500.99'),
(9, 'Reloj', 'da la hora', 54, '60.50'),
(10, 'teclado', 'para teclear', 44, '250.01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` text NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`codigo`, `nombre`, `direccion`, `correo`, `telefono`) VALUES
(1, 'Sucursal Central', 'Av. Principal 123, Ciudad Central', 'central@example.com', '98765432'),
(2, 'Sucursal del Este', 'Calle Este 456, Ciudad Este', 'este@example.com', '87654321'),
(3, 'Sucursal del Oeste', 'Calle Oeste 789, Ciudad Oeste', 'oeste@example.com', '76543218'),
(4, 'Sucursal del Norte', 'Av. Norte 246, Ciudad Norte', 'norte@example.com', '65432187'),
(5, 'Sucursal del Sur', 'Calle Sur 369, Ciudad Sur', 'sur@example.com', '54321876'),
(6, 'Ishop', 'portales', 'Aishiop@gmail.com', '78452696'),
(8, 'Undyne', 'TaleUnder', 'TobyFox@Steam.com', '9632545'),
(12, 'Shandee', '7598 Bonner Crossing', 'sbisleyb@liveinternet.ru', '866037062'),
(16, 'Raphaela', '61657 Roxbury Circle', 'rlatanh@imdb.com', '897693789'),
(25, 'Parker', '1 Westerfield Circle', 'pberks5@issuu.com', '436376206'),
(27, 'Maura', '411 Buhler Lane', 'mlamplougha@mac.com', '231874911'),
(30, 'Gabbie', '73662 Petterle Street', 'gcopasd@miitbeian.gov.cn', '395978410'),
(36, 'Kellie', '6 Service Terrace', 'kkeningley1@ucla.edu', '382385273'),
(37, 'Catina', '4 Kennedy Drive', 'cdavidescu3@baidu.com', '176335778'),
(39, 'Cherice', '97 Hollow Ridge Terrace', 'ccrouch7@furl.net', '835962006'),
(41, 'Erica', '28421 Surrey Court', 'esavaage6@sfgate.com', '100213425'),
(47, 'Morris', '6 Northport Crossing', 'mkermath4@yellowpages.com', '219258389'),
(48, 'Meryl', '14 Sunfield Avenue', 'mliptrot9@about.com', '199645377'),
(50, 'Shirline', '405 Gale Hill', 'simmc@businesswire.com', '976658456'),
(57, 'Laural', '5 Montana Center', 'llefridgeg@phpbb.com', '558834476'),
(70, 'Germana', '8 Fairfield Center', 'gsavil8@washington.edu', '866389773'),
(86, 'Betsy', '20102 Moose Plaza', 'bsteggalsf@ycombinator.com', '973327685'),
(87, 'Lorilee', '58 South Alley', 'ldameisele2@wp.com', '213998036'),
(89, 'Peggi', '61064 Erie Drive', 'pmoulder0@meetup.com', '210945721'),
(100, 'Gabriel', '97 Kinsman Junction', 'gtruslere@mozilla.com', '426311934');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `caja` int(50) NOT NULL,
  `ventas` int(11) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`codigo`, `nombre`, `caja`, `ventas`, `genero`, `password`) VALUES
(1, 'admin', 0, 0, '0000000', 'admin'),
(6, 'Maria', 12, 5, 'femenino', NULL),
(7, 'Pedro', 9, 20, 'masculino', NULL),
(9, 'Samayoa', 555, 555, 'F', 'Maripoasas'),
(12, 'Ana', 13, 2, 'femenino', NULL),
(69, 'Sofi', 584, 625, 'F', 'Perritos'),
(74, 'Luis', 74, 12, 'masculino', NULL),
(87, 'Juancito', 6, 26, 'M', 'Payasos'),
(101, 'Katrinka', 101, 0, 'm', 'af579a200b74797b3e78822bf28c2985'),
(102, 'Katleen', 102, 0, 'm', 'e3699d375ded04880e3166dc55f89fde'),
(103, 'Felizio', 103, 0, 'm', '379094cd2c69562f8b8305439b49a613'),
(104, 'Arnie', 104, 0, 'f', '808cb3e29688a78c56610d2a457e5ee4'),
(105, 'Javier', 636, 254, 'M', 'Breaking'),
(201, 'Katrinka', 101, 0, 'm', 'af579a200b74797b3e78822bf28c2985'),
(202, 'Katleen', 102, 0, 'm', 'e3699d375ded04880e3166dc55f89fde'),
(203, 'Felizio', 103, 0, 'm', '379094cd2c69562f8b8305439b49a613'),
(204, 'Arnie', 104, 0, 'f', '808cb3e29688a78c56610d2a457e5ee4'),
(205, 'Edwin', 105, 0, 'f', '4a562ffc4813726d83d0acdd854fc87d'),
(206, 'Laurens', 106, 0, 'f', '1a7417ff18ee9bfe6f04233dd7ec6908'),
(207, 'Allianora', 107, 0, 'm', '3910f2c2fc6b5bce7ed4d739ae576928'),
(208, 'Johnnie', 108, 0, 'f', 'e1d6c5af6076cb6f1d21833b017f7acf'),
(209, 'Kala', 109, 0, 'm', '08621114b828e2910eb45cc0f1d5c11e'),
(210, 'Terrijo', 110, 0, 'm', '5713177c9d4678186b4f52fc58adfca7'),
(211, 'Broderick', 111, 0, 'f', 'f00c4e0dbd8e53f198d650fc877d51c5'),
(212, 'Junia', 112, 0, 'm', '8623116fdaf6cec4a6f34cfdf33e8875'),
(213, 'Myrah', 113, 0, 'm', 'e6ce0d8beebbcb4a35ceeb81d0fa993a'),
(214, 'Wendeline', 114, 0, 'm', 'bebbd8a4c3b2f1498bf9ccd567e9390c'),
(215, 'Malcolm', 115, 0, 'm', 'b24449675845d066d0b8b0823c8125e7'),
(216, 'Otis', 116, 0, 'm', 'cc75ca180881baa4d6fa02673e247891'),
(777, 'Vegetta', 7, 0, 'M', 'Lobo'),
(4516, 'Angel', 331, 2, 'M', 'Gatitas'),
(74841, 'pato', 300, 521, 'F', 'Bob');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `no` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `nit` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`no`, `nombre`, `nit`, `fecha`, `total`) VALUES
(1, 'Venta 1', 123456789, '2023-05-02', 125.5),
(2, 'Venta 2', 987654321, '2023-05-03', 235.75),
(3, 'Venta 3', 456789123, '2023-05-04', 315),
(4, 'Venta 4', 789123456, '2023-05-05', 75.2),
(5, 'Venta 5', 321654987, '2023-05-06', 175.3),
(6, 'Ramoncito', 123456789, '2023-10-17', 100.5),
(7, 'venta2', 784546214, '2023-04-25', 457.25),
(8, 'Gran Venta', 4784581, '2008-04-22', 777.77);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`no`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
