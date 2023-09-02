package DAO;

import DBConnection.DataBaseConnection;
import model.Pelicula;
import model.Produccion;
import model.Serie;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduccionDAO {
    private static final String SELECT_PRODUCCION = "SELECT * FROM PRODUCCIONES";
    private static final String INSERT_PRODUCCION = "INSERT INTO PRODUCCIONES (NOMBRE, DESCRIPCION, PRECIOPORHORA, DURACION, TIPO) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_PRODUCCION = "DELETE FROM PRODUCCIONES WHERE ID = ?";
    private static final String UPDATE_PRODUCCION = "UPDATE PRODUCCIONES SET NOMBRE = ?, DESCRIPCION = ?, PRECIOPORHORA = ?, DURACION = ?, TIPO = ? WHERE ID = ?";
    private static final String SELECT_PELICULAS = "SELECT * FROM PRODUCCIONES WHERE TIPO = 1";
    private static final String SELECT_SERIES = "SELECT * FROM PRODUCCIONES WHERE TIPO = 2";

    public void agregarProduccion(Produccion produccion) {
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(INSERT_PRODUCCION);
            statement.setString(1, produccion.getNombre());
            statement.setString(2, produccion.getDescripcion());
            statement.setDouble(3, produccion.getPrecioPorHora());
            statement.setDouble(4, produccion.getDuracion());
            statement.setInt(5, produccion.getTipo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProduccion(int id) {
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(DELETE_PRODUCCION);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificarProduccion(String nombre, String descripcion, double precio, double duracion, int tipo, int id) {
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(UPDATE_PRODUCCION);
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setDouble(3, precio);
            statement.setDouble(4, duracion);
            statement.setInt(5, tipo);
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Produccion> mostrarProducciones() {
        List<Produccion> producciones = new ArrayList<>();
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(SELECT_PRODUCCION);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double precioPorHora = resultSet.getDouble("precioPorHora");
                double duracion = resultSet.getDouble("duracion");
                int tipo = resultSet.getInt("tipo");
                Produccion produ = new Produccion(id, nombre, descripcion, duracion, precioPorHora, tipo);
                producciones.add(produ);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producciones;
    }

    public static List<Pelicula> leerPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(SELECT_PELICULAS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double precioPorHora = resultSet.getDouble("precioPorHora");
                double duracion = resultSet.getDouble("duracion");
                int tipo = resultSet.getInt("tipo");
                Pelicula pelicula = new Pelicula(id, nombre, descripcion, duracion, precioPorHora, tipo);
                peliculas.add(pelicula);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas; // Devuelve la lista de películas
    }

    public static List<Serie> leerSeries() {
        List<Serie> series = new ArrayList<>();
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(SELECT_SERIES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double precioPorHora = resultSet.getDouble("precioPorHora");
                double duracion = resultSet.getDouble("duracion");
                int tipo = resultSet.getInt("tipo");

                Serie serie = new Serie(id, nombre, descripcion, duracion, precioPorHora, tipo);
                series.add(serie);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return series; // Devuelve la lista de series
    }

    public static String getInfo(Produccion produccion) {
        String inf = "" + produccion.getNombre() + "  $ " + calcularPrecio(produccion) + "\n";
        return inf;
    }

    public static double calcularPrecio(Produccion produccion) {
        double precio = produccion.getDuracion() * produccion.getPrecioPorHora();
        return precio;
    }

    public void cerrarRecursos(ResultSet resultSet, PreparedStatement statement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}