package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.UsuarioRepositorioDBImp;

public class CrearTareaActivity extends AppCompatActivity {

    private Spinner listaUsuariosTecnicos;
    private Spinner categoriasTareas;
    private TextView txtDescripcionTarea;
    CategoriaRepositorioDBImp catRepo;
    UsuarioRepositorioDBImp userRepo;
    ArrayList<Categoria> categorias;
    ArrayList<Usuario> usuarios;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_tarea);

        txtDescripcionTarea = findViewById(R.id.txt_descripcionT);
        listaUsuariosTecnicos =findViewById(R.id.listaUsuariosTecnicos);
        categoriasTareas=findViewById(R.id.listaCategoriaTarea);

//        categorias = catRepo.buscar("buscar");
//        usuarios = userRepo.buscarTecnicos();
//
//        ArrayAdapter<CharSequence> adaptercat = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categorias);
//        ArrayAdapter<CharSequence> adapteruser = new ArrayAdapter(this, android.R.layout.simple_spinner_item,usuarios);
//        listaUsuariosTecnicos.setAdapter(adapteruser);
//        categoriasTareas.setAdapter(adaptercat);



        Button btnCancelarCreacion = findViewById(R.id.btnCancelarT);
        btnCancelarCreacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }

        });

    }


}
