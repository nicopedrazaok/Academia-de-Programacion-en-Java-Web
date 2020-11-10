/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class InscripcionDTO {
    public Inscripcion inscripcion;
    public ArrayList<Alumno> listaAlumno;
    public ArrayList<Curso> listaCurso;
    public ArrayList<Turno> listaTurno;
    public ArrayList<Promocion> listaPromocion;

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public ArrayList<Alumno> getListaAlumno() {
        return listaAlumno;
    }

    public void setListAlumno(ArrayList<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }

    public ArrayList<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(ArrayList<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public ArrayList<Turno> getListaTurno() {
        return listaTurno;
    }

    public void setListaTurno(ArrayList<Turno> listaTurno) {
        this.listaTurno = listaTurno;
    }

    public ArrayList<Promocion> getListaPromocion() {
        return listaPromocion;
    }

    public void setListaPromocion(ArrayList<Promocion> listaPromocion) {
        this.listaPromocion = listaPromocion;
    }

  
    
}
