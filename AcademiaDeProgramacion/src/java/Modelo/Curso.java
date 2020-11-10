/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Curso {
private int idCurso;
private String nombreCurso;
private Docente docente;
private String duracion;
private String modalidad;
private double precio;

    public Curso(int idCurso, String nombreCurso, Docente docente, String duracion, String modalidad, double precio) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.docente = docente;
        this.duracion = duracion;
        this.modalidad = modalidad;
        this.precio = precio;
    }

    public Curso(String nombreCurso, Docente docente, String duracion, String modalidad, double precio) {
        this.nombreCurso = nombreCurso;
        this.docente = docente;
        this.duracion = duracion;
        this.modalidad = modalidad;
        this.precio = precio;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", docente=" + docente + ", duracion=" + duracion + ", modalidad=" + modalidad + ", precio=" + precio + '}';
    }
}
