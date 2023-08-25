package view.jframe;

import DBConnection.DataBaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class VentanaPrincipal extends JFrame {
    JMenuBar barra;
    JMenu menu_base;
    JMenu menu_opciones;
    JMenuItem menuItem_conectar;
    JMenuItem menuItem_cerrar;
    JMenuItem menuItem_listar;

    public Connection connection = null;

    public VentanaPrincipal() {
        crearMenu();
    }

    public void crearMenu() {
        barra = new JMenuBar();
        menu_base = new JMenu("Base de Datos");
        menu_opciones = new JMenu("Opciones");
        menuItem_conectar = new JMenuItem("Conectarse a la BD");
        menuItem_cerrar = new JMenuItem("Cerrar BD");
        menuItem_listar = new JMenuItem("Listar Películas");
        menu_base.add(menuItem_conectar);
        menu_base.add(menuItem_cerrar);
        menu_opciones.add(menuItem_listar);
        barra.add(menu_base);
        barra.add(menu_opciones);
        setJMenuBar(barra);


        // Eventos del sistema
        menuItem_conectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                DataBaseConnection.getConnection();
                connection = DataBaseConnection.getConnection();
            }
        });

        menuItem_cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                DataBaseConnection.getConnection();
            }

        });

        menuItem_listar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                if (connection != null) {
                    ListPeliculas lista = new ListPeliculas(connection);
                    lista.mostrar();
                } else {
                    JOptionPane.showMessageDialog(null, "La conexion esta cerrada");
                }

            }

        });

    }
}




