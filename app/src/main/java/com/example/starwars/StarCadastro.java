package com.example.starwars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StarCadastro extends AppCompatActivity {

    private TextView teste_user, edit_nome, edit_email, edit_senha, confirm_pwd;
    private Button bt_cadastro;
    String[] msg = { " Preencher todos campos", "Cadastro OK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_cadastro);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                String confirmasepwd = confirm_pwd.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmasepwd.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, "COMPLETE O CADASTRO", Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    CadastrarUser(v);
                }
            }
        });

        teste_user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(StarCadastro.this, StarPrincipal.class);
                startActivity(cadastro);
            }
        });
    }




    public void CadastrarUser(View vp){

        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   Snackbar snackbar = Snackbar.make(vp, "CADASTRO OK",Snackbar.LENGTH_LONG);
                   snackbar.setBackgroundTint(Color.WHITE);
                   snackbar.setTextColor(Color.BLACK);
                   snackbar.show();
               }
            }
        });
    }
    private void IniciarComponentes(){
        teste_user = findViewById(R.id.user_teste);
        edit_nome = findViewById(R.id.nome);
        edit_email = findViewById(R.id.emailcad);
        edit_senha = findViewById(R.id.senhacad);
        confirm_pwd = findViewById(R.id.confirm_senhacad);
        bt_cadastro = findViewById(R.id.bt_cadastrar);



        ;}
}