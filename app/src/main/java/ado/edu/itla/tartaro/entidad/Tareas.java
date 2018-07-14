package ado.edu.itla.tartaro.entidad;

import java.util.Date;

public class Tareas {


    public enum EstadoTarea {
        PENDIENTE,
        EN_PROCESO,
        LISTA
    }

    private Integer id;
    private Date fecha;
    private String nombre;
    private String descripcion;
    private EstadoTarea estadoTarea;
    private Categoria categoria;
    private Usuarios usuarioCreador;
    private Usuarios usuarioAsignado;
    private Date fechaCompletado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoTarea getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(EstadoTarea estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuarios getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuarios usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuarios getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuarios usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public Date getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }
}
