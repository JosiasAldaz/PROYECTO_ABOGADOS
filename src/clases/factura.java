/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class factura {
    private int FK_cliente;
    private int FK_abg;
    private LocalDate fecha;
    private double sub_total;
    private final double IVA = 0.14;
    private int FK_id_encabezado;
    private double total;

    PostgresConexion conn = new PostgresConexion();
    
    public int getFK_cliente() {
        return FK_cliente;
    }

    public void setFK_cliente(int FK_cliente) {
        this.FK_cliente = FK_cliente;
    }

    public int getFK_abg() {
        return FK_abg;
    }

    public void setFK_abg(int FK_abg) {
        this.FK_abg = FK_abg;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public int getFK_id_encabezado() {
        return FK_id_encabezado;
    }

    public void setFK_id_encabezado(int FK_id_encabezado) {
        this.FK_id_encabezado = FK_id_encabezado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void ingresarFACTURA() throws SQLException{
        String sql = "INSERT INTO encabe_fact (fk_id_cli,fk_id_abg,fecha_fact) VALUES ("+getFK_cliente()+","+getFK_abg()+",'"+getFecha()+"')";
        conn.accion(sql);
    }
    
    public int ID_ENCA() throws SQLException{
        String sql = "SELECT  id_encabezado FROM encabe_fact"
                + " WHERE fk_id_cli = "+getFK_cliente()+ " AND fk_id_abg = "+getFK_abg()+" AND fecha_fact = '"+getFecha()+"'";
        ResultSet contenedor = conn.Consulta(sql);
        int retorno =0;
        while(contenedor.next()){
            retorno = contenedor.getInt("id_encabezado");
        }
        return retorno;
    }
    
    public double calculartotal(){
        double total = getSub_total()+(getSub_total()*IVA);
        return total;
    }
    
    public void cuerpofact() throws SQLException{
        String sql = "INSERT INTO detalle_fact (sub_total,iva,fk_enc_fact,total) VALUES("+getSub_total()+","+IVA+","+getFK_id_encabezado()+","+getTotal()+")";
        if(conn.accion(sql) == null){
            
        }else{
            JOptionPane.showMessageDialog(null,"HA OCURRIO UN ERROR EN EL DETALLE DE FACTURA");
        }
        
    }
}
