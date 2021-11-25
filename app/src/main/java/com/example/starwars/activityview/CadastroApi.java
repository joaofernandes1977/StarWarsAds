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

public class CadastroApi extends AppCompatActivity {

    private TextView id_api, nome_api, url_api, historia_api, especie_api, veiculo_api;
    private Button bt_cad_api, bt_voltar;
    String[] msg = { " PREENCHER TODOS OS CAMPOS", "CADASTRO OK"};
    String userId, userId2;
    EditText id_ed, nome_ed, url_ed, veiculo_ed, especie_ed, historia_ed;
    Personagen person = new Personagen();

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_api);
        getSupportActionBar().hide();
        iniciarComponentes();


        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroApi.this, PrincipalDrawerNav.class);
                startActivity(intent);
            }
        });
        nome_ed = (EditText)findViewById(R.id.nome_api);
        id_ed = (EditText)findViewById(R.id.id_api);
        url_ed = (EditText)findViewById(R.id.url_api);
        veiculo_ed = (EditText)findViewById(R.id.veiculo_api);
        especie_ed = (EditText) findViewById(R.id.especie_api);
        historia_ed = (EditText) findViewById(R.id.historia_api);

        bt_cad_api = (Button)findViewById(R.id.bt_cadastrar_api);


        bt_cad_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_a = id_ed.getText().toString();
                String nome_a = nome_ed.getText().toString();
                String url_a = url_ed.getText().toString();
                String veiculo_a = veiculo_ed.getText().toString();
                String especie_a = especie_ed.getText().toString();
                String historia_a = historia_ed.getText().toString();


                person.setId(id_a);
                person.setNome(nome_a);
                person.setUrlImage(url_a);
                person.setEspecie(especie_a);
                person.setVeiculo(veiculo_a);
                person.setHistoria(historia_a);


                if (id_a.isEmpty() || url_a.isEmpty() || nome_a.isEmpty() || veiculo_a.isEmpty() || especie_a.isEmpty() || historia_a.isEmpty()){
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

            DatabaseReference personagens = reference.child("Personagen");
            personagens.push().setValue( person );

    }

    private void iniciarComponentes(){

        id_api = findViewById(R.id.id_api);
        nome_api = findViewById(R.id.nome_api);
        url_api = findViewById(R.id.url_api);
        historia_api = findViewById(R.id.historia_api);
        veiculo_api = findViewById(R.id.veiculo_api);
        especie_api = findViewById(R.id.especie_api);
        bt_voltar = findViewById(R.id.voltarprincipalCad);
        bt_cad_api = findViewById(R.id.bt_cadastrar_api);
    }

}