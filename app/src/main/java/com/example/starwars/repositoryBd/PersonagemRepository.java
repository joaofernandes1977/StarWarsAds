package com.example.starwars.repositoryBd;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.starwars.model.Avatar;
import com.example.starwars.model.Personagem;
import com.example.starwars.repositoryBd.FireBase.IAvatarRepository;
import com.example.starwars.repositoryBd.FireBase.IPersonagemRepository;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class PersonagemRepository extends IPersonagemRepository {

    private static final String TAG = "PersonagemRepository";
    private List<Avatar> mockupBanco1;
    private List<Avatar> mockupBanco = new ArrayList<>();


    // construtor private para Singleton, ou seja ninguém consegue criar o repository
    private PersonagemRepository() {
        super();
    }

    public static IPersonagemRepository getInstance() {
        if (repo == null) {
            repo = new PersonagemRepository();
        }
        return repo;
    }





    @Override
    public List<Personagem> getAllPersonagens() {
        return null;
    }

    public Personagem constroiPersonagem(){


        return (Personagem) mockupBanco;
    }
    public Avatar getAvatar() {
        //.isEmpty()
        if (mockupBanco == null) {
            mockupBanco.add(new Avatar("MESTRE YODA", "https://waie.com.br/starwars/1-yoda-300x300.png"));
        }
        return mockupBanco.get(0);
    }

    @Override
    public void gravaPersonagem(Personagem personagem) {

    }





}

