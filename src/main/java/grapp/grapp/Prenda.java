package grapp.grapp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prenda
{
    private String nombreUsuario, foto;
    public Prenda(){
    }
    public Prenda(String nombreUsuario, String foto) {
        this.nombreUsuario = nombreUsuario;
        this.foto = foto;
        /*this.nombreUsuario = nombreUsuario;
        this.apellidos = apellidos;*/
    }

    public String getnombreUsuario() {
        return nombreUsuario;
    }
    public String getfoto() {
        return foto;
    }
    public void setfoto(String foto) {
        this.foto = foto;
    }
    
    public void setnombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    /*
    public Boolean login(String nombreUsuario, String foto){
        return this.nombreUsuario.equals(nombreUsuario) && this.foto.equals(foto);
    }
*/
    public String hashfoto(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
	}
    /*
    public String insertUser(String nombreUsuario, String foto, DataSource dataSource){
        try (Connection c = dataSource.getConnection()) {
            Statement stmt = c.createStatement();
            stmt.executeQuery("INSERT INTO USUARIOS VALUES ("+ nombreUsuario + ", " + hashfoto(foto) +")");
            return "Usuario insertado correctamente";
        } catch(Exception e){
            return "Fallo al insertar usuario, recuerde que debe ser un correo válido y la contraseña como mínimo debe tener 8 caracteres";
        }

    }
    public boolean searchUser(String nombreUsuario, String foto, DataSource dataSource){
        boolean logueado = false;
        try (Connection c = dataSource.getConnection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM USUARIOS WHERE nombreUsuario='"+nombreUsuario+"' AND foto='"+foto+"' ");
            if(rs.next()) logueado = true;
        } catch(Exception e){
            System.out.println("Fallo al loguearse, recuerde que debe ser un correo válido y la contraseña como mínimo debe tener 8 caracteres");
        }
        return logueado;
    }

    
    public boolean searchUserForSingUp(String nombreUsuario, DataSource dataSource){
        boolean existe = false;
        try (Connection c = dataSource.getConnection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM USUARIOS WHERE nombreUsuario='"+nombreUsuario+"' ");
            if(rs.next()) existe = true;
        } catch(Exception e){
            System.out.println("Usuario ya existente");
        }
        return existe;
    }
    */
}