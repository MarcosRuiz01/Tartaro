package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ado.edu.itla.tartaro.R;

public class ListaTareaUNActivity extends AppCompatActivity{



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarea_normal);

        Button btnCrearTarea = findViewById(R.id.btnCrearTarea);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent crearTarea =new Intent(ListaTareaUNActivity.this,CrearTareaActivity.class);
                startActivity(crearTarea);
            }
        });


    }


}
