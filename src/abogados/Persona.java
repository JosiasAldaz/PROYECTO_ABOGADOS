/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Persona {
    private String cedula;
    private String PrimerNombre;
    private String SegundoNombre;
    private int edad;
    private String genero;
    private String direccion;
    private String telefono;
    private String Usuario;
    private String password;

    public Persona() {
    }

    public Persona(String cedula, String PrimerNombre, String SegundoNombre, int edad, String genero, String direccion, String telefono, String Usuario, String password) {
        this.cedula = cedula;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", PrimerNombre=" + PrimerNombre + ", SegundoNombre=" + SegundoNombre + ", edad=" + edad + ", genero=" + genero + ", direccion=" + direccion + ", telefono=" + telefono + ", Usuario=" + Usuario + ", password=" + password + '}';
    }
    
}
