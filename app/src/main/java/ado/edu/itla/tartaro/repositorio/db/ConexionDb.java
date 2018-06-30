package ado.edu.itla.tartaro.repositorio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLClientInfoException;

public class ConexionDb extends SQLiteOpenHelper {

    private static final String LOG_TAG = "ConexionDb";
    private static final String NOMBRE_DB = "tartaro.db";
    private static final Integer VERSION_DB = 1;

    public ConexionDb(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "Creando la base de datos.");
        db.execSQL(EstructuraDb.TABLA_CATEGORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }
}
