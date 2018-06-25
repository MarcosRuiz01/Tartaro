package ado.edu.itla.tartaro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VistaCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_categoria);

        TextView txtNombre = findViewById(R.id.txtNombre);

        Bundle data = this.getIntent().getExtras();
        String nombre = data.getString("nombre");
        txtNombre.setText(nombre);
    }
}
