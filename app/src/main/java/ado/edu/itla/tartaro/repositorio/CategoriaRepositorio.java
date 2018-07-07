package ado.edu.itla.tartaro.repositorio;

import java.util.List;

import ado.edu.itla.tartaro.entidad.Categoria;

public interface CategoriaRepositorio {

    public boolean guardar(Categoria categoria);

    Categoria buscar(int id);
    List<Categoria> buscar(String buscar);

    }
