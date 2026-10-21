-- Base de datos del módulo de clientes de Lúmina
CREATE DATABASE IF NOT EXISTS lumina_db CHARACTER SET utf8mb4;
USE lumina_db;

CREATE TABLE IF NOT EXISTS clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  correo VARCHAR(100),
  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO clientes (nombre, telefono, correo) VALUES
('María González', '3001234567', 'maria@ejemplo.com'),
('Camila Rodríguez', '3112345678', 'camila@ejemplo.com');
