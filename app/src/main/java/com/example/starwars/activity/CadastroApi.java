package com.example.starwars.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.starwars.R;
import com.example.starwars.data.FirebaseConect;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CadastroApi extends AppCompatActivity {

    private TextView id, nome, url, titulo, historia;
    private Button bt_cad_api;
    String[] msg = { " PREENCHER TODOS OS CAMPOS", "CADASTRO OK"};
    String userId, userId2;
    EditText id1, url2, titulo3, historia4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_api);
        getSupportActionBar().hide();
        FirebaseConect salvadados = new FirebaseConect();

        id1 = (EditText)findViewById(R.id.id_api);
        url2 = (EditText)findViewById(R.id.url_api);
        titulo3 = (EditText)findViewById(R.id.titulo_api);
        historia4 = (EditText) findViewById(R.id.historia_api);

        bt_cad_api = (Button)findViewById(R.id.bt_cadastrar_api);




        iniciarComponentes();
        bt_cad_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_api = id.getText().toString();
                String url_api = url.getText().toString();
                String titulo_api = titulo.getText().toString();
                String historia_api = historia.getText().toString();

                if (id_api.isEmpty() || url_api.isEmpty() || titulo_api.isEmpty() || historia_api.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, msg[0], Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {

                    Snackbar snackbar = Snackbar.make(v, msg[1],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                    Intent intent = new Intent(CadastroApi.this, TesteActivity.class);
                    intent.putExtra("TELA1",id1.getText().toString());
                    intent.putExtra("TELA2",url2.getText().toString());
                    intent.putExtra("TELA3", titulo3.getText().toString());
                    intent.putExtra("TELA4", historia4.getText().toString());
                    intent.putExtra("TELA5", nome.getText().toString());
                    startActivity(intent);
                    //salvadados.SalvarDadosApi();
                    SalvarDadosApi();
                    //finish();


                   /* new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {TelaCadastro();}
                    }, 2000);*/
                }
            }
        });

    }

    private void SalvarDadosApi(){


        //FirebaseAuth.getInstance();

        String idperson = nome.getText().toString();
        String nome = id.getText().toString();
        String email = url.getText().toString();
        String senha = titulo.getText().toString();
        String confirm = historia.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        Map<String,Object> personagens = new HashMap<>();
        personagens.put("ID",idperson);
        personagens.put("NOME",nome);
        personagens.put("URL",email);
        personagens.put("TITULO",senha);
        personagens.put("HISTORIA",confirm);


        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference2 = db.collection("Personagens").document(userId);
        documentReference2.set(personagens).addOnSuccessListener(new OnSuccessListener<Void>() {
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

    private void iniciarComponentes(){

        id = findViewById(R.id.id_api);
        nome = findViewById(R.id.nome_api);
        url = findViewById(R.id.url_api);
        titulo = findViewById(R.id.titulo_api);
        historia = findViewById(R.id.historia_api);
        bt_cad_api = findViewById(R.id.bt_cadastrar_api);
    }
}