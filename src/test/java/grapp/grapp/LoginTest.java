package grapp.grapp;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import javax.sql.DataSource;

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
public class LoginTest{

    private DataSource dataSource;
    
    @Test
    public void usuarioRegistrado(){
        User usuarioRegistrado = new User("elmillor@payaso.es", "12345678", "12345678");
        assertEquals(true, usuarioRegistrado.searchUser(dataSource));
    }

    @Test
    public void usuarioNoRegistrado(){
        User noRegistrado = new User("loquesea@mk.es", "12345678", "12345678");
        assertNotEquals(true, noRegistrado.searchUser(dataSource));

    }
    
}
