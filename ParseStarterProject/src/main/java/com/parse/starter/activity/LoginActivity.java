package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private TextView cadastrar;
    private EditText usuario;
    private EditText senha;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario=(EditText) findViewById(R.id.login_usuario);
        senha=(EditText) findViewById(R.id.login_senha);
        botao=(Button) findViewById(R.id.login_botao);

        if (ParseUser.getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            botao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chamaMetodoParaLogar();
                }
            });

            cadastrar = (TextView) findViewById(R.id.login_cadastrar);
            cadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    private void chamaMetodoParaLogar() {
        ParseUser.logInInBackground(usuario.getText().toString(), senha.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                    if(e==null){
                        Toast.makeText(LoginActivity.this, "Usuário logado", Toast.LENGTH_SHORT).show();
                    }else{
                        e.printStackTrace();
                        Toast.makeText(LoginActivity.this, "Erro", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
