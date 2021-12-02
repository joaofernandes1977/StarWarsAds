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

public class StarPrincipal extends AppCompatActivity {
    private  TextView nomeUser, nomeEmail;
    private Button bt_deslogar, bt_cadastrar, bt_card, bt_draewr, bt_avatar;
    FirebaseFirestore banco = FirebaseFirestore.getInstance();
    String userId;
    //Personagen p = new Personagen();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_principal);
        //getSupportActionBar().hide();
        IniciaComponentes();


        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StarPrincipal.this, StarLogin.class);
                startActivity(intent);
                finish();
            }
        });
        bt_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StarPrincipal.this, CardViewFilmes.class);
                startActivity(intent);
                finish();
            }
        });
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StarPrincipal.this, CadastroApi.class);
                startActivity(intent);
                finish();
            }
        });
        bt_draewr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StarPrincipal.this, PrincipalDrawerNav.class);
                startActivity(intent);
                finish();
            }
        });
        bt_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StarPrincipal.this, StarAvatar.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void onStart(){
        super.onStart();
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = banco.collection("Usuarios").document(userId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null){
                    nomeUser.setText(documentSnapshot.getString("nome"));
                    nomeEmail.setText(documentSnapshot.getString("email"));

                }
            }
        });
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
                        //Intent intent = new Intent(StarPrincipal.this, StarResultCadastroApi.class);
                        //intent.putExtra("personagem", p);
                        ((HashMap<String, String>)d.getValue()).get("especie");

                    }

                    Log.d("firebase", String.valueOf(task.getResult().getValue()));

                }

            }

        });



        Intent intent = new Intent(StarPrincipal.this, StarResultCadastroApi.class);
        //intent.putExtra("personagem", p);
    }

    private void IniciaComponentes(){
        nomeUser = findViewById(R.id.nome_usuario);
        nomeEmail = findViewById(R.id.nome_mail);


        bt_deslogar = findViewById(R.id.deslogar);
        bt_cadastrar = findViewById(R.id.starCad);
        //bt_fragment = findViewById(R.id.starApi);
        bt_card = findViewById(R.id.consulta_card);
        bt_draewr = findViewById(R.id.drawer_principal);
        bt_avatar = findViewById(R.id.avatares);
    }


}