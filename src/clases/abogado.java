package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import abogados.Regi_abogado;
import abogados.administradorInterfaz;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class abogado extends Persona {

    private int cod_abogado;
    private double cost_hora;
    private boolean gratuidad;
    private String titulo;
    private int puntuación;
    PostgresConexion conexion = new PostgresConexion();

    public abogado() {
    }

    public int getCod_abogado() {
        return cod_abogado;
    }

    public void setCod_abogado(int cod_abogado) {
        this.cod_abogado = cod_abogado;
    }

    public double getCost_hora() {
        return cost_hora;
    }

    public void setCost_hora(double cost_hora) {
        this.cost_hora = cost_hora;
    }

    public boolean isGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(boolean gratuidad) {
        this.gratuidad = gratuidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPuntuación() {
        return puntuación;
    }

    public void setPuntuación(int puntuación) {
        this.puntuación = puntuación;
    }

    public abogado(int cod_abogado, double cost_hora, boolean gratuidad, String titulo, int puntuación) {
        this.cod_abogado = cod_abogado;
        this.cost_hora = cost_hora;
        this.gratuidad = gratuidad;
        this.titulo = titulo;
        this.puntuación = puntuación;
    }

    public ArrayList Listar() throws SQLException {
        String script = "SELECT * FROM ABOGADO";
        ResultSet contenedor = conexion.Consulta(script);
        ArrayList retorno = new ArrayList();
        while (contenedor.next()) {
            abogado insertar = new abogado();

            insertar.setCod_abogado(contenedor.getInt("id_abg"));
            insertar.setCedula(contenedor.getString("cedula_abg"));
            insertar.setPrimerNombre(contenedor.getString("prim_nom_abg"));
            insertar.setNombreApellido(contenedor.getString("prim_apell_abg"));
            insertar.setTelefono(contenedor.getString("telefono_abg"));
            insertar.setGratuidad(contenedor.getBoolean("gratuidad"));
            insertar.setCost_hora(contenedor.getDouble("costo_x_horas"));
            retorno.add(insertar);
        }
        return retorno;
    }

    public void Insertar() throws SQLException {
        String sql = "INSERT INTO abogado( titulo_abg, costo_x_horas, gratuidad, cedula_abg,contraseña_abg, prim_nom_abg, seg_nom_abg, prim_apell_abg, seg_apell_abg, fecha_naci_abg, genero_abg, fk_id_direcc_abg, telefono_abg, foto_abg,correo_abg) "
                + "VALUES ('" + getTitulo() + "'," + getCost_hora() + "," + isGratuidad() + ",'" + super.getCedula() + "','" + super.getPassword() + "', UPPER('" + super.getPrimerNombre() + "'), UPPER('" + super.getSegundoNombre() + "'), UPPER('" + super.getNombreApellido() + "'), UPPER('" + super.getSegundoApellido() + "'),'" + super.getFecha_nacimiento() + "','" + super.getGenero() + "','" + super.getFK_direccion() + "','" + super.getTelefono() + "','" + super.getFoto_perfil() + "','" + super.getCorre() + "')";
        conexion.accion(sql);
    }

    public void ELIMINARABOGADO() throws SQLException {
        String sql = "DELETE FROM public.abogado\n"
                + "	WHERE id_abg=" + cod_abogado + "";
        if(conexion.accion(sql) == null){
            JOptionPane.showMessageDialog(null, "La persona fue eliminada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL REGISTRO");
        }
    }

    public int Seleccionar(String select) throws SQLException {
        int ID_abg = 0;
        abogado objeto = new abogado();
        ResultSet parseo = conexion.Consulta(select);
        if (parseo == null) {
            JOptionPane.showMessageDialog(null, "REVISE LA CONSULTA SELECT");
        } else {
            while (parseo.next()) {
                objeto.setCod_abogado(Integer.parseInt(parseo.getString("id_abg")));
            }
            ID_abg = objeto.getCod_abogado();
            return ID_abg;
        }
        return ID_abg;
    }

    public ArrayList buscar() throws SQLException {
        String sql = "SELECT * FROM ABOGADO WHERE  cedula_abg='" + super.getCedula() + "'";
        ArrayList registros = new ArrayList();
        ResultSet contenedor = conexion.Consulta(sql);
        while (contenedor.next()) {
            abogado insertar = new abogado();
            insertar.setCod_abogado(contenedor.getInt("id_abg"));
            insertar.setCedula(contenedor.getString("cedula_abg"));
            insertar.setPrimerNombre(contenedor.getString("prim_nom_abg"));
            insertar.setNombreApellido(contenedor.getString("prim_apell_abg"));
            insertar.setTelefono(contenedor.getString("telefono_abg"));
            insertar.setGratuidad(contenedor.getBoolean("gratuidad"));
            insertar.setEdad(contenedor.getInt("edad_abg"));
            insertar.setCost_hora(contenedor.getDouble("costo_x_horas"));
            registros.add(insertar);
        }
        return registros;
    }

    public void Selecionar() throws SQLException {
        String sql = "SELECT * FROM ABOGADO WHERE  cedula_abg='" + super.getCedula() + "'";
        ArrayList registros1 = new ArrayList();
        ResultSet contenedor = conexion.Consulta(sql);
        while (contenedor.next()) {
            Regi_abogado.nombre1.setText(contenedor.getString("prim_nom_abg"));
        }

    }

    public void Modificar_abogado() throws SQLException {
        String sql = "UPDATE public.abogado SET  titulo_abg='" + getTitulo() + "', costo_x_horas='" + getCost_hora() + "' , gratuidad='" + isGratuidad() + "', prim_nom_abg= UPPER('" + super.getPrimerNombre() + "'), seg_nom_abg= UPPER('" + super.getSegundoNombre() + "'), prim_apell_abg=UPPER('" + super.getNombreApellido() + "'), seg_apell_abg=UPPER('" + super.getSegundoApellido() + "'), edad_abg='" + super.getEdad()+ "', genero_abg='" + super.getGenero() + "',  telefono_abg='" + super.getTelefono() + "', foto_abg='" + super.getFoto_perfil() + "' where cedula_abg='" + super.getCedula() + "'";
        if (conexion.accion(sql) == null) {
            JOptionPane.showMessageDialog(null, "SE HA REALIZADO EL INGRESO CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO DE CLIENTES");
        }
    }
    
    public int login_abogado() throws SQLException {
        int retorno;
        String loggin = "SELECT * FROM abogado WHERE cedula_abg = '" + super.getCedula() + "' and contraseña_abg = '" + super.getPassword() + "'";
        ResultSet resulset = conexion.Consulta(loggin);
        if (!resulset.next()) {
            retorno = 0;
        } else {
            retorno = 2;
        }
        return retorno;
    }
    
    
    public ArrayList buscar_CLI(String parámetro,String segundo) throws SQLException{
        String sql= "SELECT id_abg,foto_abg,cedula_abg,prim_nom_abg,prim_apell_abg,gratuidad,costo_x_horas,telefono_abg,correo_abg FROM abogado WHERE "+parámetro+" LIKE"+"'%"+segundo+"%'";
        ResultSet resulset = conexion.Consulta(sql);
        ArrayList <abogado> incremental = new ArrayList();
        while(resulset.next()){
            abogado usuario = new abogado();
            usuario.setFoto_perfil(resulset.getString("foto_abg"));
            usuario.setCod_abogado(resulset.getInt("id_abg"));
            usuario.setCedula(resulset.getString("cedula_abg"));
            usuario.setPrimerNombre(resulset.getString("prim_nom_abg"));
            usuario.setNombreApellido(resulset.getString("prim_apell_abg"));
            usuario.setGratuidad(resulset.getBoolean("gratuidad"));
            usuario.setCost_hora(Double.parseDouble(String.valueOf(resulset.getInt("costo_x_horas"))));
            usuario.setTelefono(resulset.getString("telefono_abg"));
            usuario.setCorre(resulset.getString("correo_abg"));
            incremental.add(usuario);
        }
        return incremental;
    }
    
    public double precioABG(int id) throws SQLException{
        String sql = "SELECT costo_x_horas FROM abogado WHERE id_abg ="+id;
        ResultSet resulset = conexion.Consulta(sql);
        double retorno =0;
        while(resulset.next()){
            retorno = resulset.getDouble("costo_x_horas");
        }
        return retorno;
        
    }
}