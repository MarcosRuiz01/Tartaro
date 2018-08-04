package ado.edu.itla.tartaro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.db.UsuarioRepositorioDBImp;
import ado.edu.itla.tartaro.usuarioNormal.ListaTareaUNActivity;
import ado.edu.itla.tartaro.usuarioTecnico.ListaTareaTECActivity;

public class LogInGeneral extends AppCompatActivity {

    private EditText userName, userPass;
    private TextView registro;
    UsuarioRepositorioDBImp userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_principal);

        userRepo = new UsuarioRepositorioDBImp(this);
        userName = findViewById(R.id.txt_user);
        userPass = findViewById(R.id.txt_pass);
        registro = findViewById(R.id.txt_register);

        Button btnLogIn = findViewById(R.id.btnIniciar);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Usuario user = userRepo.buscar(userName.getText().toString());


                if (user == null) {
                    Toast.makeText(LogInGeneral.this, "Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!user.getPassword().equals(userPass.getText().toString())) {
                    Toast.makeText(LogInGeneral.this, "Usuario o contrasenia incorrectas", Toast.LENGTH_SHORT).show();
                    return;
                }


                // TODO: establecer usuario logeado.
                AppConfig.getConfig().setUsuario(user);

                switch (user.getTipoUsuario()) {

                    case NORMAL:
                        System.out.println("Aquiiii. NormalActivity");
                        Intent NormalActivity = new Intent(LogInGeneral.this, ListaTareaUNActivity.class);
                        startActivity(NormalActivity);

                        break;
                    case TECNICO:

                        System.out.println("Aquiiii. TecnicoActivity");
                        Intent TecnicoActivity = new Intent(LogInGeneral.this, ListaTareaTECActivity.class);
                        startActivity(TecnicoActivity);
                }

            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Aquiiii. Registro");
                Intent RegistroGeneral = new Intent(LogInGeneral.this, RegistroGeneral.class);
                startActivity(RegistroGeneral);

            }
        });

    }
}
