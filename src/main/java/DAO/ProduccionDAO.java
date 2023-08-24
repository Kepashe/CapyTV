package DAO;

import model.Pelicula;
import model.Produccion;
import model.Serie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduccionDAO {
    private static final String INSERT_PRODUCCION = "INSERT INTO PRODUCCION (NOMBRE, PRECIOPORHORA, DURACION) VALUES (?, ?, ?)";
    private static final String DELETE_PRODUCCION = "DELETE FROM PRODUCCION WHERE ID = ?";
    private static final String UPDATE_PRODUCCION = "UPDATE PRODUCCION SET NOMBRE = ?, PRECIOPORHORA = ?, DURACION = ? WHERE ID = ?";
    private static final String SELECT_PELICULAS = "SELECT * FROM PELICULA";
    private static final String SELECT_SERIES = "SELECT * FROM SERIE";

    public void agregarProduccion(Produccion produccion, PreparedStatement statement) {
        try {
            statement.setString(1, produccion.getNombre());
            statement.setDouble(2, produccion.getPrecioPorHora());
            statement.setDouble(3, produccion.getDuracion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProduccion(int id, PreparedStatement statement) {
        try {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarProduccion(Produccion produccion, PreparedStatement statement) {
        try {
            statement.setString(1, produccion.getNombre());
            statement.setDouble(2, produccion.getPrecioPorHora());
            statement.setDouble(3, produccion.getDuracion());
            statement.setInt(4, produccion.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pelicula> leerPeliculas(PreparedStatement statement) {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double precioPorHora = resultSet.getDouble("precioPorHora");
                double duracion = resultSet.getDouble("duracion");
                Pelicula pelicula = new Pelicula(id, nombre, descripcion, duracion, precioPorHora);
                peliculas.add(pelicula);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas; // Devuelve la lista de películas
    }

    public List<Serie> leerSeries(PreparedStatement statement) {
        List<Serie> series = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double precioPorHora = resultSet.getDouble("precioPorHora");
                double duracion = resultSet.getDouble("duracion");
                Serie serie = new Serie(id, nombre, descripcion, duracion, precioPorHora);
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