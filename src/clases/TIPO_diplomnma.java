/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String insert = "INSERT INTO tipo_diploma (nombre_tipo) VALUES('"+this.getNombre_diplo()+"')";
        conn.accion(insert);
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
    
    }
