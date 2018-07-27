package ado.edu.itla.tartaro.entidad;

public class Usuario {


    public enum TipoUsuario {
        NORMAL,
        TECNICO
    }

    Integer id;
    String nombre;
    String email;
    String password;
    TipoUsuario tipoUsuario;


    public Usuario() {

       }

    public Usuario(int id, String nombre, String email, String password, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

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


    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre);
        sb.append(", email='").append(email);
        sb.append(", password='").append(password);
        sb.append(", tipousuario='").append(TipoUsuario.valueOf(tipoUsuario.name())).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
