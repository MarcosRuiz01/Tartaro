package ado.edu.itla.tartaro.usuarioTecnico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;

public class ListaTareaTECActivity extends AppCompatActivity {

    private CategoriaRepositorioDBImp categoriaRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_tecnico);

        categoriaRepo = new CategoriaRepositorioDBImp(this);

        List<Categoria> categorias = categoriaRepo.buscar(null);
        TareaListViewTECAdapter adapter = new TareaListViewTECAdapter(this, categorias);
        ListView lCategoria = findViewById(R.id.txt_listaTareaTec);
        lCategoria.setAdapter(adapter);
    }
}
