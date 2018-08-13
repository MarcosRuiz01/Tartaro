package ado.edu.itla.tartaro.usuarioTecnico;

import android.app.Dialog;
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
        final Dialog dialog = new Dialog(DetallesTareaTECActivity.this);
        dialog.setContentView(R.layout.mensaje_emergente);
        dialog.setTitle("CONFIRMACION");
        final TextView dialogMsg = dialog.findViewById(R.id.txtDialogMsg);
        final Button btnAceptar = dialog.findViewById(R.id.btnDialogAceptar);
        final Button btnDeclinar = dialog.findViewById(R.id.btnDialogDeclinar);

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
                    estado.setTextColor(ContextCompat.getColor(this, R.color.PROCESO));
                    btnEstado.setText(R.string.TerminarTarea);
                    btnEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.LISTA));
                    break;
                case PENDIENTE:
                    estado.setTextColor(ContextCompat.getColor(this, R.color.PENDIENTE));
                    btnEstado.setText(R.string.IniciarTarea);
                    btnEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.PROCESO));
                    break;
                case LISTA:
                    estado.setTextColor(ContextCompat.getColor(this, R.color.LISTA));
                    btnEstado.setClickable(false);
                    btnEstado.setEnabled(false);
                    btnEliminar.setEnabled(true);
                    btnEstado.setText(R.string.BtnListo);
                    break;

                case ELIMINADA:
                    btnEstado.setEnabled(false);
                    btnEstado.setText(R.string.BtnListo);
            }


        }

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(tarea.getEstadoTarea() !=null){
                        switch (tarea.getEstadoTarea()) {
                            case EN_PROCESO:
                                dialog.show();
                                dialogMsg.setText(R.string.TerminarConfirmacion);
                                btnAceptar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        tarea.setEstadoTarea(Tarea.EstadoTarea.LISTA);
                                        tareaRepo.modificarEstado(tarea.getId(),tarea);
                                        finish();
                                        startActivity(getIntent());
                                    }
                                });

                                btnDeclinar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });


                                break;
                            case PENDIENTE:
                                dialog.show();
                                dialogMsg.setText(R.string.IniciarConfirmacion);
                                btnAceptar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        tarea.setEstadoTarea(Tarea.EstadoTarea.EN_PROCESO);
                                        tareaRepo.modificarEstado(tarea.getId(), tarea);
                                        finish();
                                        startActivity(getIntent());
                                    }
                                });

                                btnDeclinar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                                break;

                        }
                    }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tarea.getEstadoTarea() !=null) {
                    switch (tarea.getEstadoTarea()) {

                        case LISTA:
                            dialog.show();
                            dialogMsg.setText(R.string.EliminarConfirmacion);
                            btnAceptar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    tarea.setEstadoTarea(Tarea.EstadoTarea.ELIMINADA);
                                    tareaRepo.modificarEstado(tarea.getId(),tarea);
                                    finish();
                                    startActivity(getIntent());
                                }
                            });

                            btnDeclinar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            break;

                            //TODO: Decidir si este boton (Eliminar) hara algo mas

                        case ELIMINADA:
                            break;

                    }

                    }
                }
        });

    }

}