package grapp.grapp;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class BusquedaPrendaTest {
    
     //prueba de buscar prenda por nombre
     @Test
     @Order(1)
     public void buscarPrendaValida(){
        DataSource data = Connect.getConnect().getDataSource();
        User u = new User("prueba@gmail.es", "12345678", "12345678");
        u.insertUser(data);
        Prenda prenda = new Prenda("camiseta", "prueba@gmail.es", "nosequeponeraqui", "fotodecamiseta");
        prenda.insertPrenda(prenda.getnombre(), prenda.getemailUser(), prenda.getdescripcion(),
             prenda.getfoto(), data);
        BusquedaPrenda busq = new BusquedaPrenda();
        assertEquals("", busq.BuscarPorNombre(prenda.getnombre(), data));
     }
 
     @Test
     @Order(2)
     public void buscarNoPrendaValida(){
        DataSource data = Connect.getConnect().getDataSource();
        Prenda prendaNoValida = new Prenda("camiseta9", "elmillor@payaso.es", "nosequeponeraqui", "fotodecamiseta");
        Prenda userMal = new Prenda("jersey", "noexiste@ucm.es", "nosequeponeraqui", "fotodecamiseta");
        BusquedaPrenda busq = new BusquedaPrenda();
        assertEquals("El formato del nombre de la prenda no es valido", 
            busq.BuscarPorNombre(prendaNoValida.getnombre(), data));
        assertEquals("No existen prendas con este nombre", 
            busq.BuscarPorNombre(userMal.getnombre(), data));
     }

}
