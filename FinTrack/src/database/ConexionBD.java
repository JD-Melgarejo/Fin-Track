package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private final String URL = "jdbc:oracle:thin:@192.168.122.152:1521:XE";

    private final String USER = "system";

    private final String PASSWORD = "216848";

    public Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexión Exitosa a ORACLE DATABASE");

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());

        }

        return conexion;
    }
}
