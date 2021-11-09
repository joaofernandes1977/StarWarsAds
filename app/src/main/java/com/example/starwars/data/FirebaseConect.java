package com.example.starwars.data;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.starwars.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



public class FirebaseConect extends AppCompatActivity {

    public TextView id, nome, url, titulo, historia;
    String userId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciarComponentes();

    }

// SALVAL OS DADOS DA API NO BANCO DE DADOS
    public void SalvarDadosApi(){
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

    public void iniciarComponentes(){

        id = findViewById(R.id.id_api);
        nome = findViewById(R.id.nome_api);
        url = findViewById(R.id.url_api);
        titulo = findViewById(R.id.titulo_api);
        historia = findViewById(R.id.historia_api);

    }
}
