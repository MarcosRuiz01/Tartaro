package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;
import ado.edu.itla.tartaro.usuarioTecnico.TareaListViewTECAdapter;

public class ListaTareaUNActivity extends AppCompatActivity {

    public static final String TAREA_SELECCIONADA = "TAREA_SELECCIONADA";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_normal);

        ListView listView;
        TareaRepositorioDBImp tareaRepo;

        tareaRepo = new TareaRepositorioDBImp(this);
        listView = findViewById(R.id.txt_listaTareaN);


        List<Tarea> tareas = tareaRepo.buscarCreadaPor(AppConfig.getConfig().getUsuario());
        TareaListViewNorAdapter adapter = new TareaListViewNorAdapter(this, tareas);
//        ListView lTarea = findViewById(R.id.txt_listaTareaN);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);




        Button btnCrearTarea = findViewById(R.id.btnCrearTarea);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent crearTarea = new Intent(ListaTareaUNActivity.this, CrearTareaActivity.class);
                startActivity(crearTarea);

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Tarea tarea = (Tarea) parent.getItemAtPosition(position);
//                tareaRepo.buscar(item.getId());
//                AppConfig.getConfig().setTareaSeleccUsuario(tareaRepo.buscar(position));

                Intent detallesTarea = new Intent(ListaTareaUNActivity.this, DetallesTareaUNActivity.class);
                detallesTarea.putExtra(TAREA_SELECCIONADA, tarea);
                startActivity(detallesTarea);

            }
        });


    }




}
