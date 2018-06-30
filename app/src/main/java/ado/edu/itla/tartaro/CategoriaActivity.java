package ado.edu.itla.tartaro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_categoria);

        EditText txtNombreCategoria = findViewById(R.id.txtNombreCategoria);
        Button btnGuardarCategoria = findViewById(R.id.btnGuardarCategoria);

        btnGuardarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: guardar la categoria.
            }
        });

    }
}
