package com.example.starwars;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.starwars.adapters.UserAdapter;
import com.example.starwars.model.User;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_layout);
        buscaJason();
        getSupportActionBar().hide();
    }
    private void buscaJason(){
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/users",
                null, (Response.Listener<JSONArray>) this, this);
        queue.add(requisicao);
    }


    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        users.clear();
        //ed.setText(response.toString());
        try {
            //for (int x = 0; x < 10; x++){
            for (int i = 0; i < response.length(); i++) {
                users.add(new User(response.getJSONObject(i)));
            }
            //}
            RecyclerView rv = findViewById(R.id.usersRv);
            UserAdapter adapter = new UserAdapter(users);
            //LinearLayoutManager llm = new LinearLayoutManager(this);
            //LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);

            rv.setLayoutManager(sglm);
            rv.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "deu certo" + error.getMessage(), Toast.LENGTH_LONG).show();


    }
}
