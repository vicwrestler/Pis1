/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Persona_en_sesion;
import Clases.carrito;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w-res
 */
public class SqlCarrito {

    public boolean agregar(carrito carr) {
        PreparedStatement ps = null;
        Conexion objcon = new Conexion();
        Connection con = objcon.getConexion();
        String sql = "INSERT INTO Carrito(Id_usuario, Id_producto, Cantidad) VALUES(?, ?, ?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, carr.getIdUsuario());
            ps.setInt(2, carr.getIdProducto());

            ps.setInt(3, carr.getCantidad());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ResultSet extraercarrito(Persona_en_sesion per) {
        PreparedStatement ps = null;
        Conexion objcon = new Conexion();
        Connection con = objcon.getConexion();
        ResultSet rs;
        String sql = "SELECT A.Titulo, A.Costo, A.Foto, C.Cantidad FROM Almacen AS A, Carrito AS C "
                + "WHERE C.Id_usuario=? AND A.Id_Producto=C.Id_producto";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(SqlCarrito.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
