/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Casos {
    private int cod_casos;
    private String nombre_caso;
    private Date fecha_inicio;
    private int ID_cli;

    public Casos(int cod_casos, String nombre_caso, Date fecha_inicio, int ID_cli) {
        this.cod_casos = cod_casos;
        this.nombre_caso = nombre_caso;
        this.fecha_inicio = fecha_inicio;
        this.ID_cli = ID_cli;
    }

    public Casos() {
    }

    
    public int getCod_casos() {
        return cod_casos;
    }

    public void setCod_casos(int cod_casos) {
        this.cod_casos = cod_casos;
    }

    public String getNombre_caso() {
        return nombre_caso;
    }

    public void setNombre_caso(String nombre_caso) {
        this.nombre_caso = nombre_caso;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getID_cli() {
        return ID_cli;
    }

    public void setID_cli(int ID_cli) {
        this.ID_cli = ID_cli;
    }
    
    
}
