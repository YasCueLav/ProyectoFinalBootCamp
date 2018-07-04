/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.service;

import com.globant.bootcamp.domain.Alumno;
import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author Yasmin
 */

public class ServiceAlumnoTest {
    serviceAlumno as = new serviceAlumno();
    Alumno alum;
    
    @Test
    public void shouldThrowNotFoundLegajoGetOne (){
        int legajoTest = 9;
        alum = as.getOneAlumno(legajoTest);
        assertNull("El Legajo NO Existe ", alum);
    }
    
}
/*
@Test(expected = FileNotFoundException.class)
public void testReadFile() throws IOException {
 FileReader reader = new FileReader("test.txt");
 reader.read();
 reader.close();
}

@Rule
public ExpectedException thrown = ExpectedException.none();
@Test
public void testReadFile3() throws IOException {
 thrown.expect(IOException.class);
 thrown.expectMessage(startsWith("test.txt (No such file or directory)"));
 FileReader reader = new FileReader("test.txt");
 reader.read();
 reader.close();
}
*/