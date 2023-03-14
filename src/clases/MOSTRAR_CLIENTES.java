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
public class MOSTRAR_CLIENTES {
    private String cedula;
    private String nombrecompleto;
    private String correo;
    private double costohoras;
    private String telefono;
    private String especialización;
    private String foto;
    PostgresConexion conn = new PostgresConexion();
    
    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getCostohoras() {
        return costohoras;
    }

    public void setCostohoras(double costohoras) {
        this.costohoras = costohoras;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialización() {
        return especialización;
    }

    public void setEspecialización(String especialización) {
        this.especialización = especialización;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public ArrayList mostrarcli(int a) throws SQLException{
        String select = "SELECT abogado.prim_nom_abg,abogado.prim_apell_abg,abogado.costo_x_horas,abogado.correo_abg,abogado.telefono_abg,abogado.cedula_abg,abogado.foto_abg,especialidad.nombre_espe\n"
                + "FROM abogado\n"
                + "INNER JOIN especialidad ON abogado.id_abg = especialidad.fk_id_agb\n"
                + "WHERE especialidad.fk_id_tipo ="+a;
        ArrayList <MOSTRAR_CLIENTES> retorno = new ArrayList();
        ResultSet contenedor = conn.Consulta(select);
            while(contenedor.next()){
                MOSTRAR_CLIENTES item = new MOSTRAR_CLIENTES();
                item.setCorreo(contenedor.getString("correo_abg"));
                item.setNombrecompleto(contenedor.getString("prim_nom_abg")+" "+contenedor.getString("prim_apell_abg"));
                item.setTelefono(contenedor.getString("telefono_abg"));
                item.setEspecialización(contenedor.getString("nombre_espe"));
                item.setCostohoras(contenedor.getDouble("costo_x_horas"));
                item.setFoto(contenedor.getString("foto_abg"));
                retorno.add(item);
            }
        return retorno;
    }
    
    
}
