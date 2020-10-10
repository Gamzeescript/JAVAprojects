create database if not exists agenda;
use agenda;

CREATE TABLE `categoria` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecCreacion` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;



INSERT INTO `categoria` VALUES (1,'java','',2019-08-10),(2,'POO','',2019-08-10),(3,'JAVA 2','',2019-08-10),(4,'JAVA 3','',2019-08-10),(5,'HTML 5','',2019-08-10),(6,'PHP 7','',2019-08-10),(7,'Ruby','\0',2019-08-10),(8,'JAVA 100','',2019-08-10),(9,'JavaScript','',2019-08-10),(10,'RUBY','',2019-08-10),(11,'PHP3','',2019-08-10),(12,'PHP4','',2019-08-10),(13,'PHP100','',2019-08-10),(14,'RUBY','',2019-08-10),(18,'JAVA26','',2019-08-10),(24,'ssss','',2019-08-10),(25,'aaaa','\0',2019-08-10);

CREATE TABLE `menu` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `tipo` enum('S','I') NOT NULL,
  `tipoUsuario` enum('A','O') NOT NULL,
  `codigo_submenu` tinyint(4) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `nota` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_persona` int(11) DEFAULT NULL,
  `codigo_categoria` int(11) DEFAULT NULL,
  `encabezado` int(11) DEFAULT NULL,
  `cuerpo` varchar(250) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `comentarioAdmin` varchar(50) DEFAULT NULL,
  `valoracion` enum('1','2','3','4','5') DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `persona` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `telefono` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_persona` int(11) DEFAULT NULL,
  `numero` char(9) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) DEFAULT NULL,
  `clave` varchar(40) DEFAULT NULL,
  `tipo` enum('A','O') DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table usuario add column  codigo_persona int;
alter table usuario add constraint fk_persona foreign key (codigo_persona) references persona (codigo);
alter table telefono add constraint fk_persona_2 foreign key (codigo_persona) references persona (codigo);
alter table nota add constraint fk_categoria_2 foreign key (codigo_categoria) references categoria (codigo);
alter table nota add constraint fk_persona3 foreign key (codigo_persona) references persona (codigo);
