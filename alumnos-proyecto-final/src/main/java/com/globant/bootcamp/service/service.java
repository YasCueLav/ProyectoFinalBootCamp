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
import javax.activation.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    /*private final DataSource ds;
    @Autowired
    public service(DataSource ds) {
        this.ds = ds;
    }
    public service() {
        getAllAlumno();
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
    }*/
    
    /*
    @GET
    private Map getAllAlumno() {
        List<Alumno> lista = new ArrayList<>();
        ga = new GestorAlumnos(ds);
        lista = ga.obtenerAlumnos();
        for (Alumno alu : lista) {
            alumno = new HashMap<>();
            alumno.put(alu.getLegajo(), alu);
        }
        return alumno;
    }
*/
    @GET
//    @Path("/alumno/getAll")
    private Map getAllAlumno() {
        ArrayList<Alumno> lista = new ArrayList<>();
        ga = new GestorAlumnos();
        lista = ga.obtenerAlumnos();
        for (Alumno alu : lista) {
            alumno = new HashMap<>();
            alumno.put(alu.getLegajo(), alu);
        }
        return alumno;
//         return this.init();
    }
    
    
    @GET
//    @Path("/alumno/getOne/{legajo}")
    @Path("/getOne/{legajo}")
    private Alumno getOneAlumno(@PathParam("legajo") int legajo) {
        a = ga.obtenerAlumnos(legajo);
        return a;
    }
    
    @POST
    //@Path("/new/{legajo}&{nombre}&{apellido}&{documento}&{fecha}")
    @Path("/new")
    private String newAlumno (Alumno al/*@PathParam("leg") int leg, @QueryParam("legajo") int legajo,
			@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido,
                        @QueryParam("documento") int documento, @QueryParam("fecha") String fecha*/) {
        boolean agrego;
        String txt;
        
        a.setLegajo(al.getLegajo());
        a.setNombre(al.getNombre());
        a.setApellido(al.getApellido());
        a.setDocumento(al.getDocumento());
        a.setFechaNace(al.getFechaNace());
        
        agrego = ga.nuevoAlumno(a);
        
        if (agrego) {
            txt = "Agregado";
            return txt;
        }else{
            txt = "No se ha Agregado";
            return txt;
        }
    }

    @PUT
//    @Path("/alumno/update/{leg}")
    @Path("/update/{leg}")
    private String updateAlumno (Alumno al/*@PathParam("leg") int leg, @QueryParam("legajo") int legajo,
			@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido,
                        @QueryParam("documento") int documento, @QueryParam("fecha") String fecha*/) {
        boolean modifico;
        String txt;
        
        a.setLegajo(al.getLegajo());
        a.setNombre(al.getNombre());
        a.setApellido(al.getApellido());
        a.setDocumento(al.getDocumento());
        a.setFechaNace(al.getFechaNace());
        
        //Alumno alu = new Alumno();
        //a = ga.obtenerAlumnos(leg);
        
//        alu.setIdAlumno(a.getIdAlumno());
//        alu.setLegajo(legajo);
//        alu.setNombre(nombre);
//        alu.setApellido(apellido);
//        alu.setDocumento(documento);
//        alu.setFechaNace(fecha);
        
//        modifico = ga.modificarAlumno(alu);
          modifico = ga.modificarAlumno(a);
        
        if (modifico) {
            txt = "Modifiado";
            return txt;
        }else{
            txt = "No se ha Modifiado";
            return txt;
        }
    }
    
    @DELETE
//    @Path("/alumno/delete/{legajo}")
    @Path("/delete/{legajo}")
    private String deleteAlumno (@PathParam("legajo") int legajo) {
        boolean elimino;
        String txt;
        elimino = ga.eliminarAlumno(legajo);
        
        if (elimino) {
            txt = "Eliminado";
            return txt;
        }else{
            txt = "No se ha Eliminado";
            return txt;
        }
    }
}
