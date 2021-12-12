package com.example.starwars.activityview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.example.starwars.adapters.NaveAdapter;
import com.example.starwars.adapters.PersonagemAdapter;
import com.example.starwars.adapters.PlanetaAdapter;
import com.example.starwars.model.Nave;
import com.example.starwars.model.Personagem;
import com.example.starwars.model.Planeta;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PersonagemActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<Personagem> personagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);
        getSupportActionBar().hide();
        buscaJason();
        //ImageView iv = findViewById(R.id.imageView);
        //Picasso.get().load("https://loja.uniritteronline.com.br/media/logo/stores/35/UNIRITTER.png").into(iv);
        //ImageView imageView = findViewById(R.id.imageView2);
        //String url = "https://loja.uniritteronline.com.br/media/logo/stores/35/UNIRITTER.png";
       // Picasso.get().load(url).into(imageView);

    }
    private void buscaJason(){
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://waie.com.br/json/personagem.html",
                null, (Response.Listener<JSONArray>) this, this);
        queue.add(requisicao);


    }


    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        personagens.clear();
        //ed.setText(response.toString());
        try {
            //for (int x = 0; x < 10; x++){
            for (int i = 0; i < response.length(); i++) {
                personagens.add(new Personagem(response.getJSONObject(i)));
            }
            //}

            RecyclerView rv = findViewById(R.id.personagemRw);
            PersonagemAdapter adapter = new PersonagemAdapter(personagens);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);

            rv.setLayoutManager(sglm);
            rv.setAdapter(adapter);

            //ImageView iv = findViewById(R.id.imageView);
            //Picasso.get().load("https://via.placeholder.com/150/92c952").into(iv);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public  void voltar(View view){

        Intent intent = new Intent(PersonagemActivity.this, ApisJsonActivity.class);
        startActivity(intent);
    }
    public  void voltarHome(View view){

        Intent intent = new Intent(PersonagemActivity.this, PrincipalDrawerNav.class);
        startActivity(intent);
    }
    public void novopersonagem(View view){
        Intent intent = new Intent(PersonagemActivity.this, CadastroApi.class);
        startActivity(intent);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "deu certo" + error.getMessage(), Toast.LENGTH_LONG).show();


    }
}

