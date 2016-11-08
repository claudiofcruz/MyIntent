package br.com.gnz.myintent;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.gnz.myintent.utils.Constantes;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout titUsuario;
    private TextInputLayout titSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titUsuario = (TextInputLayout) findViewById(R.id.titUsuario);
        titSenha = (TextInputLayout) findViewById(R.id.titSenha);
    }

    public void fazerLogin(View v){
        String usuario = titUsuario.getEditText().getText().toString();
        String senha = titSenha.getEditText().getText().toString();

        if(usuario.equals("admin") && (senha.equals("123")))
        {
            titUsuario.setErrorEnabled(false);
            titSenha.setErrorEnabled(false);
            Intent formularioIntent = new Intent(MainActivity.this, FormularioActivity.class);
            formularioIntent.putExtra(Constantes.KEY_USUARIO,usuario);
            startActivity(formularioIntent);
        }
        else
        {
//            Toast.makeText(this, "Senha Inválida", Toast.LENGTH_SHORT).show();
            titUsuario.setError("");
            titSenha.setError("Usuário ou senha inválido.");
        }
    }
}
