/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class MOSTRAR_facturas {
    private int ID_fact;
    private int ID_cliente;
    private LocalDate fecha;
    private double subtotal;
    private double total;
    private String nombre;
    private String apellido;
    PostgresConexion conn = new PostgresConexion();

    public int getID_fact() {
        return ID_fact;
    }

    public void setID_fact(int ID_fact) {
        this.ID_fact = ID_fact;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public ArrayList<MOSTRAR_facturas> MOSTRAR_FACTURA() throws SQLException{
        String sql = "SELECT df.id_detalle, df.sub_total, df.total, c.id_clie, c.prim_nom_cli, c.prim_apell_cli, ef.fecha_fact\n" +
"FROM detalle_fact df\n" +
"JOIN encabe_fact ef ON df.fk_enc_fact = ef.id_encabezado\n" +
"JOIN clientes c ON c.id_clie = ef.fk_id_cli;";
        ArrayList<MOSTRAR_facturas> array = new ArrayList();
        ResultSet resulset =conn.Consulta(sql);
        while(resulset.next()){
            MOSTRAR_facturas objeto = new MOSTRAR_facturas();
            objeto.setID_fact(resulset.getInt("id_detalle"));
            objeto.setID_cliente(resulset.getInt("id_clie"));
            objeto.setNombre(resulset.getString("prim_nom_cli"));
            objeto.setApellido(resulset.getString("prim_apell_cli"));
            objeto.setTotal(resulset.getDouble("total"));
            objeto.setSubtotal(resulset.getDouble("sub_total"));
            java.sql.Timestamp fechaTimestamp = resulset.getTimestamp("fecha_fact");
            objeto.setFecha(fechaTimestamp.toLocalDateTime().toLocalDate());
            array.add(objeto);
        }
        return array;
    }
}
