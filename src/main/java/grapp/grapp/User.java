package grapp.grapp;

public class User
{
    private String nombre,apellidos,contrasenia, email;
    public User(){
    }
    public User(String nombre, String apellidos, String contrasenia, String email, Boolean recuerdame) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}