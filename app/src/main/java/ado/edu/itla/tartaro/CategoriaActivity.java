package ado.edu.itla.tartaro;

import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.repositorio.CategoriaRepositorio;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;

public class CategoriaActivity extends AppCompatActivity {

    CategoriaRepositorio catRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_categoria);

        catRepo = new CategoriaRepositorioDBImp(this);

        final EditText txtNombreCategoria = findViewById(R.id.txtNombreCategoria);
        Button btnGuardarCategoria = findViewById(R.id.btnGuardarCategoria);
        Button btnListarCategorias = findViewById(R.id.btnListarCategoria);


        btnGuardarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Categoria cat = new Categoria();
                cat.setNombre(txtNombreCategoria.getText().toString());
                catRepo.guardar(cat);
                Log.i("GUARDAR", cat.toString());

            }

        });

        btnListarCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Categoria> categorias = catRepo.buscar(null);
                Log.i("LISTAR", "Categoria.size =" + categorias.size());

                for (Categoria c : categorias) {
                    Log.i("LISTAR", c.toString());

                }
            }

        });
    }

}