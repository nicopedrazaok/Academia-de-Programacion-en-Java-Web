/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

public class CursoDTO {
  public Curso curso;
  public ArrayList<Turno> listaTurno;
  public ArrayList<Docente> listaDocente;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Turno> getListaTurno() {
        return listaTurno;
    }

    public void setListaTurno(ArrayList<Turno> listaTurno) {
        this.listaTurno = listaTurno;
    }

    public ArrayList<Docente> getListaDocente() {
        return listaDocente;
    }

    public void setListaDocente(ArrayList<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }
  
  

}
