package com.example.starwars;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.starwars.adapters.UserAdapter;
import com.example.starwars.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;

public class StarPrincipal extends AppCompatActivity {
    private  TextView nomeUser, nomeEmail;
    private Button bt_deslogar;
    FirebaseFirestore banco = FirebaseFirestore.getInstance();
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_principal);
        getSupportActionBar().hide();
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
    }


}