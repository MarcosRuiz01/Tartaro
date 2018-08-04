package ado.edu.itla.tartaro.repositorio.db;

public class EstructuraDb {

    public static final String TABLA_CATEGORIA = "CREATE TABLE categoria (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public static final String TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS usuario (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, email TEXT NOT NULL UNIQUE, password TEXT NOT NULL, tipousuario TEXT NOT NULL)";
    public static final String TABLA_TAREA= "CREATE TABLE IF NOT EXISTS tarea (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, fecha NUMERIC NOT NULL, estado TEXT NOT NULL DEFAULT 'PENDIENTE', categoria_id INTEGER NOT NULL, fecha_completado NUMERIC, usuario_creador_id INTEGER NOT NULL, usuario_asignado_id INTEGER NOT NULL,nombre TEXT NOT NULL,descripcion TEXT)";
    public static final String TABLA_USUARIO_CATEGORIA= "CREATE TABLE IF NOT EXISTS usuario_categoria ( usuario_id INTEGER NOT NULL, categoria_id INTEGER NOT NULL)";
    public static final String BUSQUEDA_ENTRE_TAREA_USUARIO_C = "SELECT t.*, uc.nombre as usuario_creador FROM tarea t INNER JOIN usuario uc ON t.usuario_creador_id = uc.id WHERE t.usuario_asignado_id = ? ";
    public static final String BUSQUEDA_ENTRE_TAREA_USUARIO_A = "SELECT t.*, ua.nombre as usuario_asignado FROM tarea t INNER JOIN usuario ua ON t.usuario_asignado_id = ua.id WHERE t.usuario_creador_id = ? ";
}
