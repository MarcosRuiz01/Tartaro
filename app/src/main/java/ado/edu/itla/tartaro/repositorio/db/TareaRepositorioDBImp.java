package ado.edu.itla.tartaro.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.TareaRepositorio;

public class TareaRepositorioDBImp implements TareaRepositorio {

    private ConexionDb conexionDb;
    private static final String TABLA_NOMBRE= "Tarea";
    private static final String CAMPO_NOMBRE= "nombre";
    private static final String CAMPO_DESCRIPCION= "descripcion";
    private static final String CAMPO_USUARIO_CREADOR= "usuario_creador_id";
    private static final String CAMPO_USUARIO_ASIGNADO= "usuario_asignado_id";
    private static final String CAMPO_ESTADO= "estado";
    private static final String CAMPO_CATEGORIA_ID= "categoria_id";
    private static final String CAMPO_FECHA= "fecha";
    private static final String CAMPO_FECHA_COMPLETADO= "fecha_completado";

    public TareaRepositorioDBImp (Context context){
        conexionDb = new ConexionDb(context);
    }


    @Override
    public boolean guardar(Tarea tarea) {

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, tarea.getNombre());
        cv.put(CAMPO_DESCRIPCION, tarea.getDescripcion());
        cv.put(CAMPO_USUARIO_CREADOR, String.valueOf(tarea.getUsuarioCreador()));
        cv.put(CAMPO_USUARIO_ASIGNADO, String.valueOf(tarea.getUsuarioAsignado()));
        cv.put(CAMPO_ESTADO, tarea.getEstadoTarea().name());
        cv.put(CAMPO_FECHA, tarea.getFecha().getTime());


        SQLiteDatabase db = conexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_NOMBRE, null, cv);
        db.close();

        if(id.intValue()>0){
            tarea.setId(id.intValue());
            return true;
        }else {

            return false;
        }
    }

    @Override
    public Tarea buscar(String task) {

        Tarea tarea = null;

        SQLiteDatabase db = conexionDb.getReadableDatabase();

        String columnas[] = {CAMPO_NOMBRE, CAMPO_DESCRIPCION, CAMPO_ESTADO, CAMPO_FECHA,
                CAMPO_USUARIO_CREADOR, CAMPO_USUARIO_ASIGNADO, CAMPO_FECHA_COMPLETADO, CAMPO_CATEGORIA_ID};

        Cursor cr = db.query(TABLA_NOMBRE, columnas, "email = ?" , new String[]{task},null,null,null,null);

        cr.moveToFirst();

        if (!cr.isAfterLast()){

            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE));
            String descripcion = cr.getString(cr.getColumnIndex(CAMPO_DESCRIPCION));
            String estado = cr.getString(cr.getColumnIndex(CAMPO_ESTADO));
            Long fecha = cr.getLong(cr.getColumnIndex(CAMPO_FECHA));
            Long fechaCompletado = cr.getLong(cr.getColumnIndex(CAMPO_FECHA_COMPLETADO));

            tarea = new Tarea();
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);
            tarea.setEstadoTarea(Tarea.EstadoTarea.valueOf(estado));
            tarea.setFecha(new Date(fecha));
            if(fechaCompletado!=null){

                tarea.setFechaCompletado(new Date(fechaCompletado));
            }



        }
        cr.close();
        db.close();


        return tarea;
    }

    @Override
    public Tarea buscar(int id) {
        return null;
    }

    @Override
    public List<Tarea> buscarAsignadaA(Usuario usuario) {

        List<Tarea> tareas = new ArrayList<>();

        SQLiteDatabase db = conexionDb.getReadableDatabase();

        String columnas[] = {CAMPO_NOMBRE, CAMPO_DESCRIPCION, CAMPO_ESTADO, CAMPO_FECHA,
                CAMPO_USUARIO_CREADOR, CAMPO_USUARIO_ASIGNADO, CAMPO_FECHA_COMPLETADO, CAMPO_CATEGORIA_ID};

        Cursor cr = db.rawQuery(EstructuraDb.BUSQUEDA_ENTRE_TAREA_USUARIO_C,new String []{usuario.getId().toString()} );


        cr.moveToFirst();

        while (!cr.isAfterLast()){

            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE));
            String descripcion = cr.getString(cr.getColumnIndex(CAMPO_DESCRIPCION));
            String estado = cr.getString(cr.getColumnIndex(CAMPO_ESTADO));
            Long fecha = cr.getLong(cr.getColumnIndex(CAMPO_FECHA));
            Integer usuarioCreadorID = cr.getInt(cr.getColumnIndex(CAMPO_USUARIO_CREADOR));
            String usuarioCreadorNombre = cr.getString(cr.getColumnIndex("usuario_creador"));
            Long fechaCompletado = cr.getLong(cr.getColumnIndex(CAMPO_FECHA_COMPLETADO));
            Usuario uc = new Usuario();

            uc.setId(usuarioCreadorID);
            uc.setNombre(usuarioCreadorNombre);

            Tarea tarea = new Tarea();
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);
            tarea.setEstadoTarea(Tarea.EstadoTarea.valueOf(estado));
            tarea.setFecha(new Date(fecha));
            tarea.setUsuarioCreador(uc);
            tarea.setUsuarioAsignado(usuario);

            if(fechaCompletado!=null){

                tarea.setFechaCompletado(new Date(fechaCompletado));
            }
            tareas.add(tarea);

            cr.moveToNext();
        }
        cr.close();
        db.close();

        return tareas;
    }

    @Override
    public List<Tarea> buscarCreadaPor(Usuario usuario) {


        List<Tarea> tareas = new ArrayList<>();

        SQLiteDatabase db = conexionDb.getReadableDatabase();

        String columnas[] = {CAMPO_NOMBRE, CAMPO_DESCRIPCION, CAMPO_ESTADO, CAMPO_FECHA, CAMPO_USUARIO_CREADOR, CAMPO_USUARIO_ASIGNADO, CAMPO_FECHA_COMPLETADO, CAMPO_CATEGORIA_ID};

        Cursor cr = db.rawQuery(EstructuraDb.BUSQUEDA_ENTRE_TAREA_USUARIO_A,new String []{usuario.getId().toString()} );


        cr.moveToFirst();

        while (!cr.isAfterLast()){

            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE));
            String descripcion = cr.getString(cr.getColumnIndex(CAMPO_DESCRIPCION));
            String estado = cr.getString(cr.getColumnIndex(CAMPO_ESTADO));
            Long fecha = cr.getLong(cr.getColumnIndex(CAMPO_FECHA));
            Integer usuarioCreadorID = cr.getInt(cr.getColumnIndex(CAMPO_USUARIO_CREADOR));
            String usuarioCreadorNombre = cr.getString(cr.getColumnIndex("usuario_creador"));
            Long fechaCompletado = cr.getLong(cr.getColumnIndex(CAMPO_FECHA_COMPLETADO));
            Usuario uc = new Usuario();

            uc.setId(usuarioCreadorID);
            uc.setNombre(usuarioCreadorNombre);

            Tarea tarea = new Tarea();
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);
            tarea.setEstadoTarea(Tarea.EstadoTarea.valueOf(estado));
            tarea.setFecha(new Date(fecha));
            tarea.setUsuarioCreador(uc);
            tarea.setUsuarioAsignado(usuario);

            if(fechaCompletado!=null){

                tarea.setFechaCompletado(new Date(fechaCompletado));
            }
            tareas.add(tarea);

            cr.moveToNext();
        }
        cr.close();
        db.close();
        return tareas;
    }
}
