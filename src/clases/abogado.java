package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
    conexion_kevin nuevo = new conexion_kevin();
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

    public conexion_kevin getNuevo() {
        return nuevo;
    }

    public void setNuevo(conexion_kevin nuevo) {
        this.nuevo = nuevo;
    }

    public PostgresConexion getConexion() {
        return conexion;
    }

    public void setConexion(PostgresConexion conexion) {
        this.conexion = conexion;
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
            insertar.setCedula(contenedor.getString("cedula_abg"));
            insertar.setCod_abogado(Integer.parseInt(contenedor.getString("id_abg")));
            insertar.setPrimerNombre(contenedor.getString("prim_nom_abg"));
            insertar.setNombreApellido(contenedor.getString("prim_ape_abg"));
            insertar.setTelefono(contenedor.getString("telefono_abg"));
            insertar.setGratuidad(contenedor.getBoolean("gratuidad"));

            retorno.add(insertar);
        }
        return retorno;
    }

    public void Insertar() {

        try {
            Connection conexion1 = nuevo.conectar();
            Statement st = conexion1.createStatement();
            String sql = "INSERT INTO public.abogado( titulo_abg, costo_x_horas, gratuidad, cedula_abg, \"contraseña_abg\", prim_nom_abg, seg_nom_abg, prim_apell_abg, seg_apell_abg, edad_abg, genero_abg, fk_id_direcc_abg, telefono_abg, foto_abg)"
                    + "VALUES ('" + getTitulo() + "', '" + getCost_hora() + "','" + isGratuidad() + "', '" + super.getCedula() + "','" + super.getPassword() + "' , '" + super.getPrimerNombre() + "','" + super.getSegundoNombre() + "' , '" + super.getNombreApellido() + "' ,'" + super.getSegundoApellido() + "','" + super.getEdad() + "' , '" + super.getGenero() + "' , '" + super.getFK_direccion() + "' ,'" + super.getTelefono() + "' ,'" + super.getFoto_perfil() + "')";
            st.execute(sql);
            st.cancel();
            conexion1.close();
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);

        }
    }
}
