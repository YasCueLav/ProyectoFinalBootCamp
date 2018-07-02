/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.service;

import com.globant.bootcamp.client.GestorAlumnos;
import com.globant.bootcamp.domain.Alumno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.QueryParam;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yasmin
 */
@Component
@Path("/service")
@Consumes("application/json")
@Produces("application/json")
public class service {
    Map<Integer, Alumno> alumno;
    GestorAlumnos ga;
    Alumno a;
     
    public service() {
        this.init();
    }

    private Map init() {
        ArrayList<Alumno> lista = new ArrayList<>();
        ga = new GestorAlumnos();
        lista = ga.obtenerAlumnos();
        for (Alumno alu : lista) {
            alumno = new HashMap<>();
            alumno.put(alu.getLegajo(), alu);
        }
        return alumno;
    }
    
    @GET
    @Path("/alumno/getAll")
    private Map getAllAlumno() {
         return this.init();
    }
    
    
    @GET
    @Path("/alumno/getOne/{legajo}")
    private Alumno getOneAlumno(@PathParam("legajo") int legajo) {
        a = ga.obtenerAlumnos(legajo);
        return a;
    }
    
    @GET
    @Path("/alumno/delete/{legajo}")
    private String deleteAlumno (@PathParam("legajo") int legajo) {
        boolean elimino;
        String txt;
        a = ga.obtenerAlumnos(legajo);
        elimino = ga.eliminarAlumno(a);
        
        if (elimino) {
            txt = "Eliminado";
            return txt;
        }else{
            txt = "No se ha Eliminado";
            return txt;
        }
    }
    
    @GET
    @Path("/alumno/update/{leg}")
    private String updateAlumno (@PathParam("leg") int leg, @QueryParam("legajo") int legajo,
			@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido,
                        @QueryParam("documento") int documento, @QueryParam("fecha") String fecha) {
        boolean modifico;
        String txt = "";
        
        Alumno alu = new Alumno();
        a = ga.obtenerAlumnos(leg);
        
        alu.setIdAlumno(a.getIdAlumno());
        alu.setLegajo(legajo);
        alu.setNombre(nombre);
        alu.setApellido(apellido);
        alu.setDocumento(documento);
        alu.setFechaNace(fecha);
        
        modifico = ga.modificarAlumno(alu);
        
        if (modifico) {
            txt = "Modifiado";
            return txt;
        }else{
            txt = "No se ha Modifiado";
            return txt;
        }
    }
}
