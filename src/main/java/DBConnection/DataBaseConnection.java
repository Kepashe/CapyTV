package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

static Connection connection = null;

    public static Connection abrirConexion() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver encontrado");

            try {
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/XEPDB1", "System", "root");
                System.out.println("Conexion exitosa");
            } catch (SQLException s) {
                System.out.println("Error de conexion");
                s.printStackTrace();
            }

        } catch (ClassNotFoundException s) {
            System.out.println("Driver no encontrado");
            s.printStackTrace();
        }
        return connection;
    }

    public static void cerrarConexion() {
        try {
            connection.close();
            System.out.println("Conexion cerrada");

        } catch (SQLException s) {

            System.out.println("Error al cerrar la conexion");
            s.printStackTrace();
        }
    }

}
