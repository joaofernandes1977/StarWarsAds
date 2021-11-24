package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.starwars.R;
import com.example.starwars.fragment.CadastroapiFragment;
import com.example.starwars.fragment.UserlogFragment;

public class StarPrincipalFragments extends AppCompatActivity {
    private Button btnovaApi, btconsultaApi, btUserlog;
    private CadastroapiFragment cadastroapiFragment;
    //private ConsultaApiFragment consultaApiFragment;
    private UserlogFragment userlogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_fragments);
        getSupportActionBar().hide();

    btnovaApi = findViewById(R.id.novoPersonagem);
    btconsultaApi = findViewById(R.id.consultaApi);
    btUserlog = findViewById(R.id.usuarioLogado);

    cadastroapiFragment = new CadastroapiFragment();
    //consultaApiFragment = new ConsultaApiFragment();
    userlogFragment = new UserlogFragment();

    btnovaApi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameConteudo,cadastroapiFragment );
            transaction.commit();

        }
    });
    /*
    btconsultaApi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameConteudo,consultaApiFragment );
            transaction.commit();
        }
    });
    */

    btUserlog.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameConteudo,userlogFragment );
            transaction.commit();
        }
    });
    }
}