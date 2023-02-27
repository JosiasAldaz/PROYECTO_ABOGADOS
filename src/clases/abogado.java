/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.Persona;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class abogado extends Persona{
    private int cod_abogado;
    private double cost_hora;
    private boolean gratuidad;
    private String titulo;
    private String maestria;
    private String doctorado;
    private String phd;
    private int codigo_asistente;
    

    public abogado() {
    }

    public abogado(int cod_abogado, double cost_hora, boolean gratuidad, String titulo, String maestria, String doctorado, String phd, int codigo_asistente) {
        this.cod_abogado = cod_abogado;
        this.cost_hora = cost_hora;
        this.gratuidad = gratuidad;
        this.titulo = titulo;
        this.maestria = maestria;
        this.doctorado = doctorado;
        this.phd = phd;
        this.codigo_asistente = codigo_asistente;
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

    public String getMaestria() {
        return maestria;
    }

    public void setMaestria(String maestria) {
        this.maestria = maestria;
    }

    public String getDoctorado() {
        return doctorado;
    }

    public void setDoctorado(String doctorado) {
        this.doctorado = doctorado;
    }

    public String getPhd() {
        return phd;
    }

    public void setPhd(String phd) {
        this.phd = phd;
    }

    public int getCodigo_asistente() {
        return codigo_asistente;
    }

    public void setCodigo_asistente(int codigo_asistente) {
        this.codigo_asistente = codigo_asistente;
    }

    @Override
    public String toString() {
        return "abogado{" + "cod_abogado=" + cod_abogado + ", cost_hora=" + cost_hora + ", gratuidad=" + gratuidad + ", titulo=" + titulo + ", maestria=" + maestria + ", doctorado=" + doctorado + ", phd=" + phd + ", codigo_asistente=" + codigo_asistente + '}';
    }
    
}
