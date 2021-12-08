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
import com.example.starwars.adapters.PlanetaAdapter;
import com.example.starwars.model.Nave;
import com.example.starwars.model.Planeta;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class NavesActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<Nave> naves = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naves);
        getSupportActionBar().hide();
        buscaJason();


    }
    private void buscaJason(){
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://waie.com.br/json/naves.html",
                null, (Response.Listener<JSONArray>) this, this);
        queue.add(requisicao);
    }


    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        naves.clear();
        //ed.setText(response.toString());
        try {
            //for (int x = 0; x < 10; x++){
            for (int i = 0; i < response.length(); i++) {
                naves.add(new Nave(response.getJSONObject(i)));
            }
            //}

            RecyclerView rv = findViewById(R.id.navesRw);
            NaveAdapter adapter = new NaveAdapter(naves);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);

            rv.setLayoutManager(llm);
            rv.setAdapter(adapter);

            //ImageView iv = findViewById(R.id.imageView);
            //Picasso.get().load("https://via.placeholder.com/150/92c952").into(iv);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Erro na requisição VOLLEY" + error.getMessage(), Toast.LENGTH_LONG).show();


    }



    public  void voltar(View view){

        Intent intent = new Intent(NavesActivity.this, ApisJsonActivity.class);
        startActivity(intent);
    }
    public  void voltarHome(View view){

        Intent intent = new Intent(NavesActivity.this, PrincipalDrawerNav.class);
        startActivity(intent);
    }
}