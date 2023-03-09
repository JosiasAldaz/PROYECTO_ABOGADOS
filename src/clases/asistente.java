/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.abogado;
import java.beans.Statement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class asistente extends Persona {

    private String cod_asist;
    private Double sueldo;
    private int experiencia;
    private String titudocu;
    PostgresConexion conexion = new PostgresConexion();

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

    public void Ingresar() throws SQLException {
        String sql = "INSERT INTO public.asistente(titulo_asis, years_esperiencia, cedula_asis, contraseña_asis, prim_nom_asis, seg_nom_asis, prim_apell_asis, seg_apell_asis, edad_asis, genero_asis, fk_dir_asis, fecha_inicio, sueldo_asis,celular, email, foto)"
                + "VALUES ('" + getTitudocu() + "','" + getExperiencia() + "','" + super.getCedula() + "', '" + super.getPassword() + "' , '" + super.getPrimerNombre() + "','" + super.getSegundoNombre() + "' , '" + super.getNombreApellido() + "' ,'" + super.getSegundoApellido() + "','" + super.getEdad() + "' , '" + super.getGenero() + "' , '" + super.getFK_direccion() + "' ,'" + super.getFecha_nacimiento() + "' , '" + getSueldo() + "' , '" + super.getTelefono() + "' , '" + super.getCorre() + "' , '" + super.getFoto_perfil()+ "')";
        conexion.accion(sql);
    }
}
