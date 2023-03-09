/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author KEVIN SANCHEZ
 */
public class conexion_kevin {
    Connection com=null;
    String url = "jdbc:postgresql://localhost:5432/ABOGADOS";
    String usuario= "postgres";
    String clave="sanchez70";
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            com=DriverManager.getConnection(url,usuario,clave);
            JOptionPane.showMessageDialog(null,"CONEXION EXITOSA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar " +e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return com ;
    }
}
 
