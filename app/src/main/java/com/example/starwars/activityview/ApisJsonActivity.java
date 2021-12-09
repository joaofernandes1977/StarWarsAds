package com.example.starwars.activityview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.example.starwars.model.Personagen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;

public class ApisJsonActivity extends AppCompatActivity {
    private  TextView nomeUser, nomeEmail;
    private Button bt_personagem, bt_planeta, bt_naves;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_json);
        getSupportActionBar().hide();
        IniciaComponentes();



        bt_personagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ApisJsonActivity.this, PersonagemActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bt_planeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ApisJsonActivity.this, PlanetaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bt_naves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ApisJsonActivity.this, NavesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        /*
        bt_teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ApisJsonActivity.this, ConsultaApi.class);
                startActivity(intent);
                finish();
            }
        });
*/
    }


    public void cosultaApiBanco(View view){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference personagens = reference.child("Personagen");
        personagens.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override

            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (!task.isSuccessful()) {

                    Log.e("firebase", "Error getting data", task.getException());

                }

                else {
                    for ( DataSnapshot d : task.getResult().getChildren()){
                        Personagen p = d.getValue(Personagen.class);
                        //Intent intent = new Intent(ApisJsonActivity.this, StarResultCadastroApi.class);
                        //intent.putExtra("personagem", p);
                        ((HashMap<String, String>)d.getValue()).get("especie");

                    }

                    Log.d("firebase", String.valueOf(task.getResult().getValue()));

                }

            }

        });



        Intent intent = new Intent(ApisJsonActivity.this, StarResultCadastroApi.class);
        //intent.putExtra("personagem", p);
    }
    public  void voltarPrincipal(View view){

        Intent intent = new Intent(ApisJsonActivity.this, PrincipalDrawerNav.class);
        startActivity(intent);
    }
    private void IniciaComponentes(){

        bt_personagem = findViewById(R.id.personagensApi);
        bt_planeta = findViewById(R.id.planetasApi);
        bt_naves = findViewById(R.id.navesApi);


    }


}