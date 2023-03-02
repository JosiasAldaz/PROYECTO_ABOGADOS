/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class Cliente extends Persona{
    private int ID_cliente;
    private PostgresConexion base = new PostgresConexion();
    
    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public Cliente(int ID_cliente, String cedula, String PrimerNombre, String SegundoNombre, String NombreApellido, String SegundoApellido, int edad, char genero, int FK_direccion, String telefono, String Usuario, String password) {
        super(cedula, PrimerNombre, SegundoNombre, NombreApellido, SegundoApellido, edad, genero, FK_direccion, telefono, Usuario, password);
        this.ID_cliente = ID_cliente;
    }

    public Cliente() {
        
    }
    
    public void Ingresar() throws SQLException{
        String sql = "INSERT INTO clientes(cedula_cli,contraseña_cli,prim_nom_cli,seg_nom_cli,prim_apell_cli,seg_apell_cli,edad_cli,genero_cli,fk_id_direccion,telefono_cli,correo_cli)";
        sql += " VALUES ('"+super.getCedula()+"','"+super.getPassword()+"',UPPER('"+super.getPrimerNombre()+"'),UPPER('"+super.getSegundoNombre()+"'),UPPER('"+super.getNombreApellido()+"'),UPPER('"+super.getSegundoApellido()+"'),"+super.getEdad()+",UPPER('"+super.getGenero()+"'),"+super.getFK_direccion()+",'"+super.getTelefono()+"','"+super.getCorre()+"')";
        if(base.accion(sql) == null){
            JOptionPane.showMessageDialog(null, "SE HA REALIZADO EL INGRESO CORRECTAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO DE CLIENTES");
        }
    }

    public ArrayList BUSCAR() throws SQLException{
        String sql = "SELECT * FROM clientes";
        ArrayList <Cliente> listadoCLI = new ArrayList();
        ResultSet objeto = base.Consulta(sql);
        if(objeto == null){
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL PROCESO");
        }else{
            while(objeto.next()){
                Cliente registro = new Cliente();
                registro.setID_cliente(Integer.parseInt(objeto.getString("id_clie")));
                registro.setCedula(objeto.getString("cedula_cli"));
                registro.setPrimerNombre(objeto.getString("prim_nom_cli"));
                registro.setSegundoNombre(objeto.getString("seg_nom_cli"));
                listadoCLI.add(registro);
            }
        }
        return listadoCLI;
    }
}
