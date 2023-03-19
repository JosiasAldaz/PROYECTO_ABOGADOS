/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Mostrar_contrato {
    private String nombre_cliu;
    private String apellido_cli;
    private LocalDate fecha;
    private String cedula_cli;
    private int ID_contrato;
    private String descripcion;
    PostgresConexion conn = new PostgresConexion();

    public String getNombre_cliu() {
        return nombre_cliu;
    }

    public void setNombre_cliu(String nombre_cliu) {
        this.nombre_cliu = nombre_cliu;
    }

    public String getApellido_cli() {
        return apellido_cli;
    }

    public void setApellido_cli(String apellido_cli) {
        this.apellido_cli = apellido_cli;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCedula_cli() {
        return cedula_cli;
    }

    public void setCedula_cli(String cedula_cli) {
        this.cedula_cli = cedula_cli;
    }

    public int getID_contrato() {
        return ID_contrato;
    }

    public void setID_contrato(int ID_contrato) {
        this.ID_contrato = ID_contrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public ArrayList motrarCON() throws SQLException{
        String select = "SELECT prim_nom_cli,prim_apell_cli,cedula_cli,fecha_cont,contrato.\"descripcón\",contrato.id_contrato FROM clientes JOIN contrato ON contrato.fk_id_cliente = clientes.id_clie\n" +
"                 where contrato.estado = 'ESPERA'";
        ResultSet contenedor = conn.Consulta(select);
        ArrayList <Mostrar_contrato> listado = new ArrayList();
        while(contenedor.next()){
            Mostrar_contrato objeto = new Mostrar_contrato();
            objeto.setID_contrato(contenedor.getInt("id_contrato"));
            objeto.setNombre_cliu(contenedor.getString("prim_nom_cli"));
            objeto.setApellido_cli(contenedor.getString("prim_apell_cli"));
            objeto.setDescripcion(contenedor.getString("descripcón"));
            objeto.setCedula_cli(contenedor.getString("cedula_cli"));
            java.sql.Timestamp fechaTimestamp = contenedor.getTimestamp("fecha_cont");
            objeto.setFecha(fechaTimestamp.toLocalDateTime().toLocalDate());
            listado.add(objeto);
        }
        return listado;
    }
    
    public void descartar() throws SQLException{
        String update = "UPDATE contrato set estado = 'ELIMINADO' WHERE id_contrato = "+getID_contrato();
        conn.accion(update);
    }
    
    
    public void aceptar() throws SQLException{
        String update = "UPDATE contrato set estado = 'ACEPTADO' WHERE id_contrato = "+getID_contrato();
        conn.accion(update);
    }
}
