package com.example.starwars.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starwars.R;
import com.squareup.picasso.Picasso;

public class TesteActivity extends AppCompatActivity {
        TextView recebe1, recebe2, recebe3, recebe4, recebe5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_teste);



    recebe1 = (TextView) findViewById(R.id.id_1);
    recebe2 = (TextView) findViewById(R.id.url_2);
    recebe3 = (TextView) findViewById(R.id.titulo_3);
    recebe4 = (TextView) findViewById(R.id.historia_4);
    recebe5 = (TextView) findViewById(R.id.nome_person);
    String valor1 = getIntent().getStringExtra("TELA1");
    String valor2 = getIntent().getStringExtra("TELA2");
    String valor3 = getIntent().getStringExtra("TELA3");
    String valor4 = getIntent().getStringExtra("TELA4");
    String valor5 = getIntent().getStringExtra("TELA5");

    recebe1.setText(valor1);
    recebe2.setText(valor2);
    recebe3.setText(valor3);
    recebe4.setText(valor4);
    recebe5.setText(valor5);
        ImageView imageView = findViewById(R.id.avatar);
        String url = valor2;
        Picasso.get().load(url).into(imageView);

    }
}