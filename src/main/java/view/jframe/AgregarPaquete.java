/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.jframe;

import DAO.PaqueteDAO;
import DAO.ProduccionDAO;
import DBConnection.DataBaseConnection;
import model.Paquete;
import model.Pelicula;
import model.Produccion;
import oracle.jdbc.proxy.annotation.Pre;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ale
 */
public class AgregarPaquete extends javax.swing.JFrame {

    /**
     * Creates new form AgregarPaquete
     */
    public AgregarPaquete() {
        initComponents();
    }
    JCheckBox checkBox = new JCheckBox();

    public static boolean isSelected(int row, int column, JTable jTable) {
        boolean boo = (boolean) jTable.getValueAt(row, 0);
        if(boo != false){
            return true;
        }
        return false;
    }


    private void listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        final String[] columnNames = {"AGREGAR" ,"ID", "NOMBRE", "DESCRIPCION", "DURACION", "PRECIOPORHORA"};
        for (int column = 0; column < columnNames.length; column++) {
            modelo.addColumn(columnNames[column]);
        }
        Object[] fila = new Object[columnNames.length];
        for (Produccion produccion : PaqueteDAO.consultaPaquetesProducciones()) {
            fila[0] = "";
            String result = String.valueOf(produccion.getId());
            fila[1] = result;
            result = produccion.getNombre();
            fila[2] = result;
            result = produccion.getDescripcion();
            fila[3] = result;
            result = String.valueOf(produccion.getDuracion());
            fila[4] = result;
            result = String.valueOf(produccion.getPrecioPorHora());
            fila[5] = result;
            modelo.addRow(fila);
        }
        tblDatos.setModel(modelo);

    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtID.setToolTipText("");

        txtNombre.setToolTipText("");

        txtDescuento.setToolTipText("");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agregar", "ID", "Nombre", "Descripción", "Duración", "Precio/Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);
        listar();

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Paquete paquete = new Paquete();
        ArrayList<Produccion> prod = new ArrayList<>();
        paquete.setId(Integer.parseInt(txtID.getText()));
        paquete.setNombrePaquete(txtNombre.getText());
        paquete.setDescuento(Double.parseDouble(txtDescuento.getText()));
        PaqueteDAO.agregarPaquete(paquete);

        for (int i = 0; i < tblDatos.getRowCount(); i++) {
            if(isSelected(i, 0, tblDatos)){
                Pelicula pelicula = new Pelicula();
                pelicula.setId(Integer.parseInt(tblDatos.getValueAt(i, 1).toString()));
                pelicula.setNombre(tblDatos.getValueAt(i, 2).toString());
                pelicula.setDescripcion(tblDatos.getValueAt(i, 3).toString());
                pelicula.setDuracion(Double.parseDouble(tblDatos.getValueAt(i, 4).toString()));
                pelicula.setPrecioPorHora(Double.parseDouble(tblDatos.getValueAt(i, 5).toString()));
                prod.add(pelicula);
//                tblDatos.getValueAt(i,)
//                PaqueteDAO.agregarLista(paquete.getId(), );
            }
        }


        PaqueteDAO.agregarLista(String.valueOf(paquete.getId()) , prod);
        JOptionPane.showMessageDialog(null, "Paquete agregado con exito.");

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
        Paquetes paquetes = new Paquetes();
        paquetes.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked

    }//GEN-LAST:event_tblDatosMouseClicked


    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
