/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Persona {
    private String cedula;
    private String PrimerNombre;
    private String SegundoNombre;
     private String NombreApellido;
    private String SegundoApellido;
    private int edad;
    private String genero;
    private int FK_direccion;
    private String telefono;
    private String Usuario;
    private String password;

    public Persona() {
    }

    public Persona(String cedula, String PrimerNombre, String SegundoNombre, String NombreApellido, String SegundoApellido, int edad, String genero, int FK_direccion, String telefono, String Usuario, String password) {
        this.cedula = cedula;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.NombreApellido = NombreApellido;
        this.SegundoApellido = SegundoApellido;
        this.edad = edad;
        this.genero = genero;
        this.FK_direccion = FK_direccion;
        this.telefono = telefono;
        this.Usuario = Usuario;
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getNombreApellido() {
        return NombreApellido;
    }

    public void setNombreApellido(String NombreApellido) {
        this.NombreApellido = NombreApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDireccion() {
        return FK_direccion;
    }

    public void setDireccion(int direccion) {
        this.FK_direccion = FK_direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
