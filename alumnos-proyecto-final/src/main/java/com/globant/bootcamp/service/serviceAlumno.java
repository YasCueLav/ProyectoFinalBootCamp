/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.service;

import com.globant.bootcamp.client.GestorAlumnos;
import com.globant.bootcamp.domain.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

import javax.ws.rs.*;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yasmin
 */
@Component
@Path("/serviceAlumno")
@Consumes("application/json")
@Produces("application/json")
public class serviceAlumno {
    private final DataSource dataSource;
    Connection conn;
    
    Map<Integer, Alumno> alumno;
    Alumno a;
    
    @Autowired
    public serviceAlumno(DataSource dataSource) {
        this.dataSource = dataSource;
        getAllAlumno();
    }
    
    @GET
    private Map getAllAlumno() {
/*        ArrayList<Alumno> lista = new ArrayList<>();
        ga = new GestorAlumnos();
        lista = (ArrayList<Alumno>) ga.obtenerAlumnos();
        for (Alumno alu : lista) {
            alumno = new HashMap<>();
            alumno.put(alu.getLegajo(), alu);
        }
        return alumno;
*/
        //List<Alumno> lista = new ArrayList<>();
            try{
                conn = this.dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet query = stmt.executeQuery("Select * from Alumnos");
                while (query.next()){
                    //Alumno a = new Alumno();
                    a.setIdAlumno(query.getInt("id_alumno"));
                    a.setLegajo(query.getInt("legajo"));
                    a.setNombre(query.getString("nombre"));
                    a.setApellido(query.getString("apellido"));
                    a.setDocumento(query.getInt("documento"));
                    a.setFechaNace(query.getString("fecha_nacimiento"));
                    //lista.add(a);
                    alumno.put(a.getLegajo(), a);
                }
                query.close();
                stmt.close();
                conn.close();
            }catch(SQLException e){
               Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, e);
            }
        //return lista;
        return alumno;
    }
    
    @GET
    @Path("/getOne/{legajo}")
    private Alumno getOneAlumno(@PathParam("legajo") int legajo) {
//        a = ga.obtenerAlumnos(legajo);
//        return a;
//        Alumno a = new Alumno();
        try{
            Connection conn = this.dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from Alumnos where legajo = ?");
            stmt.setInt(1, legajo);
            ResultSet query = stmt.executeQuery();
            if(query.next()){
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setLegajo(query.getInt("legajo"));
                a.setNombre(query.getString("nombre"));
                a.setApellido(query.getString("apellido"));
                a.setDocumento(query.getInt("documento"));
                a.setFechaNace(query.getString("fecha_nacimiento"));
            }
            query.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return a;
    }
    
    @POST
    @Path("/new")
    private void newAlumno (Alumno al) {
       /* boolean agrego;
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
        }*/
        try {
            Connection conn = this.dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO dbo.Alumnos(legajo, documento,nombre,apellido,fecha_nacimiento) VALUES (?,?,?,?,?)");
            stmt.setInt(1, al.getLegajo());
            stmt.setString(2, al.getNombre());
            stmt.setString(3, al.getApellido());
            stmt.setInt(4, al.getDocumento());
            stmt.setString(5, al.getFechaNace());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @PUT
    @Path("/update/{leg}")
    private void updateAlumno (Alumno al/*@PathParam("leg") int leg, @QueryParam("legajo") int legajo,
			@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido,
                        @QueryParam("documento") int documento, @QueryParam("fecha") String fecha*/) {
        /*boolean modifico;
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
        }*/
        try {
            Connection conn = this.dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Alumnos SET nombre = ?, apellido = ?, documento = ?, fecha_nacimiento = ? WHERE legajo = ?");
            stmt.setString(1, al.getNombre());
            stmt.setString(2, al.getApellido());
            stmt.setInt(3, al.getDocumento());
            stmt.setString(4, al.getFechaNace());
            stmt.setInt(5, al.getLegajo());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @DELETE
    @Path("/delete/{legajo}")
    private void deleteAlumno (@PathParam("legajo") int legajo) {
        /*boolean elimino;
        String txt;
        elimino = ga.eliminarAlumno(legajo);
        
        if (elimino) {
            txt = "Eliminado";
            return txt;
        }else{
            txt = "No se ha Eliminado";
            return txt;
        }*/
        try {
            Connection conn = this.dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Alumnos WHERE legajo = ?");
            stmt.setInt(1, legajo);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
