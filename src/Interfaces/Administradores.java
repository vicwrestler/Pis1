/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Persona_en_sesion;
import Clases.persona;
import Model.SqlUsuarios;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author w-res
 */
public class Administradores extends javax.swing.JFrame {

    Persona_en_sesion per_ses;
    NuevoAdmin frmnueNuevoAdmin;
    ActulizarAdmins frmActulizarAdmins;
    persona per;
    InicioSuperAdmin frmInicioSuperAdmin;

    /**
     * Creates new form Administradores
     */
    public Administradores() {
        initComponents();
        Llenatabla();
    }

    public Administradores(Persona_en_sesion per) {
        this.per_ses = per;
        initComponents();
        Llenatabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAdmins = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adminstradores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtAdmins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apeliido", "Correo", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAdmins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ObjPresionado(evt);
            }
        });
        jScrollPane2.setViewportView(jtAdmins);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnAgregar)
                        .addGap(52, 52, 52)
                        .addComponent(btnActualizar)
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (frmInicioSuperAdmin == null) {
            frmInicioSuperAdmin = new InicioSuperAdmin(per_ses);
            frmInicioSuperAdmin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (frmnueNuevoAdmin == null) {
            frmnueNuevoAdmin = new NuevoAdmin(per_ses);
            frmnueNuevoAdmin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (frmActulizarAdmins == null) {
            frmActulizarAdmins = new ActulizarAdmins(per_ses);
            frmActulizarAdmins.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void ObjPresionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ObjPresionado
        SqlUsuarios modsql = new SqlUsuarios();
        int fila = jtAdmins.getSelectedRow();

        try {

            String correo = jtAdmins.getValueAt(fila, 3).toString();
            ResultSet rs;
            rs = modsql.extraerAdmin(correo);

            if (rs.next()) {
                per = new persona();
                per.setId(rs.getInt("Id_Persona"));
                System.out.println(per.getId());
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_ObjPresionado

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        SqlUsuarios mdlsql = new SqlUsuarios();
        if (per == null) {
            JOptionPane.showMessageDialog(null, "Seleccione algun registro de la tabla");
        } else {
            if (!mdlsql.eliminar(per.getId())) {
                JOptionPane.showMessageDialog(null, "Administrador eliminado");
                Llenatabla();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (frmInicioSuperAdmin == null) {
            frmInicioSuperAdmin = new InicioSuperAdmin(per_ses);
            frmInicioSuperAdmin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtAdmins;
    // End of variables declaration//GEN-END:variables

    private void Llenatabla() {
        SqlUsuarios mdlSql = new SqlUsuarios();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtAdmins.setModel(modelo);

            ResultSet rs;
            rs = mdlSql.extraerAdmins();
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadCol = rsMD.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Telefono");
            modelo.addColumn("Correo");
            modelo.addColumn("Foto");

            //int[] tamaños=nes int[];
            while (rs.next()) {
                Object[] filas = new Object[cantidadCol];
                for (int i = 0; i < cantidadCol; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);

            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
