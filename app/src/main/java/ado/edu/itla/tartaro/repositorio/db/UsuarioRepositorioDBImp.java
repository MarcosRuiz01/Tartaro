package ado.edu.itla.tartaro.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.UsuarioRepositorio;

public class UsuarioRepositorioDBImp implements UsuarioRepositorio {

    private ConexionDb conexionDb;
    private static final String TABLA_NOMBRE = "usuario";
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_PASSWORD = "password";
    private static final String TIPO_USUARIO = "tipousuario";

    public UsuarioRepositorioDBImp(Context context) {
        conexionDb = new ConexionDb(context);
    }

    @Override
    public boolean guardar(Usuario user) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, user.getNombre());
        cv.put(CAMPO_EMAIL, user.getEmail());
        cv.put(CAMPO_PASSWORD, user.getPassword());
        cv.put(TIPO_USUARIO, user.getTipoUsuario().name());


        SQLiteDatabase db = conexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_NOMBRE, null, cv);
        db.close();

        if (id.intValue() > 0) {
            user.setId(id.intValue());
            return true;
        } else {

            return false;
        }
    }

    @Override
    public Usuario buscar(String username) {

        Usuario user = null;

        SQLiteDatabase db = conexionDb.getReadableDatabase();

        String columnas[] = {"id", CAMPO_NOMBRE, CAMPO_EMAIL, CAMPO_PASSWORD, TIPO_USUARIO};

        Cursor cr = db.query(TABLA_NOMBRE, columnas, "email = ?", new String[]{username}, null, null, null, null);

        cr.moveToFirst();

        if (!cr.isAfterLast()) {

            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE));
            int id = cr.getInt(cr.getColumnIndex("id"));
            String email = cr.getString(cr.getColumnIndex(CAMPO_EMAIL));
            String password = cr.getString(cr.getColumnIndex(CAMPO_PASSWORD));
            String tipoUsuario = cr.getString(cr.getColumnIndex(TIPO_USUARIO));

            user = new Usuario();
            user.setId(id);
            user.setTipoUsuario(Usuario.TipoUsuario.valueOf(tipoUsuario));
            user.setNombre(nombre);
            user.setEmail(email);
            user.setPassword(password);


        }
        cr.close();
        db.close();


        return user;
    }

    @Override
    public List<Usuario> buscarTecnicos() {

        List<Usuario> usuarios = new ArrayList<>();

        SQLiteDatabase db = conexionDb.getReadableDatabase();

        String columnas[] = {"id", CAMPO_NOMBRE, CAMPO_EMAIL, CAMPO_PASSWORD, TIPO_USUARIO};

        Cursor cr = db.query(TABLA_NOMBRE, columnas, "tipousuario = ?", new String[]{Usuario.TipoUsuario.TECNICO.name()}, null, null, null, null);

        cr.moveToFirst();

        while (!cr.isAfterLast()) {

            int id = cr.getInt(cr.getColumnIndex("id"));
            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE));
            String email = cr.getString(cr.getColumnIndex(CAMPO_EMAIL));
            String password = cr.getString(cr.getColumnIndex(CAMPO_PASSWORD));
            String tipoUsuario = cr.getString(cr.getColumnIndex(TIPO_USUARIO));

            Usuario user = new Usuario();
            user.setId(id);
            user.setTipoUsuario(Usuario.TipoUsuario.valueOf(tipoUsuario));
            user.setNombre(nombre);
            user.setEmail(email);
            user.setPassword(password);
            usuarios.add(user);

            cr.moveToNext();
        }
        cr.close();
        db.close();

        return usuarios;

    }
}
