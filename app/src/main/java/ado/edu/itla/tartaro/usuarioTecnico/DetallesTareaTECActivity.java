package ado.edu.itla.tartaro.usuarioTecnico;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;

public class DetallesTareaTECActivity extends AppCompatActivity {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    Tarea tarea;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea_tecnico);

        TextView categoria;
        TextView taskName;
        TextView fecha;
        TextView usuarioCreador;
        TextView estado;
        TextView descripcion;
        Button btnEstado;
        Button btnEliminar;
        ListView listView;
        final TareaRepositorioDBImp tareaRepo = new TareaRepositorioDBImp(this);

        taskName = findViewById(R.id.txtTaskName2);
        categoria = findViewById(R.id.txtCategoria2);
        fecha = findViewById(R.id.fechaTarea2);
        usuarioCreador = findViewById(R.id.txtUsuarioCreador);
        estado = findViewById(R.id.txtEstadoTask);
        descripcion = findViewById(R.id.txtDescripcion2);
        btnEstado = findViewById(R.id.btn_estado);
        btnEliminar = findViewById(R.id.btn_eliminar);


        Intent intent = getIntent();
        tarea = (Tarea) intent.getSerializableExtra(ListaTareaTECActivity.TAREA_SELECCIONADA);

        if (tarea != null) {
            taskName.setText(tarea.getNombre());
            descripcion.setText(tarea.getDescripcion());
            categoria.setText(tarea.getCategoria().getNombre());
            fecha.setText(SIMPLE_DATE_FORMAT.format(tarea.getFecha()));
            estado.setText(tarea.getEstadoTarea().name());
            usuarioCreador.setText(tarea.getUsuarioCreador().getNombre());
            switch (tarea.getEstadoTarea()) {
                case EN_PROCESO:

                    btnEstado.setText(R.string.TerminarTarea);
                    btnEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.LISTA));
                    break;
                case PENDIENTE:

                    btnEstado.setText(R.string.IniciarTarea);
                    btnEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.PROCESO));
                    break;
                case LISTA:

                    btnEstado.setClickable(false);
                    btnEstado.setEnabled(false);
                    btnEliminar.setEnabled(true);
                    btnEstado.setText(R.string.BtnListo);
                    break;
            }


        }

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(tarea.getEstadoTarea() !=null){
                        switch (tarea.getEstadoTarea()) {
                            case EN_PROCESO:
                                tarea.setEstadoTarea(Tarea.EstadoTarea.LISTA);
                                tareaRepo.modificarEstado(tarea.getId(),tarea);
                                finish();
                                startActivity(getIntent());
                                break;
                            case PENDIENTE:
                                tarea.setEstadoTarea(Tarea.EstadoTarea.EN_PROCESO);
                                tareaRepo.modificarEstado(tarea.getId(),tarea);
                                finish();
                                startActivity(getIntent());
                                break;
                            case LISTA:

                                break;
                        }
                    }
            }
        });

    //TODO: Hacer boton Eliminar TArea

    }

}