/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.client;
/*
import javax.sql.DataSource;


import com.globant.bootcamp.domain.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;*/

/**
 *
 * @author Yasmin
 
@Component*/
public class GestorAlumnos {
 /*   AccesoDatos ad;
//    Connection tesConnection;
//    Connection conn;
    
    private final DataSource dataSource;
    
    //@Autowired
    public GestorAlumnos(DataSource dataSource) {
        this.dataSource=dataSource;
//        tesConnection = ad.getConn();
//        AccesoDatos ad = new AccesoDatos();
//        try {
//            tesConnection = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
    }
    
//    public GestorAlumnos() {
//    }
    
    public List<Alumno> obtenerAlumnos (){ 
        List<Alumno> lista = new ArrayList<>();
            try{
                Connection conn = this.dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet query = stmt.executeQuery("Select * from Alumnos");
                while (query.next()){
                    Alumno a = new Alumno();
                    a.setIdAlumno(query.getInt("id_alumno"));
                    a.setLegajo(query.getInt("legajo"));
                    a.setNombre(query.getString("nombre"));
                    a.setApellido(query.getString("apellido"));
                    a.setDocumento(query.getInt("documento"));
                    a.setFechaNace(query.getString("fecha_nacimiento"));
                    lista.add(a);
                }
                query.close();
                stmt.close();
                conn.close();
            }catch(SQLException e){
               Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, e);
            }
        return lista;
    }
//    public ArrayList<Alumno> obtenerAlumnos (){ 
//        ArrayList<Alumno> lista = new ArrayList<>();
//        if (tesConnection != null) {
//            try{
//                Statement stmt = tesConnection.createStatement();
//                ResultSet query = stmt.executeQuery("Select * from Alumnos");
//                while (query.next()){
//                    Alumno a = new Alumno();
//                    a.setIdAlumno(query.getInt("id_alumno"));
//                    a.setLegajo(query.getInt("legajo"));
//                    a.setNombre(query.getString("nombre"));
//                    a.setApellido(query.getString("apellido"));
//                    a.setDocumento(query.getInt("documento"));
//                    a.setFechaNace(query.getString("fecha_nacimiento"));
//                    lista.add(a);
//                }
//                query.close();
//                stmt.close();
//                tesConnection.close();
//            }catch(SQLException e){
//                System.out.println(e);
//            }
//        }else{
//            System.out.println("No hay Coneccion");
//        }
//     
//        return lista;
//    }
    
    public Alumno obtenerAlumnos (int legajo){
        Alumno a = new Alumno();
        try{
            PreparedStatement stmt = tesConnection.prepareStatement("select * from Alumnos where legajo = ?");
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
            tesConnection.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return a;
    }
    
    public boolean nuevoAlumno (Alumno a) {
        boolean agregar = true;
        try {
            PreparedStatement stmt = tesConnection.prepareStatement("INSERT INTO dbo.Alumnos(legajo, documento,nombre,apellido,fecha_nacimiento) VALUES (?,?,?,?,?)");
            stmt.setInt(1, a.getLegajo());
            stmt.setString(2, a.getNombre());
            stmt.setString(3, a.getApellido());
            stmt.setInt(4, a.getDocumento());
            stmt.setString(5, a.getFechaNace());
            stmt.executeUpdate();
            stmt.close();
            tesConnection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            agregar = false;
        }
        return agregar;
    }
    
    public boolean modificarAlumno (Alumno a) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = tesConnection.prepareStatement("UPDATE Alumnos SET nombre = ?, apellido = ?, documento = ?, fecha_nacimiento = ? WHERE legajo = ?");
            //stmt.setInt(1, a.getLegajo());
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getApellido());
            stmt.setInt(3, a.getDocumento());
            stmt.setString(4, a.getFechaNace());
            stmt.setInt(5, a.getLegajo());
            //stmt.setInt(6, a.getIdAlumno());
            stmt.executeUpdate();
            stmt.close();
            tesConnection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    
    public boolean eliminarAlumno (int leg) {
        boolean eliminar = true;
        try {
            PreparedStatement stmt = tesConnection.prepareStatement("DELETE FROM Alumnos WHERE legajo = ?");
            stmt.setInt(1, leg);
            stmt.executeUpdate();
            stmt.close();
            tesConnection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            eliminar = false;
        }
        return eliminar;
    }*/
}