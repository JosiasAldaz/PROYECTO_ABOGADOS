/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import java.util.Date;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Especializacion {
    private int ID_especializacion1;
    private int FK_ID_tipo;
    private String Nombre;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Especializacion(int ID_especializacion1, int FK_ID_tipo, String Nombre, Date fecha_inicio, Date fecha_fin) {
        this.ID_especializacion1 = ID_especializacion1;
        this.FK_ID_tipo = FK_ID_tipo;
        this.Nombre = Nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
        
}
