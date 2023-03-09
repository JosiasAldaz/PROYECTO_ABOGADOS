/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author LENOVO
 */
public class Direcciones {

    private int Id_direccion;
    private String calle_principal;
    private String calle_secundaria;
    private String barrio;
    private boolean sucursal;
    PostgresConexion base = new PostgresConexion();
    conexion_kevin conexion1 = new conexion_kevin();

    public Direcciones(int Id_direccion, String calle_principal, String calle_secundaria, String barrio) {
        this.Id_direccion = Id_direccion;
        this.calle_principal = calle_principal;
        this.calle_secundaria = calle_secundaria;
        this.barrio = barrio;
    }

    public int getId_direccion() {
        return Id_direccion;
    }

    public void setId_direccion(int Id_direccion) {
        this.Id_direccion = Id_direccion;
    }

    public String getCalle_principal() {
        return calle_principal;
    }

    public void setCalle_principal(String calle_principal) {
        this.calle_principal = calle_principal;
    }

    public String getCalle_secundaria() {
        return calle_secundaria;
    }

    public void setCalle_secundaria(String calle_secundaria) {
        this.calle_secundaria = calle_secundaria;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Direcciones() {
    }

    public boolean getSucursal() {
        return sucursal;
    }

    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }

    public void Ingresar() throws SQLException {
        String sql = "INSERT INTO direcciones(calle_principal,calle_secundaria,sucursal)";
        sql += " VALUES ('" + this.getCalle_principal() + "','" + this.getCalle_secundaria() + "','" + this.getSucursal() + "')";
        base.accion(sql);
    }

    public int Seleccionar(String select) throws SQLException {
        int ID_direccion = 0;
        Direcciones objeto = new Direcciones();
        ResultSet parseo = base.Consulta(select);
        if (parseo == null) {
            JOptionPane.showMessageDialog(null, "REVISE LA CONSULTA SELECT");
        } else {
            while (parseo.next()) {
                objeto.setId_direccion(Integer.parseInt(parseo.getString("id_direccion")));
            }
            ID_direccion = objeto.getId_direccion();
            return ID_direccion;
        }
        return ID_direccion;
    }

    public void Ingresar1() {
        try {
            Connection conexion = conexion1.conectar();
            Statement st = conexion.createStatement();
            String sql = "INSERT INTO direcciones(calle_principal,calle_secundaria,sucursal)";
            sql += " VALUES ('" + getCalle_principal() + "','" + getCalle_secundaria() + "','" + getSucursal() + "')";
            st.execute(sql);
            st.cancel();
            conexion.close();
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTA");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
}
