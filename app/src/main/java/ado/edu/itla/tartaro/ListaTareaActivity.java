package ado.edu.itla.tartaro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.repositorio.CategoriaRepositorio;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;

public class ListaTareaActivity extends AppCompatActivity {

    private CategoriaRepositorio categoriaRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_tecnico);

        categoriaRepo = new CategoriaRepositorioDBImp(this);

        List<Categoria> categorias = categoriaRepo.buscar(null);
        CategoriaListViewAdapter adapter = new CategoriaListViewAdapter(this, categorias);
        ListView lCategoria = findViewById(R.id.txt_listaTarea);
        lCategoria.setAdapter(adapter);
    }
}
