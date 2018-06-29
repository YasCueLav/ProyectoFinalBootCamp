/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.service;

import com.globant.bootcamp.client.GestorAlumnos;
import com.globant.bootcamp.domain.Alumno;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yasmin
 */
@Component
@Path("/alumno")
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
    @Path("/alumno/getOneAlumno/{legajo}")
    private Alumno getOneAlumno(@PathParam("legajo") int legajo) {
        a = ga.obtenerAlumnos(legajo);
        return a;
    }
    
    @GET
    @Path("/alumno/deleteAlumno/{legajo}")
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
    
}
