/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.jframe;

import DAO.ProduccionDAO;
import model.Produccion;

import javax.swing.table.DefaultTableModel;

/**
 * @author ale
 */
public class selectPeliculas extends javax.swing.JFrame {

    public selectPeliculas() {
        initComponents();
    }

    private void listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        final String[] columnNames = {"ID", "NOMBRE", "DESCRIPCION", "DURACION", "PRECIOPORHORA"};
        for (int column = 0; column < columnNames.length; column++) {
            modelo.addColumn(columnNames[column]);
        }
        Object[] fila = new Object[columnNames.length];
        for (Produccion produccion : ProduccionDAO.leerPeliculas()) {
            String result = String.valueOf(produccion.getId());
            fila[0] = result;
            result = produccion.getNombre();
            fila[1] = result;
            result = produccion.getDescripcion();
            fila[2] = result;
            result = String.valueOf(produccion.getDuracion());
            fila[3] = result;
            result = String.valueOf(produccion.getPrecioPorHora());
            fila[4] = result;
            modelo.addRow(fila);
        }

        tblDatos.setModel(modelo);
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

        pnlPeliculas.setBackground(new java.awt.Color(29, 28, 28));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Duración", "Precio/Hora"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        listar();

        btnVolver.setBackground(new java.awt.Color(153, 39, 50));
        btnVolver.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblListaPeliculas.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        lblListaPeliculas.setForeground(new java.awt.Color(255, 255, 255));
        lblListaPeliculas.setText("LISTA DE PELÍCULAS");

        javax.swing.GroupLayout pnlPeliculasLayout = new javax.swing.GroupLayout(pnlPeliculas);
        pnlPeliculas.setLayout(pnlPeliculasLayout);
        pnlPeliculasLayout.setHorizontalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeliculasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeliculasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblListaPeliculas)
                .addGap(326, 326, 326))
        );
        pnlPeliculasLayout.setVerticalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeliculasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblListaPeliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        Principal m = new Principal();
        m.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListaPeliculas;
    private javax.swing.JPanel pnlPeliculas;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
