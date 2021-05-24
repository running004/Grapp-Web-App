package grapp.grapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrendaGR3Test {
   

   //---------------Test unitarios---------------
   
   @Test
   public void ValidarAtributos(){
   
      Prenda ropa = new Prenda("Ropa valida8()","noseque@algo.com", "url ropa", "Descripcion valida");
      assertNull(ropa.comprobarDatos()); 
        
      ropa = new Prenda("Ropa no valida, tamaño del nombre mayor que 50 xxxx","noseque@algo.com", "url ropa", "Descripcion valida");
      assertEquals(ropa.comprobarDatos(), "El nombre no puede tener mas de 50 caracteres."); 

      ropa = new Prenda("Ropa no valida, caracteres incorrecots *+[#","noseque@algo.com", "url ropa", "Descripcion valida");
      assertEquals(ropa.comprobarDatos(), "El nombre contiene caracteres invalido, deben ser letras, numeros y ()");
      
      ropa = new Prenda("Ropa no valida","noseque@algo.com", "url ropa", "Descripcion no valida xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      assertEquals(ropa.comprobarDatos(), "La descripcion no puede tener mas de 280 caracteres."); 
        
   }
}
