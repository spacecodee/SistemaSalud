-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.22 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para posta
CREATE DATABASE IF NOT EXISTS `posta` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `posta`;

-- Volcando estructura para tabla posta.doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `idDoctor` int NOT NULL AUTO_INCREMENT,
  `codigo` char(4) COLLATE utf8_bin NOT NULL DEFAULT '',
  `nombre` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `Telefono` char(9) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`idDoctor`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla posta.doctor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`idDoctor`, `codigo`, `nombre`, `Telefono`) VALUES
	(1, '1111', 'Marta', '965123478'),
	(2, '2222', 'Jean', '966333211'),
	(6, '3333', 'Arnaldo', '963221458'),
	(7, '4444', 'Katerin', '951348762'),
	(8, '5555', 'Ana', '933666542'),
	(9, '6666', 'Martin', '988774562');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;

-- Volcando estructura para procedimiento posta.spActualizarCita
DELIMITER //
CREATE PROCEDURE `spActualizarCita`(
	IN `idUsu` INT,
	IN `idDoc` INT,
	IN `cod` CHAR(4),
	IN `di` DATE,
	IN `idCita` INT
)
BEGIN
	UPDATE tienecita
	SET dniUsuario = idUsu, idDoctor = idDoc, codigo = cod, dia = di
	WHERE id = idCita;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spActualizarDoctor
DELIMITER //
CREATE PROCEDURE `spActualizarDoctor`(
	IN `cod` CHAR(4),
	IN `nom` VARCHAR(100),
	IN `phone` CHAR(9),
	IN `id` INT
)
BEGIN
	UPDATE doctor 
	SET codigo = cod, nombre = nom, Telefono = phone
	WHERE idDoctor = id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spActualizarUsuario
DELIMITER //
CREATE PROCEDURE `spActualizarUsuario`(
	IN `dn` CHAR(9),
	IN `nom` VARCHAR(100),
	IN `phone` CHAR(9),
	IN `id` INT
)
BEGIN
	UPDATE usuario 
	SET DNI = dn, Nombres = nom, Telefono = phone
	WHERE idUsu = id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spAgregarCita
DELIMITER //
CREATE PROCEDURE `spAgregarCita`(
	IN `idUsu` INT,
	IN `idDoc` INT,
	IN `cod` CHAR(4),
	IN `di` DATE
)
BEGIN
	INSERT INTO tienecita (dniUsuario, idDoctor, codigo, dia)
	VALUES (idUsu, idDoc, cod, di);
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spAgregarUsuario
DELIMITER //
CREATE PROCEDURE `spAgregarUsuario`(
	IN `dn` CHAR(9),
	IN `nom` VARCHAR(100),
	IN `phone` CHAR(9)
)
BEGIN
	INSERT INTO usuario (DNI, Nombres, Telefono)
	VALUES (dn, nom, phone);
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spBuscarCita
DELIMITER //
CREATE PROCEDURE `spBuscarCita`(
	IN `cod` CHAR(4)
)
BEGIN
	SELECT t.id, u.Nombres, d.nombre, t.codigo, t.dia
	FROM tienecita t
	INNER JOIN usuario u
		ON t.dniUsuario = u.idUsu
	INNER JOIN doctor d
		ON t.idDoctor = d.idDoctor
	WHERE t.codigo LIKE CONCAT ('%', cod, '%');
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spBuscarDoctor
DELIMITER //
CREATE PROCEDURE `spBuscarDoctor`(
	IN `cod` CHAR(4)
)
BEGIN
	SELECT *
	FROM doctor
	WHERE codigo LIKE CONCAT('%', cod, '%');
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spBuscarUsuario
DELIMITER //
CREATE PROCEDURE `spBuscarUsuario`(
	IN `dn` CHAR(9)
)
BEGIN
	SELECT *
	FROM usuario
	WHERE DNI LIKE CONCAT('%', dn, '%');
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spELiminarCita
DELIMITER //
CREATE PROCEDURE `spELiminarCita`(
	IN `i` INT
)
BEGIN
	DELETE FROM tienecita
	WHERE id = i;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spEliminarDoctor
DELIMITER //
CREATE PROCEDURE `spEliminarDoctor`(
	IN `id` INT
)
BEGIN
	DELETE FROM doctor
	WHERE idDoctor = id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spEliminarUsuario
DELIMITER //
CREATE PROCEDURE `spEliminarUsuario`(
	IN `id` INT
)
BEGIN
	DELETE FROM usuario
	WHERE idUsu = id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spGuardarDoctor
DELIMITER //
CREATE PROCEDURE `spGuardarDoctor`(
	IN `cod` CHAR(4),
	IN `nom` VARCHAR(100),
	IN `phone` CHAR(9)
)
BEGIN
	INSERT INTO doctor (codigo, nombre, Telefono)
	VALUES (cod, nom, phone);
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spMostarComboDoctor
DELIMITER //
CREATE PROCEDURE `spMostarComboDoctor`()
BEGIN
	SELECT idDoctor, nombre FROM doctor;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spMostrarCita
DELIMITER //
CREATE PROCEDURE `spMostrarCita`()
BEGIN
	SELECT t.id, u.Nombres, d.nombre, t.codigo, t.dia
	FROM tienecita t
	INNER JOIN usuario u
		ON t.dniUsuario = u.idUsu
	INNER JOIN doctor d
		ON t.idDoctor = d.idDoctor;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spMostrarComboUsuarios
DELIMITER //
CREATE PROCEDURE `spMostrarComboUsuarios`()
BEGIN
	SELECT idUsu, Nombres FROM usuario;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spMostrarDoctor
DELIMITER //
CREATE PROCEDURE `spMostrarDoctor`()
BEGIN
	SELECT * FROM doctor;
END//
DELIMITER ;

-- Volcando estructura para procedimiento posta.spMostrarUsuario
DELIMITER //
CREATE PROCEDURE `spMostrarUsuario`()
BEGIN
	SELECT * FROM usuario;
END//
DELIMITER ;

-- Volcando estructura para tabla posta.tienecita
CREATE TABLE IF NOT EXISTS `tienecita` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dniUsuario` int NOT NULL DEFAULT '0',
  `idDoctor` int NOT NULL DEFAULT '0',
  `codigo` char(4) COLLATE utf8_bin NOT NULL,
  `dia` date DEFAULT '2020-01-01',
  PRIMARY KEY (`id`),
  KEY `idUsuarioFK` (`dniUsuario`),
  KEY `idDoctorFK` (`idDoctor`),
  CONSTRAINT `idDoctorFK` FOREIGN KEY (`idDoctor`) REFERENCES `doctor` (`idDoctor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioFK` FOREIGN KEY (`dniUsuario`) REFERENCES `usuario` (`idUsu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla posta.tienecita: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tienecita` DISABLE KEYS */;
INSERT INTO `tienecita` (`id`, `dniUsuario`, `idDoctor`, `codigo`, `dia`) VALUES
	(1, 4, 2, '0001', '2020-02-01'),
	(2, 1, 2, '0002', '2020-01-01'),
	(3, 1, 2, '0003', '2020-11-29'),
	(4, 3, 1, '0004', '2020-11-29'),
	(5, 2, 6, '0005', '2020-11-23'),
	(6, 3, 1, '0006', '2020-11-30'),
	(7, 4, 1, '0007', '2020-11-22'),
	(8, 3, 6, '0006', '2020-11-29'),
	(9, 2, 2, '0008', '2020-11-18');
/*!40000 ALTER TABLE `tienecita` ENABLE KEYS */;

-- Volcando estructura para tabla posta.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsu` int NOT NULL AUTO_INCREMENT,
  `DNI` char(9) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `Nombres` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `Telefono` char(9) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`idUsu`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla posta.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsu`, `DNI`, `Nombres`, `Telefono`) VALUES
	(1, '12365478', 'Juana', '968574123'),
	(2, '12365479', 'María', '963258741'),
	(3, '1236548', 'Mateo', '965412387'),
	(4, '12345678', 'Karina', '965412233'),
	(8, '15968745', 'Marcos', '965412873');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
