package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toolbar;

import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;

public class ListaTareaUNActivity extends AppCompatActivity {

    public static final String TAREA_SELECCIONADA = "TAREA_SELECCIONADA";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_normal);

        final ListView listView;
        final TareaRepositorioDBImp tareaRepo;
        Button btnCrearTarea = findViewById(R.id.btnCrearTarea);
        Button btnTodas = findViewById(R.id.btnTodas);
        Button btnProceso = findViewById(R.id.btnProcesoN);


        tareaRepo = new TareaRepositorioDBImp(this);
        listView = findViewById(R.id.txt_listaTareaN);


        List<Tarea> tareas = tareaRepo.buscarCreadaPor(AppConfig.getConfig().getUsuario());
        TareaListViewNorAdapter adapter = new TareaListViewNorAdapter(this, tareas);
        listView.setAdapter(adapter);




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

        final SwipeRefreshLayout swipeLayout = findViewById(R.id.swipeRefresh);
        swipeLayout.setColorSchemeResources(R.color.Refresh1);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                List<Tarea> tareas = tareaRepo.buscarCreadaPor(AppConfig.getConfig().getUsuario());
                TareaListViewNorAdapter adapter = new TareaListViewNorAdapter(ListaTareaUNActivity.this, tareas);
                listView.setAdapter(adapter);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeLayout.setRefreshing(false);
                    }
                }, 1000);

            }
        });
        //TODO: Filtrar con Boton (Proceso) las tareas
        btnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTodas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Tarea> tareas = tareaRepo.buscarCreadaPor(AppConfig.getConfig().getUsuario());
                TareaListViewNorAdapter adapter = new TareaListViewNorAdapter(ListaTareaUNActivity.this, tareas);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });


    }


}
