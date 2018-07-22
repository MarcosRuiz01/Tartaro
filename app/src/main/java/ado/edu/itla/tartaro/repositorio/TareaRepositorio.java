package ado.edu.itla.tartaro.repositorio;

import java.util.List;

import ado.edu.itla.tartaro.entidad.Tarea;

public interface TareaRepositorio {

    boolean guardar(Tarea tarea);
    Tarea buscar(String nombre);
    Tarea buscar(int id);
    List<Tarea> buscarTarea (String buscar);
}
