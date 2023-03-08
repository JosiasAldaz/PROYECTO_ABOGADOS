/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.abogado;
import java.beans.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class asistente extends abogado {

    private int cod_asist;
    private int cog_caso_asignado;
    private int num_casos;

    public asistente() {
    }

    public asistente(int cod_asist, int cog_caso_asignado, int num_casos) {
        this.cod_asist = cod_asist;
        this.cog_caso_asignado = cog_caso_asignado;
        this.num_casos = num_casos;
    }

    public int getCod_asist() {
        return cod_asist;
    }

    public void setCod_asist(int cod_asist) {
        this.cod_asist = cod_asist;
    }

    public int getCog_caso_asignado() {
        return cog_caso_asignado;
    }

    public void setCog_caso_asignado(int cog_caso_asignado) {
        this.cog_caso_asignado = cog_caso_asignado;
    }

    public int getNum_casos() {
        return num_casos;
    }

    public void setNum_casos(int num_casos) {
        this.num_casos = num_casos;
    }
//
//    @Override
//    public String toString() {
//        return "asistente{" + "cod_asist=" + cod_asist + ", cog_caso_asignado=" + cog_caso_asignado + ", num_casos=" + num_casos + '}';
//    }
}
