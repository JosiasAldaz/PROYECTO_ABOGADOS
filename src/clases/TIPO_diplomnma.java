/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class TIPO_diplomnma {
    private int ID_diploma;
    private String nombre_diplo;
    PostgresConexion conn = new PostgresConexion();

    public int getID_diploma() {
        return ID_diploma;
    }

    public void setID_diploma(int ID_diploma) {
        this.ID_diploma = ID_diploma;
    }

    public String getNombre_diplo() {
        return nombre_diplo;
    }

    public void setNombre_diplo(String nombre_diplo) {
        this.nombre_diplo = nombre_diplo;
    }
    
    public void Ingresar() throws SQLException{
        String insert = "INSERT INTO tipo_diploma(nombre_tipo) VALUES('"+nombre_diplo+"')";
        SQLException accion = conn.accion(insert);
        if(accion == null){
            JOptionPane.showMessageDialog(null, "SE HA REALIZADO EL INGRESO CORRECTAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO DE CLIENTES");
        }
    }
    
    public ArrayList mostrar() throws SQLException{
        String sql = "SELECT * FROM TIPO_DIPLOMA";
        ArrayList registros = new ArrayList();
        ResultSet contenedor =conn.Consulta(sql);
        while(contenedor.next()){
            TIPO_diplomnma objeto1 = new TIPO_diplomnma();
            objeto1.setID_diploma(contenedor.getInt("ID_tipo"));
            objeto1.setNombre_diplo(contenedor.getString("nombre_tipo"));
            registros.add(objeto1);
        }
        return registros;
    }
    
    public void ELIMINAR() throws SQLException{
        String sql = "DELETE  FROM tipo_diploma WHERE id_tipo = "+ID_diploma+"";
        conn.accion(sql);
    }
    
    public ArrayList buscar() throws SQLException{
        String sql = "SELECT * FROM tipo_diploma WHERE nombre_tipo ='"+nombre_diplo+"'";
        ArrayList registros = new ArrayList();
        ResultSet contenedor =conn.Consulta(sql);
        while(contenedor.next()){
            TIPO_diplomnma objeto1 = new TIPO_diplomnma();
            objeto1.setID_diploma(contenedor.getInt("ID_tipo"));
            objeto1.setNombre_diplo(contenedor.getString("nombre_tipo"));
            registros.add(objeto1);
        }
        return registros;
    }
    
    public SQLException modificar() throws SQLException{
        String sql = "UPDATE * SET tipo_diploma ='"+getNombre_diplo()+"' WHERE id_tipo = "+getID_diploma();
        return conn.accion(sql);
    }
        
        
    }
