/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.quejas;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w-res
 */
public class SqlQuejas {
    public boolean registrar(quejas que){
        PreparedStatement ps=null;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="INSERT INTO quejas (Titulo, Descripcion, Id_usuario)"
                + " VALUES(?, ?, ?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, que.getTitulo());
            ps.setString(2, que.getDescripcion());
            ps.setInt(3, que.getId_usuario());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
