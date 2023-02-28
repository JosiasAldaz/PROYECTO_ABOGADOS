/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

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
    PostgresConexion base;

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

    public boolean isSucursal() {
        return sucursal;
    }

    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }
    
    
    public void Ingresar(){
        String sql = "INSERT INTO direcciones(calle_principal,calle_secundaria,barrio,sucursal)";
        sql += " VALUES ('"+calle_principal+"','"+calle_secundaria+"','"+barrio+"','"+sucursal+"')";
        if(base.accion(sql) == null){
            
        }else{
            
        }
    }
    
}
