/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;


public class NotaDTO {
  public Nota nota;
  public ArrayList<Inscripcion> listaInscripcion;

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public ArrayList<Inscripcion> getListaInscripcion() {
        return listaInscripcion;
    }

    public void setListaInscripcion(ArrayList<Inscripcion> listaInscripcion) {
        this.listaInscripcion = listaInscripcion;
    }
}
