/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.PostgresConexion;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Especializacion {

    private int ID_especializacion1;
    private int FK_ID_tipo;
    private String Nombre;
    private int fecha_inicio;
    private int fecha_fin;
    private String univerdadad;
    private int FK_id_agb;
    PostgresConexion conn = new PostgresConexion();

    public Especializacion() {
    }

    public int getID_especializacion1() {
        return ID_especializacion1;
    }

    public void setID_especializacion1(int ID_especializacion1) {
        this.ID_especializacion1 = ID_especializacion1;
    }

    public int getFK_ID_tipo() {
        return FK_ID_tipo;
    }

    public void setFK_ID_tipo(int FK_ID_tipo) {
        this.FK_ID_tipo = FK_ID_tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(int fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(int fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getUniverdadad() {
        return univerdadad;
    }

    public void setUniverdadad(String univerdadad) {
        this.univerdadad = univerdadad;
    }

    public int getFK_id_agb() {
        return FK_id_agb;
    }

    public void setFK_id_agb(int FK_id_agb) {
        this.FK_id_agb = FK_id_agb;
    }

    public void Ingresar_Especialidad() throws SQLException {
        String insert = "INSERT INTO especialidad(nombre_espe,anio_inicio,anio_final,institución,fk_id_agb,fk_id_tipo)";
        insert += "VALUES('" + getNombre() + "'," + getFecha_inicio() + "," + getFecha_fin() + ",'" + getUniverdadad() + "'," + getFK_id_agb() + "," + getFK_ID_tipo() + ")";
        conn.accion(insert);
    }

    public void modificarEspecialidad() throws SQLException {
        String insert = "UPDATE public.especialidad SET   nombre_espe='" + getNombre() + "', anio_inicio='" + getFecha_inicio() + "', anio_final='" + getFecha_fin() + "', institución='" + getUniverdadad() + "' WHERE fk_id_agb= '" + getFK_id_agb() + "'";

        conn.accion(insert);
    }
}
