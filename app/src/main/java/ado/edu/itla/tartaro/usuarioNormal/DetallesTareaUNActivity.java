package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;

public class DetallesTareaUNActivity extends AppCompatActivity {

    private TextView categoria;
    private TextView taskName;
    private TextView fecha;
    private TextView usuarioAsignado;
    private TextView estado;
    private TextView descripcion;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea_normal);


        taskName = findViewById(R.id.txtTaskName);
        categoria = findViewById(R.id.txtCategoria2);
        fecha = findViewById(R.id.fechaTarea2);
        usuarioAsignado = findViewById(R.id.txtUsuarioCreador);
        estado = findViewById(R.id.txtEstado);
        descripcion = findViewById(R.id.txtDescripcion2);


        Intent intent = getIntent();
        Tarea tarea = (Tarea) intent.getSerializableExtra(ListaTareaUNActivity.TAREA_SELECCIONADA);

        if (tarea != null) {
            taskName.setText(tarea.getNombre());
            descripcion.setText(tarea.getDescripcion());
            categoria.setText(tarea.getCategoria().getNombre());
            fecha.setText(SIMPLE_DATE_FORMAT.format(tarea.getFecha()));
            estado.setText(tarea.getEstadoTarea().name());
            usuarioAsignado.setText(tarea.getUsuarioAsignado().getNombre());
            switch (tarea.getEstadoTarea()) {
                case EN_PROCESO:
                    estado.setTextColor(ContextCompat.getColor(this, R.color.PROCESO));
                    break;
                case PENDIENTE:
                    estado.setTextColor(ContextCompat.getColor(this, R.color.PENDIENTE));
                    break;
                case LISTA:
                    estado.setTextColor(ContextCompat.getColor(this, R.color.LISTA));
                    break;
            }

        }

    }

}