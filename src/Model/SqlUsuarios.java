/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Persona_en_sesion;
import Clases.persona;
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
public class SqlUsuarios extends Conexion {

    public boolean registrar(persona per, FileInputStream fis) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO personas (Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTelefono());
            ps.setString(4, per.getCorreo());
            ps.setString(5, per.getContraseña());
            ps.setBinaryStream(6, fis, per.getImagen());
            ps.setInt(7, per.getTipo_usuario());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean actualizar(persona per, FileInputStream fis, String correoact) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE personas SET Nombre_s=?,Apellido_s=?,"
                + "Telefono=?,Correo=?,Contraseña=?,Imagen=? WHERE Correo=?";
        //String sql = "INSERT INTO personas (Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario)"
        //      + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTelefono());
            ps.setString(4, per.getCorreo());
            ps.setString(5, per.getContraseña());
            ps.setBinaryStream(6, fis, per.getImagen());
            ps.setString(7, correoact);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean actualizar(persona per, String correoact) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE personas SET Nombre_s=?,Apellido_s=?,"
                + "Telefono=?,Correo=?,Contraseña=? WHERE Correo=?";
        //String sql = "INSERT INTO personas (Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario)"
        //      + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTelefono());
            ps.setString(4, per.getCorreo());
            ps.setString(5, per.getContraseña());
           
            ps.setString(6, correoact);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean login(Persona_en_sesion per) {
        Persona_en_sesion per_ses;
        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConexion();
        String sql = "SELECT * FROM personas "
                + "WHERE Correo=?";

        try {
            ps = con.serverPrepareStatement(sql);
            ps.setString(1, per.getCorreo());
            System.out.print(per.getCorreo());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (per.getContraseña().equals(rs.getString(6))) {
                    per.setId(rs.getInt(1));
                    per.setNombre(rs.getString(2));
                    per.setApellido(rs.getString(3));
                    per.setTelefono(rs.getString(4));
                    per.setCorreo(rs.getString(5));
                    per.setContraseña(rs.getString(6));
                    //per.setImagen(rs.getBytes(7).length);
                    per.setTipo_usuario(rs.getInt(8));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet extraerAdmins() {
        PreparedStatement ps;
        ResultSet rs;
        Conexion objcon = new Conexion();
        Connection con = objcon.getConexion();
        String sql = "SELECT Nombre_s, Apellido_s, Telefono, Correo, Imagen FROM Personas WHERE tipo_usuario=1";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs != null) {
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    public ResultSet extraerAdmin(String correo){
            PreparedStatement ps;
            ResultSet rs;
            Conexion objcon=new Conexion();
            Connection con=objcon.getConexion();
            String sql = "SELECT * FROM Personas WHERE Correo=? AND tipo_usuario=1";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, correo);
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
     public ResultSet extraerUsuarios(){
            PreparedStatement ps;
            ResultSet rs;
            Conexion objcon=new Conexion();
            Connection con=objcon.getConexion();
            String sql = "SELECT Nombre_s, Apellido_s, Telefono, Correo, Imagen FROM Personas WHERE tipo_usuario=2";
        
        try {
            ps=con.prepareStatement(sql);
            //ps.setString(1, correo);
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
    public boolean eliminar(int id){
        PreparedStatement ps;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="DELETE FROM Personas WHERE Id_Persona=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.execute()!=false){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    public boolean eliminar(String correo){
        PreparedStatement ps;
        Conexion objcon=new Conexion();
        Connection con=objcon.getConexion();
        String sql="DELETE FROM Personas WHERE Correo=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, correo);
            if(ps.execute()!=false){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
     public ResultSet extraerUsuario(int id){
            PreparedStatement ps;
            ResultSet rs;
            Conexion objcon=new Conexion();
            Connection con=objcon.getConexion();
            String sql = "SELECT * FROM Personas WHERE Id_Persona=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
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
}
