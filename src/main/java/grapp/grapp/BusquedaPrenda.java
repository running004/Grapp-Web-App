package grapp.grapp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.sql.DataSource;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BusquedaPrenda
{
    private List<Prenda> miLista ;
    public BusquedaPrenda(){
        miLista = new ArrayList<Prenda>();
    }
    
    public String BuscarPorUsuario(String nombre,DataSource dataSource){ // cambiarlo a strings
        if(validarExisteUsuario(nombre,dataSource)) return "Este usuario no existe";
        if(rellenarPorUsuario(nombre,dataSource)) return "El usuario no tiene subida ninguna prenda";
        // buscar en la tabla de prendas por ese usario y rellenar la lista
         return "";
     }
     public boolean validarExisteUsuario(String emailUser, DataSource dataSource){
        boolean encontrado = false;
        try (Connection c = dataSource.getConnection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM USUARIOS WHERE emailUser='"+emailUser+"' ");
            if(rs.next()) encontrado = true;
        } catch(Exception e){
            System.out.println("No existe este usuario.");
        }
        return encontrado;
    }
    public boolean rellenarPorUsuario(String emailUser, DataSource dataSource){
        boolean encontrado = false;
        try (Connection c = dataSource.getConnection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM PRENDAS WHERE emailUser='"+emailUser+"' ");
            if(rs.next()) encontrado = true;
            
            //rellenar la lista que no seeeee wiiiiii

        } catch(Exception e){
            System.out.println("No existe este usuario.");
        }
        return encontrado;
    }

    
    public Boolean BuscarPorNombre(String nombre, DataSource dataSource){
        boolean existe = false;
        try (Connection c = dataSource.getConnection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM PRENDAS WHERE nombre="+nombre+" ");
            if(rs.next()){
                if(rs.getInt(1) != 0)
                    existe = true;
            } 
        } catch(Exception e){
            System.out.println("Fallo al buscar la prenda por nombre");
        }
        return existe;
    }
    
    public Boolean BuscarPorUsuario(String nombre){

        return true;
    }
    
    public Boolean BuscarMiArmarioTodo(String nombre){

        return true;
    }
    
    public Boolean BuscarMiArmarioPorNombre(String nombre){

        return true;
    }
}