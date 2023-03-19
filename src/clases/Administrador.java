/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Administrador extends Persona {

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

    public void Ingresar() throws SQLException {
        String sql = "INSERT INTO administrador (cedula_admin,contraseña_admin,prim_nom_admin,seg_nom_admin,prim_apell_admin,seg_apell_admin,genero_admin,fk_id_direcciones,telefono_admin,correo_admin,fecha_nacimiento,foto_admin,edad_adm)";
        sql += " VALUES ('" + super.getCedula() + "','" + super.getPassword() + "',UPPER('" + super.getPrimerNombre() + "'),UPPER('" + super.getSegundoNombre() + "'),UPPER('" + super.getNombreApellido() + "'),UPPER('" + super.getSegundoApellido() + "'),UPPER('" + super.getGenero() + "')," + super.getFK_direccion() + ",'" + super.getTelefono() + "','" + super.getCorre() + "','" + super.getFecha_nacimiento() + "','" + super.getFoto_perfil() + "','" + super.getEdad() + "')";
        if (conn.accion(sql) == null) {
            JOptionPane.showMessageDialog(null, "SE HA REALIZADO EL INGRESO CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO DE CLIENTES");
        }
    }

    public void ELIMINARADMIN() throws SQLException {
        String sql = "DELETE FROM public.administrador\n"
                + "	WHERE id_admin=" + getID_admin() + "";
        if (conn.accion(sql) == null) {
            JOptionPane.showMessageDialog(null, "EL ADMINISTRADOR FUE ELIMINADO");
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL REGISTRO");
        }
    }

    public int login() throws SQLException {
        int retorno;
        String loggin = "SELECT * FROM ADMINISTRADOR WHERE cedula_admin = '" + super.getCedula() + "' and contraseña_admin = '" + super.getPassword() + "'";
        ResultSet resulset = conn.Consulta(loggin);
        if (!resulset.next()) {
            retorno = 0;
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public ArrayList ListarAdministrador() throws SQLException {
        String script = "SELECT * FROM ADMINISTRADOR  ORDER BY id_admin";
        ResultSet contenedor = conn.Consulta(script);
        ArrayList retorno = new ArrayList();
        while (contenedor.next()) {
            Administrador insertar = new Administrador();
            insertar.setID_admin(contenedor.getInt("id_admin"));
            insertar.setCedula(contenedor.getString("cedula_admin"));
            insertar.setPrimerNombre(contenedor.getString("prim_nom_admin"));
            insertar.setNombreApellido(contenedor.getString("prim_apell_admin"));
            insertar.setEdad(contenedor.getInt("edad_admin"));
            insertar.setTelefono(contenedor.getString("telefono_admin"));
            insertar.setCorre(contenedor.getString("correo_admin"));
            retorno.add(insertar);
        }
        return retorno;
    }

    public ArrayList buscarAdmin() throws SQLException {
        String sql = "SELECT * FROM ADMINISTRADOR WHERE  cedula_admin='" + super.getCedula() + "'";
        ArrayList registros = new ArrayList();
        ResultSet contenedor = conn.Consulta(sql);
        while (contenedor.next()) {
            Administrador insertar = new Administrador();
            insertar.setID_admin(contenedor.getInt("id_admin"));
            insertar.setCedula(contenedor.getString("cedula_admin"));
            insertar.setPrimerNombre(contenedor.getString("prim_nom_admin"));
            insertar.setNombreApellido(contenedor.getString("prim_apell_admin"));
            insertar.setEdad(contenedor.getInt("edad_admin"));
            insertar.setTelefono(contenedor.getString("telefono_admin"));
            insertar.setCorre(contenedor.getString("correo_admin"));
            registros.add(insertar);
        }
        return registros;
    }

    public void ModificarAdministrador() throws SQLException {
        String sql = "UPDATE public.administrador\n"
                + "SET  \"contraseña_admin\"='" + super.getPassword() + "', prim_nom_admin=UPPER('" + super.getPrimerNombre() + "'), seg_nom_admin=UPPER('" + super.getSegundoNombre() + "'), prim_apell_admin=UPPER('" + super.getNombreApellido() + "'), seg_apell_admin=UPPER('" + super.getSegundoApellido() + "'), genero_admin='" + super.getGenero() + "', fecha_nacimiento='" + super.getFecha_nacimiento() + "', correo_admin='" + super.getCorre() + "', telefono_admin='" + super.getTelefono() + "', foto_admin='" + super.getFoto_perfil() + "', edad_admin='" + super.getEdad() + "'\n"
                + "WHERE cedula_admin='" + super.getCedula() + "'";
        conn.accion(sql);
    }
}
