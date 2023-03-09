/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.abogado;
import java.beans.Statement;
import java.time.LocalDateTime;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class asistente extends Persona {

    private String cod_asist;
    private Double sueldo ;
    private int experiencia;
    private String titudocu;

    public asistente() {
    }

    public asistente(String cod_asist, Double sueldo, int experiencia, String titudocu, String cedula, String PrimerNombre, String SegundoNombre, String NombreApellido, String SegundoApellido, int edad, char genero, int FK_direccion, String telefono, String password, String corre, String foto_perfil, LocalDateTime fecha_nacimiento) {
        super(cedula, PrimerNombre, SegundoNombre, NombreApellido, SegundoApellido, edad, genero, FK_direccion, telefono, password, corre, foto_perfil, fecha_nacimiento);
        this.cod_asist = cod_asist;
        this.sueldo = sueldo;
        this.experiencia = experiencia;
        this.titudocu = titudocu;
    }

    public String getCod_asist() {
        return cod_asist;
    }

    public void setCod_asist(String cod_asist) {
        this.cod_asist = cod_asist;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getTitudocu() {
        return titudocu;
    }

    public void setTitudocu(String titudocu) {
        this.titudocu = titudocu;
    }

    @Override
    public String toString() {
        return super.toString()+"asistente{" + "cod_asist=" + cod_asist + ", sueldo=" + sueldo + ", experiencia=" + experiencia + ", titudocu=" + titudocu + '}';
    }
    
}
