/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class abogado extends Persona{
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

    public ArrayList Listar() throws SQLException{
        String script = "SELECT * FROM ABOGADO";
        ResultSet contenedor = conexion.Consulta(script);
        ArrayList retorno = new ArrayList();
        while(contenedor.next()){
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
}
