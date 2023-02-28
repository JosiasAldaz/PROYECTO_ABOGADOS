/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Cliente extends Persona{
    private int ID_cliente;
    private PostgresConexion base;
    
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
    
    public void Ingresar(){
        String sql = "INSERT INTO Cliente(cedula_cli,contraseña_cli,prim_nom_cli,seg_nom_cli,prim_apell_cli,seg_apell_cli,edad_cli,genero_cli,fk_id_direccion)";
        sql += " VALUES ('"+super.getCedula()+"','"+ super.getPassword() +"','" + super.getPrimerNombre()+ "','"+getTelefono()+"')";
        if(base.accion(sql) == null){
            JOptionPane.showMessageDialog(null, "SE HA REALIZADO EL INGRESO CORRECTAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO DE CLIENTES");
        }
    }

}
