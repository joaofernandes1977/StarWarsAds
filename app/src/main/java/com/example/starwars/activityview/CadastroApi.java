package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.example.starwars.model.Personagen;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CadastroApi extends AppCompatActivity {

    private TextView  nome_api, url_api, historia_api ;
    private Button bt_cad_api, bt_voltar, bt_cad_planeta, bt_cad_nave;
    String[] msg = { " PREENCHER TODOS OS CAMPOS", "CADASTRO OK"};
    String userId, userId2;
    EditText nome_ed, url_ed, veiculo_ed, especie_ed, historia_ed;
    Personagen person = new Personagen();

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_api);
        getSupportActionBar().hide();
        iniciarComponentes();

        bt_cad_nave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome_a = nome_ed.getText().toString();
                String url_a = url_ed.getText().toString();
                String historia_a = historia_ed.getText().toString();

                person.setNome(nome_a);
                person.setUrlImage(url_a);
                person.setHistoria(historia_a);

                if ( url_a.isEmpty() || nome_a.isEmpty() || historia_a.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, msg[0], Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {

                    Snackbar snackbar = Snackbar.make(view, msg[1],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                    Intent intent = new Intent(CadastroApi.this, StarResultCadastroApi.class);
                    intent.putExtra("personagem", person);
                    intent.putExtra("NOME", nome_api.getText().toString());
                    intent.putExtra("URL", url_api.getText().toString());
                    intent.putExtra("HISTORIA", historia_api.getText().toString());


                    startActivity(intent);

                    SalvarDadosNave(person);


                }
            }
        });
        bt_cad_planeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome_a = nome_ed.getText().toString();
                String url_a = url_ed.getText().toString();
                String historia_a = historia_ed.getText().toString();

                person.setNome(nome_a);
                person.setUrlImage(url_a);
                person.setHistoria(historia_a);

                if ( url_a.isEmpty() || nome_a.isEmpty() || historia_a.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, msg[0], Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {

                    Snackbar snackbar = Snackbar.make(view, msg[1],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                    Intent intent = new Intent(CadastroApi.this, StarResultCadastroApi.class);
                    intent.putExtra("personagem", person);
                    intent.putExtra("NOME", nome_api.getText().toString());
                    intent.putExtra("URL", url_api.getText().toString());
                    intent.putExtra("HISTORIA", historia_api.getText().toString());


                    startActivity(intent);

                    SalvarDadosPlaneta(person);


                }
            }

        });

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroApi.this, PrincipalDrawerNav.class);
                startActivity(intent);
            }
        });
        nome_ed = (EditText)findViewById(R.id.nome_api);
        url_ed = (EditText)findViewById(R.id.url_api);
        historia_ed = (EditText) findViewById(R.id.historia_api);

        bt_cad_api = (Button)findViewById(R.id.bt_cadastrar_api);
        bt_cad_planeta = (Button)findViewById(R.id.cad_planeta);

        bt_cad_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome_a = nome_ed.getText().toString();
                String url_a = url_ed.getText().toString();
                String historia_a = historia_ed.getText().toString();

                person.setNome(nome_a);
                person.setUrlImage(url_a);
                person.setHistoria(historia_a);

                if ( url_a.isEmpty() || nome_a.isEmpty() || historia_a.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, msg[0], Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {

                    Snackbar snackbar = Snackbar.make(v, msg[1],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                    Intent intent = new Intent(CadastroApi.this, StarResultCadastroApi.class);
                    intent.putExtra("personagem", person);
                    intent.putExtra("NOME", nome_api.getText().toString());
                    intent.putExtra("URL", url_api.getText().toString());
                    intent.putExtra("HISTORIA", historia_api.getText().toString());


                    startActivity(intent);

                    SalvarDadosApi(person);

                    //finish();


                   /* new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {TelaCadastro();}
                    }, 2000);*/
                }
            }
        });

    }

    private void SalvarDadosApi( Personagen person) {

            DatabaseReference personagens = reference.child("Personagens");
            personagens.push().setValue( person );

    }
    private void SalvarDadosPlaneta( Personagen person) {

        DatabaseReference personagens = reference.child("Planetas");
        personagens.push().setValue( person );

    }
    private void SalvarDadosNave( Personagen person) {

        DatabaseReference personagens = reference.child("Naves");
        personagens.push().setValue( person );

    }

    private void iniciarComponentes(){


        nome_api = findViewById(R.id.nome_api);
        url_api = findViewById(R.id.url_api);
        historia_api = findViewById(R.id.historia_api);

        bt_voltar = findViewById(R.id.voltarprincipalCad);
        bt_cad_api = findViewById(R.id.bt_cadastrar_api);
        bt_cad_planeta = findViewById(R.id.cad_planeta);
        bt_cad_nave = findViewById(R.id.cad_nave);
    }

}