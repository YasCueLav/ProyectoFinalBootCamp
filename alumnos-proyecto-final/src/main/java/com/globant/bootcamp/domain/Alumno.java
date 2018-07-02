/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.domain;



/**
 *
 * @author Yasmin
 */
public class Alumno {
    int idAlumno;
    int legajo;
    String nombre;
    String apellido;
    int documento;
    String fechaNace;

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public String getFechaNace() {
        return fechaNace;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }

    @Override
    public String toString() {
        return "Alumno: idAlumno =" + idAlumno + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", fechaNace=" + fechaNace ;
    }
    
}
