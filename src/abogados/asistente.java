/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class asistente extends abogado{
    private int cod_asist;

    public asistente() {
        super();
    }

    public asistente(int cod_asist) {
        this.cod_asist = cod_asist;
    }

    public int getCod_asist() {
        return cod_asist;
    }

    public void setCod_asist(int cod_asist) {
        this.cod_asist = cod_asist;
    }
    
    
}
