/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.abogado;
import abogados.Modificari_Asistente;
import static abogados.Modificari_Asistente.calleprinci;
import static abogados.Modificari_Asistente.callesecu;
import static abogados.Modificari_Asistente.jPasscontra;
import static abogados.Modificari_Asistente.jPasscontra2;
import static abogados.Modificari_Asistente.jTextcedula;
import static abogados.Modificari_Asistente.jTextcorreo;
import static abogados.modificarAbogado.direccion1;
import static abogados.modificarAbogado.direccion2;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class asistente extends Persona {

    PostgresConexion conn = new PostgresConexion();
    PostgresConexion conexion = new PostgresConexion();

    private int cod_asist;
    private Double sueldo;
    private int experiencia;
    private String titudocu;

    public asistente() {
    }

    public asistente(int cod_asist, Double sueldo, int experiencia, String titudocu, String cedula, String PrimerNombre, String SegundoNombre, String NombreApellido, String SegundoApellido, int edad, char genero, int FK_direccion, String telefono, String password, String corre, String foto_perfil, LocalDateTime fecha_nacimiento) {
        super(cedula, PrimerNombre, SegundoNombre, NombreApellido, SegundoApellido, edad, genero, FK_direccion, telefono, password, corre, foto_perfil, fecha_nacimiento);
        this.cod_asist = cod_asist;
        this.sueldo = sueldo;
        this.experiencia = experiencia;
        this.titudocu = titudocu;
    }

    public int getCod_asist() {
        return cod_asist;
    }

    public void setCod_asist(int cod_asist) {
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

    public ArrayList Listar() throws SQLException {
        String script = "SELECT * FROM ASISTENTE ORDER BY id_asis";
        ResultSet contenedor = conexion.Consulta(script);
        ArrayList retorno = new ArrayList();
        while (contenedor.next()) {
            asistente insertar = new asistente();
            insertar.setCod_asist(contenedor.getInt("id_asis"));
            insertar.setTitudocu(contenedor.getString("titulo_asis"));
            insertar.setExperiencia(contenedor.getInt("years_esperiencia"));
            insertar.setCedula(contenedor.getString("cedula_asis"));
            insertar.setPassword(contenedor.getString("contraseña_asis"));
            insertar.setPrimerNombre(contenedor.getString("prim_nom_asis"));
            insertar.setSegundoNombre(contenedor.getString("seg_nom_asis"));
            insertar.setNombreApellido(contenedor.getString("prim_apell_asis"));
            insertar.setSegundoApellido(contenedor.getString("seg_apell_asis"));
            insertar.setEdad(contenedor.getInt("edad_asis"));
            //insertar.setGenero((char)contenedor.getString("seg_apell_asis"));           
            insertar.setFK_direccion(contenedor.getInt("fk_dir_asis"));
            //insertar.setFecha_nacimiento(contenedor.getString("seg_apell_asis"));          
            insertar.setSueldo(contenedor.getDouble("sueldo_asis"));
            insertar.setTelefono(contenedor.getString("celular"));
            insertar.setCorre(contenedor.getString("email"));
            insertar.setFoto_perfil(contenedor.getString("foto"));
            retorno.add(insertar);
        }
        return retorno;
    }

    public void Ingresar() throws SQLException {
        String sql = "INSERT INTO public.asistente(titulo_asis, years_esperiencia, cedula_asis, contraseña_asis, prim_nom_asis, seg_nom_asis, prim_apell_asis, seg_apell_asis, edad_asis, genero_asis, fk_dir_asis, fecha_inicio, sueldo_asis,celular, email, foto)"
                + "VALUES ('" + getTitudocu() + "','" + getExperiencia() + "','" + super.getCedula() + "', '" + super.getPassword() + "' , '" + super.getPrimerNombre() + "','" + super.getSegundoNombre() + "' , '" + super.getNombreApellido() + "' ,'" + super.getSegundoApellido() + "','" + super.getEdad() + "' , '" + super.getGenero() + "' , '" + super.getFK_direccion() + "' ,'" + super.getFecha_nacimiento() + "' , '" + getSueldo() + "' , '" + super.getTelefono() + "' , '" + super.getCorre() + "' , '" + super.getFoto_perfil() + "')";
        conexion.accion(sql);
    }

    public int login() throws SQLException {
        int retorno;
        String loggin = "SELECT * FROM asistente WHERE cedula_asis = '" + super.getCedula() + "' and contraseña_asis = '" + super.getPassword() + "'";
        ResultSet resulset = conn.Consulta(loggin);
        if (!resulset.next()) {
            retorno = 0;
        } else {
            retorno = 3;
        }
        return retorno;
    }

    public void buscarasistente() throws SQLException {
        String sql = "SELECT * FROM asistente WHERE  cedula_asis='" + super.getCedula() + "'";
        ResultSet contenedor = conexion.Consulta(sql);
        while (contenedor.next()) {
            Modificari_Asistente abrir = new Modificari_Asistente();
            abrir.setVisible(true);
            Modificari_Asistente.jTextcedula.setText(contenedor.getString("cedula_asis"));
            Modificari_Asistente.jTextnom1.setText(contenedor.getString("prim_nom_asis"));
            Modificari_Asistente.jTextnom2.setText(contenedor.getString("seg_nom_asis"));
            Modificari_Asistente.jTextape2.setText(contenedor.getString("prim_apell_asis"));
            Modificari_Asistente.jTextape2.setText(contenedor.getString("seg_apell_asis"));
            Modificari_Asistente.jTextcorreo.setText(contenedor.getString("email"));
            Modificari_Asistente.jTextsueldo.setText(contenedor.getString("sueldo_asis"));
            Modificari_Asistente.jTextcelular.setText(contenedor.getString("celular"));
            Modificari_Asistente.jTxtFldTituloAsistente.setText(contenedor.getString("titulo_asis"));
            Direcciones direc = new Direcciones();
            int k = contenedor.getInt("fk_dir_asis");
            direc.setId_direccion(k);
            String sql1 = "SELECT * FROM public.direcciones WHERE id_direccion='" + direc.getId_direccion() + "'";
            ResultSet contenedor1 = conexion.Consulta(sql1);
            while (contenedor1.next()) {
                direc.setCalle_principal(calleprinci.getText());
                direc.setCalle_secundaria(callesecu.getText());
                direc.setSucursal(false);

            }
        }
    }

    public void Modificar_asistente() throws SQLException {
        String sql = "UPDATE public.asistente SET  titulo_asis='" + getTitudocu() + "', years_esperiencia='" + getExperiencia() + "', prim_nom_asis='" + super.getPrimerNombre() + "', seg_nom_asis='" + super.getSegundoNombre() + "', prim_apell_asis='" + super.getNombreApellido() + "', seg_apell_asis='" + super.getSegundoApellido() + "', edad_asis='" + super.getEdad() + "', genero_asis='" + super.getGenero() + "',  celular='" + super.getTelefono() + "', email='" + super.getCorre() + "', foto='" + super.getFoto_perfil() + "' where cedula_asis='" + super.getCedula() + "'";
        conexion.accion(sql);
    }    
    public void EliminarAsistente() throws SQLException {
        String sql = "DELETE FROM public.asistente\n"
                + "	WHERE id_asis=" + getCod_asist() + "";
          if(conexion.accion(sql) == null){
            JOptionPane.showMessageDialog(null, "La persona fue eliminada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR LA PERSONA DEPENDE DE OTRAS TABLAS");
        }
    }
}
