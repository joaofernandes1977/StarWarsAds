package com.example.starwars.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.starwars.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class StarPrincipal extends AppCompatActivity {
    private  TextView nomeUser, nomeEmail;
    private Button bt_deslogar, bt_cadastrar, bt_fragment;
    FirebaseFirestore banco = FirebaseFirestore.getInstance();
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_principal);
        getSupportActionBar().hide();
        IniciaComponentes();

        bt_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(StarPrincipal.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });


        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StarPrincipal.this, StarLogin.class);
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


    private void IniciaComponentes(){
        nomeUser = findViewById(R.id.nome_usuario);
        nomeEmail = findViewById(R.id.nome_mail);
        bt_deslogar = findViewById(R.id.deslogar);
        bt_cadastrar = findViewById(R.id.starCad);
        bt_fragment = findViewById(R.id.starApi);
    }


}