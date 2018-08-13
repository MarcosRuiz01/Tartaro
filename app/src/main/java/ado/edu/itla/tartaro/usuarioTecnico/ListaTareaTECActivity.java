package ado.edu.itla.tartaro.usuarioTecnico;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;

public class ListaTareaTECActivity extends AppCompatActivity {

    public static final String TAREA_SELECCIONADA = "TAREA_SELECCIONADA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_tecnico);

        final ListView listView;
        listView = findViewById(R.id.txt_listaTareaTec);
        final TareaRepositorioDBImp tareaRepo = new TareaRepositorioDBImp(this);
        Button btnPendientes = findViewById(R.id.btnTodas);
        Button btnProceso = findViewById(R.id.btnProcesoN);
        Button btnBusqueda = findViewById(R.id.button7);

        List<Tarea> tareas = tareaRepo.buscarAsignadaA(AppConfig.getConfig().getUsuario());
        TareaListViewTECAdapter adapter = new TareaListViewTECAdapter(this,tareas );
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

        final SwipeRefreshLayout swipeLayout = findViewById(R.id.swipeRefresh1);
        swipeLayout.setColorSchemeResources(R.color.Refresh1);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                List<Tarea> tareas = tareaRepo.buscarAsignadaA(AppConfig.getConfig().getUsuario());
                TareaListViewTECAdapter adapter = new TareaListViewTECAdapter(ListaTareaTECActivity.this, tareas);
                listView.setAdapter(adapter);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeLayout.setRefreshing(false);
                    }
                }, 1000);

            }
        });

        //TODO: Crear los botones de filtrado.
        btnPendientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnBusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
