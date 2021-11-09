package com.example.starwars.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.starwars.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StarLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private EditText edit_email,edit_senha;
    private Button bt_entrar;
    private ProgressBar progressBar;
    String[] msg = { " PREENCHER TODOS OS CAMPOS", "Ligin Efetuado com susseso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_login);

        getSupportActionBar().hide();
        IniciarComponentes();



        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(StarLogin.this, StarCadastro.class);
                      startActivity(cadastro);
            }
        });
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if (email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, msg[0], Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    AutenticarUser(v);

                }

            }
        });


    }
    private  void AutenticarUser( View view){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()){
                   progressBar.setVisibility(View.VISIBLE);
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                            TelaPrincipal();
                       }
                   }, 1000);

               }else {
                   String erro;
                   try {
                       throw task.getException();
                   }catch (Exception e){
                       erro = "Erro ao tentar logar, Verifique os dados ou Crie uma CONTA!";
                   }
                   Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_INDEFINITE);
                   snackbar.setBackgroundTint(Color.WHITE);
                   snackbar.setTextColor(Color.BLACK);
                   snackbar.show();
               }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser userAtual = FirebaseAuth.getInstance().getCurrentUser();
        if(userAtual != null){
            TelaPrincipal();
        }
    }

    private void TelaPrincipal(){

        Intent intent = new Intent(StarLogin.this, StarPrincipal.class);
        startActivity(intent);
        finish();
    }
    private void IniciarComponentes(){

        text_tela_cadastro = findViewById(R.id.cad_nova_conta);
        edit_email = findViewById(R.id.email);
        edit_senha = findViewById(R.id.senha);
        bt_entrar = findViewById(R.id.enter);
        progressBar = findViewById(R.id.progressBar);

    }
}