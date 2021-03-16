package utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private final String USER = "root";
    private final String PASSWORD = "ovejita123";
    private final String DB_NAME = "addressapp";
    private final int PORT = 3306;
    private final String URL = "jdbc:mysql://localhost:" + PORT + "/" + DB_NAME;
    private Connection connection;

    public DbConnection() {

    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se ha podido establecer conexión con la base de datos");
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El método cerrar conexión no puede cerrar una conexión nula");
        }
    }

    public boolean isConnected() {
        return (connection != null);
    }
}
