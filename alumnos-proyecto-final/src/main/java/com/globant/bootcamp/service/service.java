/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.Alumno;
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
    Map<Alumno, Alumno> alumno;

    public service() {
        
    }

    
    
}
