/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author w-res
 */
public class Conexion{
    private final String base="tienda";
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/"+base;
    //private final String url="jdbc:mysql://192.168.56.1:3306/"+base;
    private Connection con=null;
    public Connection getConexion(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection(this.url, this.user, this.password);
        }catch(SQLException e){
            System.err.println(e);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
