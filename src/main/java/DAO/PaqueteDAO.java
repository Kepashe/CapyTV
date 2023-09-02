package DAO;

import DBConnection.DataBaseConnection;
import com.sun.jdi.PrimitiveValue;
import model.Paquete;
import model.Pelicula;
import model.Produccion;
import model.Serie;
import oracle.jdbc.proxy.annotation.Pre;
import view.jframe.AgregarPaquete;
import view.jframe.Paquetes;

import javax.xml.crypto.Data;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaqueteDAO {

    //Constantes
    private static final String CONSULTA_PAQUETES = "SELECT * FROM PAQUETE";
    private static final String SELECT_PRODUCCIONES = "SELECT * FROM PRODUCCIONES";
    private static final String DELETE_PAQUETE = "DELETE FROM PAQUETE WHERE ID = ?";
    private static final String DELETE_PRODUCCION = "DELETE FROM LISTA WHERE ID_PAQUETE = ?";
    private static final String EDIT_PAQUETE = "UPDATE PAQUETE SET NOMBRE = ?, DESCUENTO = ? WHERE ID = ?";
    private static final String SELECT_PELICULAS = "SELECT * FROM PRODUCCIONES WHERE TIPO = 1";
    private static final String SELECT_SERIES = "SELECT * FROM PRODUCCIONES WHERE TIPO = 2";
    private static final String AGREGAR_PAQUETE = "INSERT INTO PAQUETE (ID, NOMBRE, DESCUENTO) VALUES (?, ?, ?)";
    private static final String AGREGAR_PAQUETE_LISTA = "INSERT INTO LISTA (ID_PAQUETE, ID_PRODUCCION) VALUES (?, ?)";

    //FinConstantes
    //CRUD

    //FinCRUD
    public static ArrayList<Paquete> consultaPaquetes() {
        try {
            ArrayList<Paquete> paquetes = new ArrayList<>();
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(CONSULTA_PAQUETES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Paquete paquete = new Paquete();
                paquete.setId(Integer.parseInt(resultSet.getString("ID")));
                paquete.setNombrePaquete(resultSet.getString("NOMBRE"));
                paquete.setDescuento(Double.parseDouble(resultSet.getString("DESCUENTO")));
                paquete.setProducciones(listaPaquetes2(paquete));
                paquetes.add(paquete);
            }
            return paquetes;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Produccion> consultaPaquetesProducciones() {
        try {
            ArrayList<Produccion> producciones = new ArrayList<>();
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(SELECT_PRODUCCIONES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pelicula produccion = new Pelicula();
                produccion.setId(Integer.parseInt(resultSet.getString("ID")));
                produccion.setNombre(resultSet.getString("NOMBRE"));
                produccion.setDuracion(Double.parseDouble(resultSet.getString("DURACION")));
                produccion.setPrecioPorHora(Double.parseDouble(resultSet.getString("PRECIOPORHORA")));
                produccion.setDescripcion(resultSet.getString("DESCRIPCION"));
                producciones.add(produccion);
            }
            return producciones;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public static void agregarPaquete(Paquete paquete) {
        try {
            PreparedStatement preparedStatement = DataBaseConnection.getConnection().prepareStatement(AGREGAR_PAQUETE);
            preparedStatement.setString(1, String.valueOf(paquete.getId()));
            preparedStatement.setString(2, paquete.getNombrePaquete());
            preparedStatement.setString(3, String.valueOf(paquete.getDescuento()));
            preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void agregarLista(String idPaquete, ArrayList<Produccion> producciones) {
        try {
            for (Produccion produccion : producciones) {
                PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(AGREGAR_PAQUETE_LISTA);
                statement.setString(1, idPaquete);
                statement.setString(2, String.valueOf(produccion.getId()));
                statement.executeUpdate();
                System.out.println("aniadido objeto a LISTA");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

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

    public static ArrayList<Produccion> listaPaquetes2(Paquete paquete) throws SQLException {
        ArrayList<Produccion> producciones = new ArrayList<>();
        PreparedStatement statement1 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM LISTA WHERE ID_PAQUETE = ?");
        statement1.setString(1, String.valueOf(paquete.getId()));
        ResultSet resultSet1 = statement1.executeQuery();
        while (resultSet1.next()) {
            PreparedStatement statement2 = DataBaseConnection.getConnection().prepareStatement("SELECT * FROM PRODUCCIONES");
            try (ResultSet resultSet2 = statement2.executeQuery()) {
                while (resultSet2.next()){
                    if(resultSet2.getString("ID") == resultSet1.getString("ID_PRODUCCION")){
                        Pelicula peli = new Pelicula();
                        peli.setId(Integer.parseInt(resultSet2.getString("ID")));
                        peli.setNombre(resultSet2.getString("NOMBRE"));
                        peli.setDescripcion(resultSet2.getString("DESCRIPCION"));
                        peli.setDuracion(Double.parseDouble(resultSet2.getString("DURACION")));
                        peli.setPrecioPorHora(Double.parseDouble(resultSet2.getString("PRECIOPORHORA")));
                        producciones.add(peli);
                    }
                }
            }
        }
        return producciones;
    }

    public static boolean eliminar(int id) {
        try {
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(DELETE_PAQUETE);
            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();
            PreparedStatement statement2 = DataBaseConnection.getConnection().prepareStatement(DELETE_PRODUCCION);
            statement2.setString(1, String.valueOf(id));
            statement2.executeUpdate();
            return true;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

    public static boolean editar(int id, String nombre, String descuento) {
        try{
            PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(EDIT_PAQUETE);
            statement.setString(1, nombre);
            statement.setString(2, descuento);
            statement.setInt(3, id);
            statement.executeUpdate();
            return true;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }
    //FinMetodos
}
