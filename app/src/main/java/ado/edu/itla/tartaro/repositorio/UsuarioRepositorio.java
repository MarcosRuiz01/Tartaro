package ado.edu.itla.tartaro.repositorio;

import java.util.List;

import ado.edu.itla.tartaro.entidad.Usuario;

public interface UsuarioRepositorio {

    boolean guardar(Usuario user);
    Usuario buscar(String nombre);
    List<Usuario> buscarTecnicos();

}
