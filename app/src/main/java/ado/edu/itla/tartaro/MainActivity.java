package ado.edu.itla.tartaro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, "Estoy por aquí");

        Button btnCategoria=findViewById(R.id.btnCategoria);
        btnCategoria.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //TODO: Llamar otro activity
                Intent vistaCategoria;
                vistaCategoria = new Intent(MainActivity.this, VistaCategoria.class);

                vistaCategoria.putExtra("nombre","Juan de los Palotes");
                startActivity(vistaCategoria);


            }
        });
    }
}