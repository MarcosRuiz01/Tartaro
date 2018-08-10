package ado.edu.itla.tartaro.repositorio;

import java.util.List;

import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.entidad.Usuario;

public interface TareaRepositorio {

    boolean guardar(Tarea tarea);
    Tarea buscar(String nombre);
    Tarea buscar(int id);
    List<Tarea> buscarAsignadaA (Usuario usuario);
    List<Tarea> buscarCreadaPor (Usuario usuario);
    List<Tarea> buscarTodas (String buscar);
}
