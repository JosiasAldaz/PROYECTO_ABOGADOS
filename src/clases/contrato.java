/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class contrato extends Persona{
    private int cod_casos;
    private String descripcion;
    private int FK_ID_abg;
    private LocalDateTime fecha_caso;
    private int ID_cli;
    private int id_contra;
    PostgresConexion conn = new PostgresConexion();
    PostgresConexion conexion = new PostgresConexion();

    public contrato() {
    }

    public contrato(int cod_casos, String descripcion, int FK_ID_abg, LocalDateTime fecha_caso, int ID_cli, int id_contra) {
        this.cod_casos = cod_casos;
        this.descripcion = descripcion;
        this.FK_ID_abg = FK_ID_abg;
        this.fecha_caso = fecha_caso;
        this.ID_cli = ID_cli;
        this.id_contra = id_contra;
    }

    public int getCod_casos() {
        return cod_casos;
    }

    public void setCod_casos(int cod_casos) {
        this.cod_casos = cod_casos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFK_ID_abg() {
        return FK_ID_abg;
    }

    public void setFK_ID_abg(int FK_ID_abg) {
        this.FK_ID_abg = FK_ID_abg;
    }

    public LocalDateTime getFecha_caso() {
        return fecha_caso;
    }

    public void setFecha_caso(LocalDateTime fecha_caso) {
        this.fecha_caso = fecha_caso;
    }

    public int getID_cli() {
        return ID_cli;
    }

    public void setID_cli(int ID_cli) {
        this.ID_cli = ID_cli;
    }

    public int getId_contra() {
        return id_contra;
    }

    public void setId_contra(int id_contra) {
        this.id_contra = id_contra;
    }

    public PostgresConexion getConn() {
        return conn;
    }

    public void setConn(PostgresConexion conn) {
        this.conn = conn;
    }

    public PostgresConexion getConexion() {
        return conexion;
    }

    public void setConexion(PostgresConexion conexion) {
        this.conexion = conexion;
    }

    public void Insert() throws SQLException{
        String sql = "INSERT INTO contrato(fecha_cont,descripcón,fk_ida_bg,fk_id_cliente)"
                +"VALUES('"+getFecha_caso()+"','"+getDescripcion()+"',"+getFK_ID_abg()+","+getID_cli()+")";
        conn.accion(sql);
    }
    
    public ArrayList Listarcon() throws SQLException {
        String sql = "SELECT * FROM CONTRATO WHERE  fk_ida_bg='" +FK_ID_abg+"'";
        ResultSet contenedor = conexion.Consulta(sql);
        ArrayList retorno = new ArrayList();
        while (contenedor.next()) {
            contrato insertar = new contrato();
            insertar.setId_contra(contenedor.getInt("id_contrato"));
            insertar.setDescripcion(contenedor.getString("descripcon"));
            insertar.setFK_ID_abg(contenedor.getInt("fk_ida_bg"));
            insertar.setID_cli(contenedor.getInt("fk_id_cliente"));
            retorno.add(insertar);
        }
        
        return retorno;
    }
}
