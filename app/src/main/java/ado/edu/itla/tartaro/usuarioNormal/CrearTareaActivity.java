package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.CategoriaActivity;
import ado.edu.itla.tartaro.MainActivity;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.TareaRepositorio;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.TareaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.UsuarioRepositorioDBImp;

public class CrearTareaActivity extends AppCompatActivity {

    private Spinner listaUsuariosTecnicos;
    private Spinner categoriasTareas;
    private EditText txtDescripcionTarea;
    private EditText txtNombreTarea;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_tarea);

        txtDescripcionTarea = findViewById(R.id.txt_descripcionT);
        txtNombreTarea = findViewById(R.id.txt_nombreTarea);
        listaUsuariosTecnicos = findViewById(R.id.listaUsuariosTecnicos);
        categoriasTareas = findViewById(R.id.listaCategoriaTarea);


        CategoriaRepositorioDBImp catRepo = new CategoriaRepositorioDBImp(this);
        UsuarioRepositorioDBImp userRepo = new UsuarioRepositorioDBImp(this);
        final TareaRepositorio tareaRepositorio = new TareaRepositorioDBImp(this);

        List<Categoria> categorias = catRepo.buscar(null);
        List<Usuario> usuariosTec = userRepo.buscarTecnicos();
        ArrayAdapter<Categoria> adapterCategoria = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        ArrayAdapter<Usuario> adapteruser = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usuariosTec);

        listaUsuariosTecnicos.setAdapter(adapteruser);
        categoriasTareas.setAdapter(adapterCategoria);

        Button btnCrearTarea = findViewById(R.id.btnGuargarT);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario user = (Usuario) listaUsuariosTecnicos.getSelectedItem();
                Categoria cat = (Categoria) categoriasTareas.getSelectedItem();

                Tarea tarea = new Tarea();
                tarea.setFecha(new Date());
                tarea.setCategoria(cat);
                tarea.setUsuarioCreador(AppConfig.getConfig().getUsuario());
                tarea.setUsuarioAsignado(user);
                tarea.setNombre(txtNombreTarea.getText().toString());
                tarea.setDescripcion(txtDescripcionTarea.getText().toString());

                tareaRepositorio.guardar(tarea);

                if (tarea.getId() != null) {
                    Toast.makeText(CrearTareaActivity.this, "Tarea creada Exitosamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CrearTareaActivity.this, "Error: Tarea no creada.", Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        });


        Button btnCancelarCreacion = findViewById(R.id.btnCancelarT);
        btnCancelarCreacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }

        });

        Button btnCategoria = findViewById(R.id.btnCrearCategoria);
        btnCategoria.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent vistaCategoria;
                vistaCategoria = new Intent(CrearTareaActivity.this, CategoriaActivity.class);

                startActivity(vistaCategoria);

            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("DATOS", "Retorno");

    }
}
