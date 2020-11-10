
package Modelo;


public class ReporteUno {
   private String curso;
   private float facturacionTotal;

    public ReporteUno(String curso, float facturacionTotal) {
        this.curso = curso;
        this.facturacionTotal = facturacionTotal;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float getFacturacionTotal() {
        return facturacionTotal;
    }

    public void setFacturacionTotal(float facturacionTotal) {
        this.facturacionTotal = facturacionTotal;
    }

    @Override
    public String toString() {
        return "ReporteUno{" + "curso=" + curso + ", facturacionTotal=" + facturacionTotal + '}';
    }
}
