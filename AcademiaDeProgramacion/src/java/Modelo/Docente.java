
package Modelo;


public class Docente {
    private int idDocente;
    private String nombre;
    private String apellido;
    private String legajo;
    private String correoInstitucional;

    public Docente(int idDocente, String nombre, String apellido, String legajo, String correoInstitucional) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.correoInstitucional = correoInstitucional;
    }

    public Docente(String nombre, String apellido, String legajo, String correoInstitucional) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.correoInstitucional = correoInstitucional;
    }
   public Docente(int idDocente,String Docente) {
       this.idDocente = idDocente;
       this.nombre = Docente;
    }
    public Docente() {
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    @Override
    public String toString() {
        return "Docente{" + "idDocente=" + idDocente + ", nombre=" + nombre + ", apellido=" + apellido + ", legajo=" + legajo + ", correoInstitucional=" + correoInstitucional + '}';
    }
    
}
