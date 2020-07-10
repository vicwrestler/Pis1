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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author w-res
 */
public class InformacionUsuario extends javax.swing.JFrame {
    Persona_en_sesion per_ses;
    ListaProductos frmListaProductos;
    ActualizarDatosUsuario frmActualizarDatosUsuario;
    InicioSuperAdmin frmInicioSuperAdmin;
    MostrarQuejas frmMostrarQuejas;
    MostrarQuejasUsu frmMostrarQuejasUsu;
    /**
     * Creates new form InformacionUsuario
     */
    public InformacionUsuario() {
        initComponents();
    }
    public InformacionUsuario(Persona_en_sesion per){
        this.per_ses=per;
        initComponents();
        Inicia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jpImg = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnQuejas = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpImgLayout = new javax.swing.GroupLayout(jpImg);
        jpImg.setLayout(jpImgLayout);
        jpImgLayout.setHorizontalGroup(
            jpImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        jpImgLayout.setVerticalGroup(
            jpImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        jlNombre.setText("jLabel2");

        jlApellido.setText("jLabel3");

        jlCorreo.setText("jLabel4");

        jlTelefono.setText("jLabel5");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnQuejas.setText("Quejas");
        btnQuejas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuejasActionPerformed(evt);
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
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegresar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                                .addComponent(jpImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnEditar)
                .addGap(36, 36, 36)
                .addComponent(btnQuejas)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnQuejas))
                .addGap(33, 33, 33)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if(per_ses.getTipo_usuario()==2||per_ses.getTipo_usuario()==1){
            if(frmListaProductos==null){
                frmListaProductos=new ListaProductos(per_ses);
                frmListaProductos.setVisible(true);
                this.dispose();
            }
        }else if(per_ses.getTipo_usuario()==0){
            if(frmInicioSuperAdmin==null){
                frmInicioSuperAdmin=new InicioSuperAdmin(per_ses);
                frmInicioSuperAdmin.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(frmActualizarDatosUsuario==null){
            frmActualizarDatosUsuario=new ActualizarDatosUsuario(per_ses);
            frmActualizarDatosUsuario.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnQuejasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuejasActionPerformed
        if(per_ses.getTipo_usuario()==1){
            if(frmMostrarQuejas==null){
            frmMostrarQuejas=new MostrarQuejas(per_ses);
            frmMostrarQuejas.setVisible(true);
            this.dispose();
        }
        }
        if(per_ses.getTipo_usuario()==2){
            if(frmMostrarQuejasUsu==null){
                frmMostrarQuejasUsu=new MostrarQuejasUsu(per_ses);
                frmMostrarQuejasUsu.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnQuejasActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnQuejas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JPanel jpImg;
    // End of variables declaration//GEN-END:variables

    private void Inicia() {
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
