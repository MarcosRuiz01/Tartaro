package ado.edu.itla.tartaro.entidad;

public class Usuarios {

    public enum TipoUsuario{
        NORMAL,
        TECNICO

    }

    private Integer id;
    private String nombre;
    private  String email;
    private  String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
