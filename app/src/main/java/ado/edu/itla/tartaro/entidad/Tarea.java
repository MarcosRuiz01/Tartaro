package ado.edu.itla.tartaro.entidad;

import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {


    public enum EstadoTarea {
        PENDIENTE,
        EN_PROCESO,
        LISTA,
        ELIMINADA
    }

    private Integer id;
    private Date fecha;
    private String nombre;
    private String descripcion;
    private EstadoTarea estadoTarea;
    private Categoria categoria;
    private Usuario usuarioCreador;
    private Usuario usuarioAsignado;
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

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public Date getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre);
        sb.append(", fecha='").append(fecha);
        sb.append(", descripcion='").append(descripcion);
        sb.append(", estado_tarea='").append(estadoTarea);
        sb.append(", categoria='").append(categoria);
        sb.append(", usuario_creador='").append(usuarioCreador);
        sb.append(", usuario_asignado='").append(usuarioAsignado);
        sb.append(", fecha_completado='").append(fechaCompletado).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
