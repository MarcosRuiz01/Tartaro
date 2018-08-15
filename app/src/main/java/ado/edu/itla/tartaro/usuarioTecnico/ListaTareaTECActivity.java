package ado.edu.itla.tartaro.usuarioTecnico;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.pruebas.pruebaAppBar;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;

public class ListaTareaTECActivity extends AppCompatActivity {

    public static final String TAREA_SELECCIONADA = "TAREA_SELECCIONADA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_layout_tecnico);
        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        SpinnerAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.Estados_spinner, android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinnerToolBar);
        spinner.setAdapter(adapter1);

        final ListView listView;
        listView = findViewById(R.id.txt_listaTareaTec);
        final TareaRepositorioDBImp tareaRepo = new TareaRepositorioDBImp(this);
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

      }
    //TODO: Terminar la configuracion del Search
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manu_listview_tarea, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_button).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

//        final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                TextView textView=(TextView)findViewById(R.id.aa);
//                textView.setText(newText);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                TextView textView=(TextView)findViewById(R.id.aa);
//                textView.setText(query);
//                return true;
//            }
//        };

//        searchView.setOnQueryTextListener(queryTextListener);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_button) {
            Toast.makeText(ListaTareaTECActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
