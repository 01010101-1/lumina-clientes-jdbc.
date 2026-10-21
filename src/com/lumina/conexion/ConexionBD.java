package com.lumina.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Entrega la conexión JDBC a la base de datos lumina_db (MySQL). */
public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/lumina_db?useSSL=false&serverTimezone=America/Bogota";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
