/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

/**
 *
 * @author Edisson
 */
public class Usuario extends Persona {

    private String idusuario;
    private String FKestado;
    private String Fkiabogadoasig;
    private String Fkcasoasig;

    public Usuario() {
    }

    public Usuario(String idusuario, String FKestado, String Fkiabogadoasig, String Fkcasoasig) {
        this.idusuario = idusuario;
        this.FKestado = FKestado;
        this.Fkiabogadoasig = Fkiabogadoasig;
        this.Fkcasoasig = Fkcasoasig;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFKestado() {
        return FKestado;
    }

    public void setFKestado(String FKestado) {
        this.FKestado = FKestado;
    }

    public String getFkiabogadoasig() {
        return Fkiabogadoasig;
    }

    public void setFkiabogadoasig(String Fkiabogadoasig) {
        this.Fkiabogadoasig = Fkiabogadoasig;
    }

    public String getFkcasoasig() {
        return Fkcasoasig;
    }

    public void setFkcasoasig(String Fkcasoasig) {
        this.Fkcasoasig = Fkcasoasig;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", FKestado=" + FKestado + ", Fkiabogadoasig=" + Fkiabogadoasig + ", Fkcasoasig=" + Fkcasoasig + '}';
    }

}
