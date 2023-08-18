package DBConnection;

import model.Paquete;
import model.Pelicula;
import model.Produccion;

import java.sql.*;
import java.util.ArrayList;

public class ProduccionDB{
//    public ArrayList<Pelicula> ListPelicula() {
//        ArrayList<Pelicula> peliculas = new ArrayList<>();
//        try {
//            Connection cnx = DataBaseConnection.getConnection();
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery("select id, nombre, descripcion, duracion, precioPorHora from PELICULA"); //Aquí la consulta SQL
//            if (rs.next() == false) {
//                System.out.println("RS está vacío");
//            } else {
//                System.out.println("RS tiene algo");
//            }
//
//            while (rs.next()) {
//                System.out.println(rs.next());
//                Pelicula pl = new Pelicula();
//                pl.setId(123);
//                pl.setNombre("La bruja del 69");
//                pl.setDescripcion("Una bruja muy caliente");
//                pl.setDuracion(1.5);
//                pl.setPrecioPorHora(10.99);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error en Listado");
//        }
//        return peliculas;
//    }

//    public static String toString(ResultSet rs) {
//
//        StringBuffer buf = new StringBuffer();
//        buf.append("[");
//        try {
//            ResultSetMetaData metaData = rs.getMetaData();
//            int nColumns = metaData.getColumnCount();
//            for (int i = 1; i <= nColumns; ++i) {
//                buf.append(metaData.getColumnName(i));
//                buf.append(" = ");
//                buf.append(rs.getString(i));
//                if (i < nColumns)
//                    buf.append(" , ");
//            }
//        } catch (SQLException e) {
//            buf.append(e.getMessage());
//            e.printStackTrace();
//        }
//        buf.append("]");
//
//        return buf.toString();
//    }
}
