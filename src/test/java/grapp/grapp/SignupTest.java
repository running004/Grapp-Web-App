package grapp.grapp;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class SignupTest {

	/*@Mock
    private User usuarioValido;
    @Mock
    private User usuarioNoValido;

    @InjectMocks
    private appController controller;
    private MockMvc mockMvc;


	
    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(usuarioValido.validarMail()).thenReturn(true);
        when(usuarioNoValido.validarMail()).thenReturn(false);
        when(usuarioValido.comprobarDatos()).thenReturn(null);
        when(usuarioNoValido.comprobarDatos()).thenReturn("Completa todos los campos");
    }

    @Test
	public void InsertValido()throws Exception{
        User u = new User();
        u.setEmail("1");

        Gson gson = new Gson();
        String json = gson.toJson(u);

        mockMvc.perform(MockMvcRequestBuilders.post("/signup").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(MockMvcResultMatchers.view().name("login.html"));

    }
    */

    @Test
    public void usuarioValido(){
        
        User usuarioValido = new User("elmillor@payaso.es", "12345678", "12345678");
        assertEquals(null, usuarioValido.comprobarDatos());
    }

    @Test
    public void usuarioNoValido(){
        User correoMal = new User("ae", "12345678", "12345678");
        User contraseniaMal = new User("elmillor@payaso.cum", "123", "123");
        User contraseniaNoCoincide = new User("elmillor@payaso.cum", "12345678", "123987654");
        assertNotEquals(null, correoMal.comprobarDatos());
        assertNotEquals(null, contraseniaMal.comprobarDatos());
        assertNotEquals(null, contraseniaNoCoincide.comprobarDatos());
    }
    
}
