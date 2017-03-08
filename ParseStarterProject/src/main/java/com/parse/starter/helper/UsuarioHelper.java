package com.parse.starter.helper;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.starter.R;
import com.parse.starter.activity.CadastroActivity;
import com.parse.starter.model.Usuario;

/**
 * Created by Rafael on 05/03/2017.
 */
public class UsuarioHelper {

    private Activity activity;
    private EditText usuario;
    private EditText email;
    private EditText senha;

    private TextView login;


    public UsuarioHelper(Activity activity) {
        this.activity = activity;
        pegaDadosActivity();
    }

    private void pegaDadosActivity() {
        usuario = (EditText) activity.findViewById(R.id.cadastro_usuario);
        email = (EditText) activity.findViewById(R.id.cadastro_email);
        senha = (EditText) activity.findViewById(R.id.cadastro_senha);
    }

    public Usuario insereUsuarioNoModelo(){
        Usuario usuarioModelo = new Usuario();
        usuarioModelo.setUsuario(usuario.getText().toString());
        usuarioModelo.setEmail(email.getText().toString());
        usuarioModelo.setSenha(senha.getText().toString());
        return usuarioModelo;
    }

}
