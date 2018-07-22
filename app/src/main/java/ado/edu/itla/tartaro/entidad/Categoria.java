package ado.edu.itla.tartaro.entidad;

public class Categoria
{

    Integer id;
    String nombre;

    public Categoria(){


    }

    public Categoria(int id, String nombre){
        this.id = id;
        this.nombre = nombre;

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


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Categoria{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

