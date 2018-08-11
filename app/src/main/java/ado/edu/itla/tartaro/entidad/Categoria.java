package ado.edu.itla.tartaro.entidad;

import java.io.Serializable;

public class Categoria implements Serializable
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

        return nombre;
    }
}

