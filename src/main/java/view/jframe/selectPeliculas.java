/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.jframe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author ale
 */
public class selectPeliculas extends javax.swing.JFrame {


    private final Connection con;

    public selectPeliculas(Connection con) {
        this.con = con;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPeliculas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        lblListaPeliculas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPeliculas.setBackground(new java.awt.Color(250, 149, 4));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Duración", "Precio/Hora"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);





        DefaultTableModel modelo= new DefaultTableModel();

        final String[] columnNames = {"ID","NOMBRE","DESCRIPCION","DURACION","PRECIOPORHORA"};

        for(int column = 0; column < columnNames.length; column++){
            modelo.addColumn(columnNames[column]);
        }

        Object [] fila = new Object[columnNames.length];


        String consulta="SELECT * FROM PELICULA";

        try{
            Statement sentencia = con.createStatement();
            ResultSet peliculaRS = sentencia.executeQuery(consulta);

            while(peliculaRS.next()) {
                String result=peliculaRS.getString("ID");
                fila[0]=result;
                result=peliculaRS.getString("NOMBRE");
                fila[1]=result;
                result=peliculaRS.getString("DESCRIPCION");
                fila[2]=result;
                result=peliculaRS.getString("DURACION");
                fila[3]=result;
                result=peliculaRS.getString("PRECIOPORHORA");
                fila[4]=result;
                modelo.addRow(fila);
            }


        }catch (SQLRecoverableException s) {
            String res="Conexión esta cerrada -"+s.getMessage();
            JOptionPane.showMessageDialog(null,res);

            return;
        }catch (SQLException s){
            String res="Error ejecutando la consulta "+consulta;
            JOptionPane.showMessageDialog(null,res);
            s.printStackTrace();
            return;
        }


        tblDatos.setModel(modelo);




        btnVolver.setBackground(new java.awt.Color(251, 175, 4));
        btnVolver.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblListaPeliculas.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        lblListaPeliculas.setText("Lista de Películas");

        javax.swing.GroupLayout pnlPeliculasLayout = new javax.swing.GroupLayout(pnlPeliculas);
        pnlPeliculas.setLayout(pnlPeliculasLayout);
        pnlPeliculasLayout.setHorizontalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeliculasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListaPeliculas)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlPeliculasLayout.setVerticalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeliculasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblListaPeliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        setVisible(false);
        Menu m = new Menu();
        m.setVisible(true);
    }

//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(selectPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(selectPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(selectPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(selectPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new selectPeliculas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListaPeliculas;
    private javax.swing.JPanel pnlPeliculas;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
