package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.usuarioTecnico.ListaTareaTECActivity;

public class DetallesTareaUNActivity extends AppCompatActivity {

    private TextView categoria;
    private TextView taskName;
    private TextView fecha;
    private TextView usuarioAsignado;
    private TextView estado;
    private TextView descripcion;
    private TextView taskNameBar;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea_normal);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        taskNameBar = findViewById(R.id.task_bar_name);

        taskName = findViewById(R.id.txtTaskName);
        categoria = findViewById(R.id.txtCategoria2);
        fecha = findViewById(R.id.fechaTarea2);
        usuarioAsignado = findViewById(R.id.txtUsuarioCreador);
        estado = findViewById(R.id.txtEstado);
        descripcion = findViewById(R.id.txtDescripcion2);


        Intent intent = getIntent();
        Tarea tarea = (Tarea) intent.getSerializableExtra(ListaTareaUNActivity.TAREA_SELECCIONADA);
        taskNameBar.setText(tarea.getNombre());


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

        //TODO: Confirmar la elimimacion de tarea en DB


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manu_detalles_tarea, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.delete_button) {
            Toast.makeText(DetallesTareaUNActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}