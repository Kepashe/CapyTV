package DAO;

import DBConnection.DataBaseConnection;
import model.Paquete;
import model.Pelicula;
import model.Produccion;
import model.Serie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaqueteDAO {

    //Constantes
    private static String CONSULTA_PAQUETES = "SELECT * FROM PAQUETE";

    //FinConstantes
    //CRUD

    //FinCRUD
    public static ArrayList<Paquete> consultaPaquetes() throws SQLException {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(CONSULTA_PAQUETES);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Paquete paquete = new Paquete();
            paquete.setId(Integer.parseInt(resultSet.getString("ID")));
            paquete.setNombrePaquete(resultSet.getString("NOMBRE"));
            paquete.setDescuento(Double.parseDouble(resultSet.getString("DESCUENTO")));
            paquete.setProducciones(listaPaquetes2(paquete));
        }
        return paquetes;
    }

    //Metodos
    public static String getInfo(Paquete paquete) {
        String inf = "" + paquete.getNombrePaquete() + "  $ " + calcularPrecio(paquete) + "\n";
        return inf;
    }

    // Suponemos que el descuento es un porcentaje del 1% al 100%
    public static double calcularPrecio(Paquete paquete) {
        ArrayList<Produccion> producciones = paquete.getProducciones();
        double valor = 0;
        for (Produccion produccion : producciones) {
            valor += ProduccionDAO.calcularPrecio(produccion);
        }
        double desc = valor * (paquete.getDescuento() / 100);
        valor = valor - desc;
        return valor;
    }

    public static ArrayList<Paquete> listaPaquetes() throws SQLException {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM PAQUETES");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Paquete paquete = new Paquete();
            paquete.setId(Integer.parseInt(resultSet.getString("ID")));
            paquete.setNombrePaquete(resultSet.getString("NOMBRE"));
            paquete.setDescuento(Double.parseDouble(resultSet.getString("ID")));

            ArrayList<Produccion> producciones = new ArrayList<>();
            PreparedStatement statement1 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM LISTA WHERE ID_PAQUETE = ?");
            statement1.setString(1, String.valueOf(paquete.getId()));
            ResultSet resultSet1 = statement1.executeQuery();
            while (resultSet1.next()) {
                PreparedStatement statement2 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM PRODUCCIONES");
                ResultSet resultSet2 = statement2.executeQuery();
                Pelicula peli = new Pelicula();
                peli.setId(Integer.parseInt(resultSet2.getString("ID")));
                peli.setNombre(resultSet2.getString("NOMBRE"));
                peli.setDescripcion(resultSet2.getString("DESCRIPCION"));
                peli.setDuracion(Double.parseDouble(resultSet2.getString("DURACION")));
                peli.setPrecioPorHora(Double.parseDouble(resultSet2.getString("PRECIOPORHORA")));
                producciones.add(peli);


                paquete.setProducciones(producciones);
            }
        }

        return paquetes;
    }

    public static ArrayList<Produccion> listaPaquetes2(Paquete paquete) throws SQLException {

        ArrayList<Produccion> producciones = new ArrayList<>();
        PreparedStatement statement1 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM LISTA WHERE ID_PAQUETE = ?");
        statement1.setString(1, String.valueOf(paquete.getId()));
        ResultSet resultSet1 = statement1.executeQuery();
        while (resultSet1.next()) {
            PreparedStatement statement2 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM PELICULAS");
            ResultSet resultSet2 = statement2.executeQuery();

            if (resultSet1.getString("ID_PRODUCCION") == String.valueOf(resultSet2.getString("ID"))) {
                Pelicula peli = new Pelicula();
                peli.setId(Integer.parseInt(resultSet2.getString("ID")));
                peli.setNombre(resultSet2.getString("NOMBRE"));
                peli.setDescripcion(resultSet2.getString("DESCRIPCION"));
                peli.setDuracion(Double.parseDouble(resultSet2.getString("DURACION")));
                peli.setPrecioPorHora(Double.parseDouble(resultSet2.getString("PRECIOPORHORA")));
                producciones.add(peli);
            }

            PreparedStatement statement3 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM SERIE");
            ResultSet resultSet3 = statement3.executeQuery();

            if (resultSet1.getString("ID_PRODUCCION") == String.valueOf(resultSet2.getString("ID"))) {
                Serie serie = new Serie();
                serie.setId(Integer.parseInt(resultSet2.getString("ID")));
                serie.setNombre(resultSet2.getString("NOMBRE"));
                serie.setDescripcion(resultSet2.getString("DESCRIPCION"));
                serie.setDuracion(Double.parseDouble(resultSet2.getString("DURACION")));
                serie.setPrecioPorHora(Double.parseDouble(resultSet2.getString("PRECIOPORHORA")));
                producciones.add(serie);
            }
        }
        return producciones;
    }
    //FinMetodos
}
