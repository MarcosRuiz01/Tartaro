package ado.edu.itla.tartaro.usuarioNormal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;

public class DetallesTareaUNActivity extends AppCompatActivity {

    private TextView categoria;
    private TextView taskName;
    private TextView fecha;
    private TextView usuarioAsignado;
    private TextView estado;
    private TextView descripcion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea_normal);

//        Tarea item = new Tarea();
//
//        taskName = findViewById(R.id.txtTaskName);
//        categoria = findViewById(R.id.txtCategoria);
//        fecha = findViewById(R.id.fechaTarea);
//        usuarioAsignado = findViewById(R.id.txtUsuarioAsignado);
//        estado = findViewById(R.id.txtEstado);
//        descripcion = findViewById(R.id.txtDescripcion);

//        taskName.setText(item.getNombre());
//        descripcion.setText(item.getDescripcion());
//        categoria.setText(item.getCategoria());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        fecha.setText(sdf.format(item.getFecha()));
//        estado.setText(item.getEstadoTarea().name());
//        usuarioAsignado.setText(item.getUsuarioAsignado().getNombre());


    }

}