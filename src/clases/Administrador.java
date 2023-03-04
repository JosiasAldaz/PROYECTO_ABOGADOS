/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Administrador extends Persona{
    private String foto_admin;
    private int ID_admin;
    PostgresConexion conn = new PostgresConexion();

    public Administrador(String foto_admin, int ID_admin, String cedula, String PrimerNombre, String SegundoNombre, String NombreApellido, String SegundoApellido, int edad, char genero, int FK_direccion, String telefono, String password, String corre, String foto_perfil, LocalDateTime fecha_nacimiento) {
        super(cedula, PrimerNombre, SegundoNombre, NombreApellido, SegundoApellido, edad, genero, FK_direccion, telefono, password, corre, foto_perfil, fecha_nacimiento);
        this.foto_admin = foto_admin;
        this.ID_admin = ID_admin;
    }

    public Administrador() {
    }

    
    public String getFoto_admin() {
        return foto_admin;
    }

    public void setFoto_admin(String foto_admin) {
        this.foto_admin = foto_admin;
    }

    public int getID_admin() {
        return ID_admin;
    }

    public void setID_admin(int ID_admin) {
        this.ID_admin = ID_admin;
    }
    
    public void Ingresar() throws SQLException{
        String sql = "INSERT INTO administrador (cedula_admin,contraseña_admin,prim_nom_admin,seg_nom_admin,prim_apell_admin,seg_apell_admin,genero_admin,fk_id_direcciones,telefono_admin,correo_admin,fecha_nacimiento,foto_admin)";
        sql += " VALUES ('"+super.getCedula()+"','"+super.getPassword()+"',UPPER('"+super.getPrimerNombre()+"'),UPPER('"+super.getSegundoNombre()+"'),UPPER('"+super.getNombreApellido()+"'),UPPER('"+super.getSegundoApellido()+"'),UPPER('"+super.getGenero()+"'),"+super.getFK_direccion()+",'"+super.getTelefono()+"','"+super.getCorre()+"','"+super.getFecha_nacimiento()+"','"+super.getFoto_perfil()+"')";
        if(conn.accion(sql) == null){
            JOptionPane.showMessageDialog(null, "SE HA REALIZADO EL INGRESO CORRECTAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO DE CLIENTES");
        }
    }
    
}
