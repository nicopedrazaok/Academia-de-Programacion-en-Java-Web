package Modelo;

public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Curso curso;
    private String fechaInscripcion;
    private String legajo;
    private Turno turno;
    private Promocion promocion;
    private double precioTotal;

    public Inscripcion(int idInscripcion, Alumno alumno, Curso curso, String fechaInscripcion,String legajo, Turno turno, Promocion promocion, double precioTotal) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
        this.legajo = legajo;
        this.turno = turno;
        this.promocion = promocion;
        this.precioTotal = precioTotal;
    }

    public Inscripcion(Alumno alumno, Curso curso, String fechaInscripcion,String legajo,Turno turno, Promocion promocion, double precioTotal) {
        this.alumno = alumno;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
        this.legajo = legajo;
        this.turno = turno;
        this.promocion = promocion;
        this.precioTotal = precioTotal;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", curso=" + curso + ", fechaInscripcion=" + fechaInscripcion + ", legajo=" + legajo + ", turno=" + turno + ", promocion=" + promocion + ", precioTotal=" + precioTotal + '}';
    }
}
