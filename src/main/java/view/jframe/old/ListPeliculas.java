package view.jframe.old;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ListPeliculas extends JFrame {
    private Connection con;

    public ListPeliculas(Connection con) {
        this.con = con;
    }

    public void mostrar() {
        JFrame frame = new JFrame("Listado de películas");

        DefaultTableModel modelo = new DefaultTableModel();


        final JTable table = new JTable(modelo);

        final String[] columnNames = {"ID", "NOMBRE", "DESCRIPCION", "DURACION", "PRECIOPORHORA"};

        for (int column = 0; column < columnNames.length; column++) {
            modelo.addColumn(columnNames[column]);
        }

        Object[] fila = new Object[columnNames.length];


        String consulta = "SELECT * FROM PRODUCCIONES WHERE TIPO = 1";

        try {
            Statement sentencia = con.createStatement();
            ResultSet peliculaRS = sentencia.executeQuery(consulta);

            while (peliculaRS.next()) {
                String result = peliculaRS.getString("ID");
                fila[0] = result;
                result = peliculaRS.getString("NOMBRE");
                fila[1] = result;
                result = peliculaRS.getString("DESCRIPCION");
                fila[2] = result;
                result = peliculaRS.getString("DURACION");
                fila[3] = result;
                result = peliculaRS.getString("PRECIOPORHORA");
                fila[4] = result;
                modelo.addRow(fila);
            }


        } catch (SQLRecoverableException s) {
            String res = "Conexión esta cerrada -" + s.getMessage();
            JOptionPane.showMessageDialog(null, res);

            return;
        } catch (SQLException s) {
            String res = "Error ejecutando la consulta " + consulta;
            JOptionPane.showMessageDialog(null, res);
            s.printStackTrace();
            return;
        }
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

}
