package ado.edu.itla.tartaro;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import ado.edu.itla.tartaro.entidad.Usuario;
import ado.edu.itla.tartaro.repositorio.UsuarioRepositorio;
import ado.edu.itla.tartaro.repositorio.db.UsuarioRepositorioDBImp;

public class RegistroGeneral extends AppCompatActivity {

    private EditText email, userName, passw, confPassw;
    private RadioButton rbtTecnico, rbtNormal;
    UsuarioRepositorio userRepo;
    Usuario.TipoUsuario tipoUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);

        userRepo = new UsuarioRepositorioDBImp(this);

        email = findViewById(R.id.txt_mail);
        userName = findViewById(R.id.txt_UserName);
        passw = findViewById(R.id.txt_pass_reg);
        confPassw = findViewById(R.id.txt_conf_pass);
        rbtTecnico = findViewById(R.id.rbt_tecnico);
        rbtNormal = findViewById(R.id.rbt_normal);


        Button btnRegistrarUsuario = findViewById(R.id.btn_registrar);
        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Usuario user = new Usuario();
                    user.setNombre(userName.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(passw.getText().toString());

                    String p1 = passw.getText().toString();
                    String p2  = confPassw.getText().toString();


                if(p1.equals(p2)){

                    if (rbtNormal.isChecked() == true) {
                        tipoUsuario = Usuario.TipoUsuario.NORMAL;

                        Log.i("REGISTRO USER NORMAL", user.toString());

                    } else if (rbtTecnico.isChecked() == true) {
                        tipoUsuario = Usuario.TipoUsuario.TECNICO;

                        Log.i("REGISTRO USER TECNICO", user.toString());

                    } else if (rbtTecnico.isChecked() == false && rbtNormal.isChecked() == false) {
                        Toast.makeText(RegistroGeneral.this, "Es necesario que seleccione un tipo de usuario", Toast.LENGTH_SHORT).show();
                    }

                        userRepo.guardar(user);
                        Log.i("Registro user exitoso", user.toString());


                } else {
                    Toast.makeText(RegistroGeneral.this,"No se pudo confirmar las contraseñas, por favor intente denuevo",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}