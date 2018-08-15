package ado.edu.itla.tartaro;

import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

                if (txtNombreCategoria.getText().toString().isEmpty()) {

                    Toast.makeText(CategoriaActivity.this, "La categoria no puede estar en blanco", Toast.LENGTH_SHORT).show();
                } else {

                    Categoria cat = new Categoria();
                    cat.setNombre(txtNombreCategoria.getText().toString());
                    catRepo.guardar(cat);
                    Log.i("GUARDAR", cat.toString());
                    txtNombreCategoria.setText("");
                    Toast.makeText(CategoriaActivity.this, "Categoria creada Exitosamente", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnListarCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Categoria categoria;
//                List<Categoria> categorias = catRepo.buscar(null);
//                categorias.
//                String[] cats = new String[categorias.size()];
//
//                Snackbar.make(v, cats.toString(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Log.i("LISTAR", "Categoria.size =" + categorias.size());

            }

        });
    }

}