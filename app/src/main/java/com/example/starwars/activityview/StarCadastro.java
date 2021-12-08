package com.example.starwars.activityview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.example.starwars.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class StarCadastro extends AppCompatActivity {

    private TextView edit_nome, edit_email, edit_senha, confirm_pwd;
    private Button bt_cadastro, bt_voltar;
    String[] msg = { " PREENCHER TODOS OS CAMPOS", "Cadastro OK", "AS SENHAS DEVEM SER IGUAIS!"};
    String userId, userId2;
    private ProgressBar progressBar2;
    User usuario = new User();

    //FirebaseFirestore banco2 = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_cadastro);

        getSupportActionBar().hide();
        IniciarComponentes();
        /*
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StarCadastro.this, ApisJsonActivity.class);
                startActivity(intent);
            }
        });
*/
        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()  ){
                    Snackbar snackbar = Snackbar.make(v, msg[0], Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                        CadastrarUser(v);
                    }


            }
        });


    }




    public void CadastrarUser(View vp){

        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        String nome = edit_nome.getText().toString();


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                    usuario.setEmail(email);
                    usuario.setSenha(senha);
                    usuario.setNome(nome);

                   SalvarDadosUser(usuario);

                   Snackbar snackbar = Snackbar.make(vp, msg[1],Snackbar.LENGTH_LONG);
                   snackbar.setBackgroundTint(Color.WHITE);
                   snackbar.setTextColor(Color.BLACK);
                   snackbar.show();
                   progressBar2.setVisibility(View.VISIBLE);
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           TelaPrincipal();
                       }
                   }, 2000);


               }else{
                   String erro;
                   try {
                       throw  task.getException();

                   }catch (FirebaseAuthWeakPasswordException e){
                            erro = "Digite uma senha com no minimo 6 carcteres";
                   }catch (FirebaseAuthUserCollisionException e){
                       erro = "Esta conta ja foi cadastrada";
                   }catch (FirebaseAuthInvalidCredentialsException e){
                       erro = "Email invalido";
                   }catch (Exception e){
                       erro = "ERRO ao cadastrar usuário";
                   }
                   Snackbar snackbar = Snackbar.make(vp, erro,Snackbar.LENGTH_LONG);
                   snackbar.setBackgroundTint(Color.WHITE);
                   snackbar.setTextColor(Color.BLACK);
                   snackbar.show();
               }
            }
        });
    }

    private void SalvarDadosUser(User usuario){
        String nome = usuario.getNome();
        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        FirebaseFirestore db = FirebaseFirestore.getInstance();


        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("nome",nome);
        usuarios.put("email",email);
        usuarios.put("SENHA",senha);


        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(userId);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("db", "Sucesso ao Salvar os dados");
            }
        })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db", "Erro ao Salvar os dados" + e.toString());
                    }
                });

    }
    private void TelaPrincipal(){

        Intent intent = new Intent( StarCadastro.this, PrincipalDrawerNav.class);
        startActivity(intent);
        finish();
    }

    private void IniciarComponentes(){

        edit_nome = findViewById(R.id.nome);
        edit_email = findViewById(R.id.emailcad);
        edit_senha = findViewById(R.id.senhacad);
        //bt_voltar = findViewById(R.id.voltarprincipalCad);
        bt_cadastro = findViewById(R.id.bt_cadastrar);
        progressBar2 = findViewById(R.id.progressBar2);

    }
}