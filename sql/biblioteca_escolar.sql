-- Trabajo practico: Biblioteca escolar
-- Crea la base de datos y la tabla libros

CREATE DATABASE IF NOT EXISTS biblioteca_escolar
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE biblioteca_escolar;

CREATE TABLE IF NOT EXISTS libros (
  id        INT          NOT NULL AUTO_INCREMENT,
  titulo    VARCHAR(150) NOT NULL,
  autor     VARCHAR(100) NOT NULL,
  categoria VARCHAR(50)  NOT NULL,
  editorial VARCHAR(100) NOT NULL,
  stock     INT          NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  CONSTRAINT chk_libros_stock CHECK (stock >= 0)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;
