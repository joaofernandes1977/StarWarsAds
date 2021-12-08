package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.squareup.picasso.Picasso;

public class StarResultCadastroApi extends AppCompatActivity {
        TextView recebe2_url, recebe3_veiculo, recebe4_historia, recebe5_nome, recebe6_especie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.api_result_cadastro);




    recebe2_url = (TextView) findViewById(R.id.url_2);
    recebe3_veiculo = (TextView) findViewById(R.id.veiculo);
    recebe4_historia = (TextView) findViewById(R.id.historia_4);
    recebe5_nome = (TextView) findViewById(R.id.nome_person);
    recebe6_especie = (TextView) findViewById(R.id.especie);


    String valor3_nome = getIntent().getStringExtra("NOME");
    String valor2_url = getIntent().getStringExtra("URL");
    String valor4_veiculo = getIntent().getStringExtra("VEICULO");
    String valor5_especie = getIntent().getStringExtra("ESPECIE");
    String valor6_historia = getIntent().getStringExtra("HISTORIA");


    recebe2_url.setText(valor2_url);
    recebe3_veiculo.setText(valor4_veiculo);
    recebe4_historia.setText(valor6_historia);
    recebe5_nome.setText(valor3_nome);
    recebe6_especie.setText(valor5_especie);
        ImageView imageView = findViewById(R.id.avatar);
        String url = valor2_url;
        Picasso.get().load(url).into(imageView);

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