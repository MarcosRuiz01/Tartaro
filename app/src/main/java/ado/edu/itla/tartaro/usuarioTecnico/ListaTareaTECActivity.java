package ado.edu.itla.tartaro.usuarioTecnico;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;
import ado.edu.itla.tartaro.usuarioNormal.ListaTareaUNActivity;

public class ListaTareaTECActivity extends AppCompatActivity {

    public static final String TAREA_SELECCIONADA = "TAREA_SELECCIONADA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_tecnico);

        ListView listView;
        listView = findViewById(R.id.txt_listaTareaTec);
        TareaRepositorioDBImp tareaRepo = new TareaRepositorioDBImp(this);

        List<Tarea> tareas = tareaRepo.buscarAsignadaA(AppConfig.getConfig().getUsuario());
        TareaListViewTECAdapter adapter = new TareaListViewTECAdapter(this,tareas );
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tarea tarea = (Tarea) parent.getItemAtPosition(position);
                Intent detallesTarea = new Intent(ListaTareaTECActivity.this, DetallesTareaTECActivity.class);
                detallesTarea.putExtra(TAREA_SELECCIONADA,tarea);
                startActivity(detallesTarea);

            }
        });
    }
}
