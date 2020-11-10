package Modelo;

public class ReporteCinco {
    private String alumno;
    private float totalDescuento;

    public ReporteCinco(String alumno, float totalDescuento) {
        this.alumno = alumno;
        this.totalDescuento = totalDescuento;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    @Override
    public String toString() {
        return "ReporteCinco{" + "alumno=" + alumno + ", totalDescuento=" + totalDescuento + '}';
    }
}
