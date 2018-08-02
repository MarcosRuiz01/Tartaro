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
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.db.CategoriaRepositorioDBImp;
import ado.edu.itla.tartaro.repositorio.db.UsuarioRepositorioDBImp;

public class CrearTareaActivity extends AppCompatActivity {

    private Spinner listaUsuariosTecnicos;
    private Spinner categoriasTareas;
    private TextView txtDescripcionTarea;
    Usuario user;
    Categoria cat;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_tarea);

        txtDescripcionTarea = findViewById(R.id.txt_descripcionT);
        listaUsuariosTecnicos =findViewById(R.id.listaUsuariosTecnicos);
        categoriasTareas=findViewById(R.id.listaCategoriaTarea);

        CategoriaRepositorioDBImp catRepo = new CategoriaRepositorioDBImp (this);
        UsuarioRepositorioDBImp userRepo = new UsuarioRepositorioDBImp(this);

        List<Categoria> categorias = catRepo.buscar(null);
        List<Usuario> usuariosTec = userRepo.buscarTecnicos();
        ArrayAdapter<Categoria> adapterCategoria = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias);
        ArrayAdapter<Usuario> adapteruser = new ArrayAdapter(this, android.R.layout.simple_spinner_item,usuariosTec);

        listaUsuariosTecnicos.setAdapter(adapteruser);
        categoriasTareas.setAdapter(adapterCategoria);

        user = (Usuario) listaUsuariosTecnicos.getSelectedItem();
        cat = (Categoria) categoriasTareas.getSelectedItem();


//        listaUsuariosTecnicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                user = (Usuario) parent.getItemAtPosition(position);
//
//            }
//        });
//
//        categoriasTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                cat = (Categoria) parent.getItemAtPosition(position);
//            }
//        });

        Button btnCrearTarea = findViewById(R.id.btnGuargarT);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tarea tarea = new Tarea();
                tarea.setCategoria(cat);
                tarea.setUsuarioAsignado(user);
                tarea.setDescripcion(txtDescripcionTarea.toString());

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

    }


}
