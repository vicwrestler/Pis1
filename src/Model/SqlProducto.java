/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Persona_en_sesion;
import Clases.producto;
import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w-res
 */
public class SqlProducto {
    public boolean registrar(producto pro, FileInputStream fis){
        PreparedStatement ps=null;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="INSERT INTO almacen (Titulo, Descripcion, Costo, Categoria, Foto, Id_admin, Cantidad)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getTitulo());
            ps.setString(2, pro.getDescripcion());
            ps.setFloat(3, pro.getCosto());
            ps.setInt(4, pro.getCategoria());
            ps.setBinaryStream(5, fis, pro.getImagen());
            ps.setInt(6, pro.getId_admin());
            ps.setInt(7, pro.getCantidad());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public boolean actualizar(producto pro, FileInputStream fis, int id){
        PreparedStatement ps=null;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="UPDATE almacen SET Titulo=?,Descripcion=?,Costo=?,"
                + "Categoria=?,Foto=?,Cantidad=? WHERE Id_admin=? AND Id_Producto=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getTitulo());
            ps.setString(2, pro.getDescripcion());
            ps.setFloat(3, pro.getCosto());
            ps.setInt(4, pro.getCategoria());
            ps.setBinaryStream(5, fis, pro.getImagen());
            ps.setInt(6, pro.getCantidad());
            ps.setInt(7, pro.getId_admin());
            ps.setInt(8, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean actualizar(producto pro, int id){
        PreparedStatement ps=null;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="UPDATE almacen SET Titulo=?,Descripcion=?,Costo=?,"
                + "Categoria=?,Cantidad=? WHERE Id_admin=? AND Id_Producto=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getTitulo());
            ps.setString(2, pro.getDescripcion());
            ps.setFloat(3, pro.getCosto());
            ps.setInt(4, pro.getCategoria());
            ps.setInt(5, pro.getCantidad());
            ps.setInt(6, pro.getId_admin());
            ps.setInt(7, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ResultSet extraeralmacen(Persona_en_sesion per){
            PreparedStatement ps;
            ResultSet rs;
            Conexion objcon=new Conexion();
            Connection con=objcon.getConexion();
            String sql = "SELECT alm.Titulo, alm.Descripcion, alm.Costo, alm.Categoria, alm.Cantidad, alm.Foto  \n" +
            "FROM almacen AS alm, Personas AS per WHERE per.Id_Persona=alm.Id_admin AND per.Id_Persona=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            //ps.setInt(1, 2);
            rs=ps.executeQuery();
            if(rs!=null){
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    public ResultSet extraeralmacen(){
            PreparedStatement ps;
            ResultSet rs;
            Conexion objcon=new Conexion();
            Connection con=objcon.getConexion();
            String sql = "SELECT alm.Id_Producto, alm.Titulo, alm.Descripcion, alm.Costo, alm.Categoria, alm.Cantidad, alm.Foto  \n" +
            "FROM almacen AS alm";
        
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs!=null){
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    public ResultSet extraerProdalmacen(Persona_en_sesion per, String titulo){
            PreparedStatement ps;
            ResultSet rs;
            Conexion objcon=new Conexion();
            Connection con=objcon.getConexion();
            String sql = "SELECT alm.Id_Producto, alm.Titulo, alm.Descripcion, alm.Costo, alm.Categoria, alm.Cantidad, alm.Foto  \n" +
            "FROM almacen AS alm, Personas AS per WHERE per.Id_Persona=alm.Id_admin AND per.Id_Persona=? AND alm.Titulo=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            //ps.setInt(1, 2);
            ps.setString(2, titulo);
            //ps.setString(2, "Led");
            rs=ps.executeQuery();
            if(rs!=null){
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    public boolean eliminar(producto proelim, Persona_en_sesion per) {
        PreparedStatement ps;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="DELETE FROM almacen WHERE Titulo=? AND Descripcion=? AND Id_admin=? AND Costo=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, proelim.getTitulo());
            ps.setString(2, proelim.getDescripcion());
            ps.setInt(3, per.getId());
            ps.setFloat(4, proelim.getCosto());
            if(ps.execute()!=false){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
}
