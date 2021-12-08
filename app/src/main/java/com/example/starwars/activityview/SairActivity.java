package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.starwars.R;
import com.google.firebase.auth.FirebaseAuth;

public class SairActivity extends AppCompatActivity {
    private Button bt_deslogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sair);
        iniciacomponentes();
        getSupportActionBar().hide();

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SairActivity.this, StarLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void iniciacomponentes(){

        bt_deslogar = findViewById(R.id.deslogar);
    }

}