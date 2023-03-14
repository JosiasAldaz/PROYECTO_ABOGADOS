/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class contrato {
    private int cod_casos;
    private String descripcion;
    private int FK_ID_abg;
    private LocalDateTime fecha_caso;
    private int ID_cli;
    PostgresConexion conn = new PostgresConexion();

    public contrato(int cod_casos,int ID_cli) {
        this.cod_casos = cod_casos;
        this.ID_cli = ID_cli;
    }

    public contrato() {
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
    
    public void Insert() throws SQLException{
        String sql = "INSERT INTO contrato(fecha_cont,descripcón,fk_ida_bg,fk_id_cliente)"
                +"VALUES('"+getFecha_caso()+"','"+getDescripcion()+"',"+getFK_ID_abg()+","+getID_cli()+")";
        conn.accion(sql);
    }
}
