package grapp.grapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnitTestUser {

    @Test
    public void comprobarDatosTest(){
        User usuario = new User("xd@loles.com", "aaaaaaaa", "aaaaaaaa");
        boolean correcto = usuario.comprobarDatos();
        assertEquals(true, correcto);
    }
	
    
}
