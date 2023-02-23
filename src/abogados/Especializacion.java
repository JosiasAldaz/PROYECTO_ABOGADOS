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
public class Especializacion {
    private String especializacion1;
    private String especializacion2;
    private String especializacion3;
    private String especializacion4;
    private String especializacion5;

    public Especializacion() {
    }

    public Especializacion(String especializacion1, String especializacion2, String especializacion3, String especializacion4, String especializacion5) {
        this.especializacion1 = especializacion1;
        this.especializacion2 = especializacion2;
        this.especializacion3 = especializacion3;
        this.especializacion4 = especializacion4;
        this.especializacion5 = especializacion5;
    }

    public String getEspecializacion1() {
        return especializacion1;
    }

    public void setEspecializacion1(String especializacion1) {
        this.especializacion1 = especializacion1;
    }

    public String getEspecializacion2() {
        return especializacion2;
    }

    public void setEspecializacion2(String especializacion2) {
        this.especializacion2 = especializacion2;
    }

    public String getEspecializacion3() {
        return especializacion3;
    }

    public void setEspecializacion3(String especializacion3) {
        this.especializacion3 = especializacion3;
    }

    public String getEspecializacion4() {
        return especializacion4;
    }

    public void setEspecializacion4(String especializacion4) {
        this.especializacion4 = especializacion4;
    }

    public String getEspecializacion5() {
        return especializacion5;
    }

    public void setEspecializacion5(String especializacion5) {
        this.especializacion5 = especializacion5;
    }

    @Override
    public String toString() {
        return "Especializacion{" + "especializacion1=" + especializacion1 + ", especializacion2=" + especializacion2 + ", especializacion3=" + especializacion3 + ", especializacion4=" + especializacion4 + ", especializacion5=" + especializacion5 + '}';
    }
    
}
