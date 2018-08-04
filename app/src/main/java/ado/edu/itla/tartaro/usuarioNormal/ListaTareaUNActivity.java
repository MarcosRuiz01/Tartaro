package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;
import ado.edu.itla.tartaro.usuarioTecnico.TareaListViewTECAdapter;

public class ListaTareaUNActivity extends AppCompatActivity {

    private TareaRepositorioDBImp tareaRepo;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_normal);

        tareaRepo = new TareaRepositorioDBImp(this);

        List<Tarea> tareas = tareaRepo.buscarCreadaPor(AppConfig.getConfig().getUsuario());
        TareaListViewNorAdapter adapter = new TareaListViewNorAdapter(this, tareas);
        ListView lTarea = findViewById(R.id.txt_listaTareaN);
        lTarea.setAdapter(adapter);


        Button btnCrearTarea = findViewById(R.id.btnCrearTarea);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent crearTarea = new Intent(ListaTareaUNActivity.this, CrearTareaActivity.class);
                startActivity(crearTarea);
            }
        });


    }


}
