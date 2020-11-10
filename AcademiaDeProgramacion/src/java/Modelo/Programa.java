package Modelo;

public class Programa {

    private int idPrograma;
    private Alumno alumno;
    private String descripcion;
    private String nombrePrograma;
    private int estado;

    public Programa(int idPrograma, Alumno alumno, String descripcion, String nombrePrograma, int estado) {
        this.idPrograma = idPrograma;
        this.alumno = alumno;
        this.nombrePrograma = nombrePrograma;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Programa(Alumno alumno, String descripcion, String nombrePrograma, int estado) {
        this.alumno = alumno;
        this.nombrePrograma = nombrePrograma;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Programa(int idPrograma) {
        this.idPrograma = idPrograma;
      
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Programa{" + "idPrograma=" + idPrograma + ", alumno=" + alumno + ", nombrePrograma=" + nombrePrograma + ", descripcion=" + descripcion + ", habilitado=" + estado + '}';
    }

}
