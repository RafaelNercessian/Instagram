package com.parse.starter.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.parse.starter.R;
import com.parse.starter.helper.UsuarioHelper;
import com.parse.starter.model.Usuario;
import com.parse.starter.util.ParseErros;

public class CadastroActivity extends AppCompatActivity {

    private Button botao;
    private ParseUser parseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        botao = (Button) findViewById(R.id.cadastro_botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioHelper usuarioHelper = new UsuarioHelper(CadastroActivity.this);
                Usuario usuario = usuarioHelper.insereUsuarioNoModelo();

                if (usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() || usuario.getUsuario().isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    chamaParseParaSalvarUsuario(usuario);
                }
            }
        });


    }

    private void chamaParseParaSalvarUsuario(Usuario usuario) {
            parseUser = new ParseUser();
            parseUser.setUsername(usuario.getUsuario());
            parseUser.setEmail(usuario.getEmail());
            parseUser.setPassword(usuario.getSenha());
            parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    },3000);
                } else {
                    ParseErros parseErros = new ParseErros();
                    String erro = parseErros.getErro(e.getCode());
                    Toast.makeText(CadastroActivity.this, erro, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


}
