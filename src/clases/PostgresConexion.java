/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LENOVO
 */
public class PostgresConexion {
    Connection con;
    String url = "jdbc:postgresql://localhost:5432/ABOGADOS";
    String user = "postgres";
    String password = "Nahofumi2001";
    Statement st;
    
    public PostgresConexion() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgresConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(PostgresConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet Consulta(String sql) {
        try {
            st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PostgresConexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException accion(String nsql) {
        System.out.println(nsql);
        try {
            st = con.createStatement();
            st.execute(nsql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresConexion.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }
}
