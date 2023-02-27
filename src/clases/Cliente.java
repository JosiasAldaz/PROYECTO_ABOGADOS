/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author LENOVO
 */
public class Cliente extends Persona{
    private int ID_cliente;

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public Cliente(int ID_cliente, String cedula, String PrimerNombre, String SegundoNombre, String NombreApellido, String SegundoApellido, int edad, String genero, int FK_direccion, String telefono, String Usuario, String password) {
        super(cedula, PrimerNombre, SegundoNombre, NombreApellido, SegundoApellido, edad, genero, FK_direccion, telefono, Usuario, password);
        this.ID_cliente = ID_cliente;
    }

    public Cliente() {
    }
    
    
}
