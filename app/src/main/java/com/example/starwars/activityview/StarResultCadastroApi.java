package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.squareup.picasso.Picasso;

public class StarResultCadastroApi extends AppCompatActivity {
        TextView recebe2_url, recebe4_historia, recebe5_nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.api_result_cadastro);




    recebe2_url = (TextView) findViewById(R.id.url_2);
    recebe4_historia = (TextView) findViewById(R.id.historia_4);
    recebe5_nome = (TextView) findViewById(R.id.nome_person);



    String valor3_nome = getIntent().getStringExtra("NOME");
    String valor2_url = getIntent().getStringExtra("URL");
    String valor6_historia = getIntent().getStringExtra("HISTORIA");


    recebe2_url.setText(valor2_url);
    recebe4_historia.setText(valor6_historia);
    recebe5_nome.setText(valor3_nome);

        ImageView imageView = findViewById(R.id.avatar);
        String url = valor2_url;
        Picasso.get().load(url).into(imageView);
        Toast.makeText(this, "CADASTRO REALIZADO COM SUCESSO" , Toast.LENGTH_LONG).show();
    }
    public void cadastronovo(View view){
        Intent intent = new Intent(StarResultCadastroApi.this, CadastroApi.class);
        startActivity(intent);
    }
    public  void voltarHome(View view){

        Intent intent = new Intent(StarResultCadastroApi.this, PrincipalDrawerNav.class);
        startActivity(intent);
    }
}