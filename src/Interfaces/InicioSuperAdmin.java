/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Persona_en_sesion;
import Model.SqlUsuarios;
import Utilerias.ImagenMySQL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author w-res
 */
public class InicioSuperAdmin extends javax.swing.JFrame {
Persona_en_sesion per_ses;
InformacionUsuario frminformacionUsuario;
    ListaProductos frmListaProductos;
    Administradores frmAdministradores;
    
    /** Creates new form InicioSuperAdmin */
    public InicioSuperAdmin() {
        initComponents();
        LlenatablaAdm();
        LlenatablaUsua();
    }
    public InicioSuperAdmin(Persona_en_sesion per){
        this.per_ses=per;
        initComponents();
        LlenatablaAdm();
        LlenatablaUsua();
        ExtraeDatosUs();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtAdmin = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtUsua = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGestAdmin = new javax.swing.JButton();
        btnGestUsu = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jpImg = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        btnActulizardatos = new javax.swing.JButton();
        jlTelefono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAdmin);

        jtUsua.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtUsua);

        jLabel1.setText("Usuarios");

        jLabel2.setText("Administradores");

        btnGestAdmin.setText("Gestionar");
        btnGestAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestAdminActionPerformed(evt);
            }
        });

        btnGestUsu.setText("Gestionar");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpImgLayout = new javax.swing.GroupLayout(jpImg);
        jpImg.setLayout(jpImgLayout);
        jpImgLayout.setHorizontalGroup(
            jpImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        jpImgLayout.setVerticalGroup(
            jpImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        jlNombre.setText("jLabel3");

        jlApellido.setText("jLabel4");

        jlCorreo.setText("jLabel5");

        btnActulizardatos.setText("Editar");
        btnActulizardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActulizardatosActionPerformed(evt);
            }
        });

        jlTelefono.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGestAdmin)
                                .addContainerGap(235, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGestUsu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlNombre)
                                            .addComponent(jlApellido)
                                            .addComponent(jlCorreo)
                                            .addComponent(jlTelefono))
                                        .addGap(77, 77, 77))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSalir)
                                        .addGap(20, 20, 20))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActulizardatos)
                                .addGap(68, 68, 68))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGestAdmin))
                    .addComponent(jpImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGestUsu)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jlNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jlApellido)
                        .addGap(18, 18, 18)
                        .addComponent(jlCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlTelefono)
                        .addGap(15, 15, 15)
                        .addComponent(btnActulizardatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        if(frmListaProductos==null){
            frmListaProductos=new ListaProductos();
            frmListaProductos.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActulizardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActulizardatosActionPerformed
        if(frminformacionUsuario==null){
            frminformacionUsuario=new InformacionUsuario(per_ses);
            frminformacionUsuario.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnActulizardatosActionPerformed

    private void btnGestAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestAdminActionPerformed
        if(frmAdministradores==null){
            frmAdministradores=new Administradores(per_ses);
            frmAdministradores.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnGestAdminActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSuperAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActulizardatos;
    private javax.swing.JButton btnGestAdmin;
    private javax.swing.JButton btnGestUsu;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JPanel jpImg;
    private javax.swing.JTable jtAdmin;
    private javax.swing.JTable jtUsua;
    // End of variables declaration//GEN-END:variables

    private void LlenatablaAdm() {
        SqlUsuarios mdlsql=new SqlUsuarios();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtAdmin.setModel(modelo);
            ResultSet rs;
            rs = mdlsql.extraerAdmins();
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

    private void LlenatablaUsua() {
         SqlUsuarios mdlsql=new SqlUsuarios();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtUsua.setModel(modelo);
            ResultSet rs;
            rs = mdlsql.extraerUsuarios();
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadCol = rsMD.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Telefono");
            modelo.addColumn("Correo");
            modelo.addColumn("Foto");
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

    private void ExtraeDatosUs() {
        SqlUsuarios mdlsql=new SqlUsuarios();
        BufferedImage buffimg = null;
        byte[] image = null;
        ResultSet rs=mdlsql.extraerUsuario(per_ses.getId());
        try {
            if(rs.next()){
                image = rs.getBytes("imagen");
                InputStream img = null;
                img = rs.getBinaryStream(7);
                try {
                    buffimg = ImageIO.read(img);
                    ImagenMySQL imagen = new ImagenMySQL(jpImg.getHeight(), jpImg.getWidth(), buffimg);
                    jpImg.add(imagen);
                    jpImg.repaint();

                } catch (IOException ex) {
                    System.err.println(ex);
                    
                }
                jlNombre.setText(rs.getString("Nombre_s"));
                jlApellido.setText(rs.getString("Apellido_s"));
                jlCorreo.setText(rs.getString("Correo"));
                jlTelefono.setText(rs.getString("Telefono"));
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(InformacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}