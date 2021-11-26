package com.example.starwars.repositoryBd;



import android.util.Log;

import com.example.starwars.model.Avatar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AvatarRepository {
    private static final String TAG = "AvatarRepository";
    private List<Avatar> mockupBanco;


    // construtor private para Singleton, ou seja ninguém consegue criar o repository
    private AvatarRepository() {
        super();
    }



    public List<Avatar> getAllAvatars(){
        if (mockupBanco == null) {
            mockupBanco = new ArrayList<>();
        }
        if(mockupBanco.isEmpty()) {
            mockupBanco.add( new Avatar("MESTRE YODA", "https://waie.com.br/starwars/1-yoda-300x300.png"));
            mockupBanco.add( new Avatar("DARTH VADER", "https://waie.com.br/starwars/2-darth_vader-300x300.png"));

        }
        return mockupBanco;
    }
    public Avatar getAvatar(){
        if (mockupBanco.isEmpty()) {
            mockupBanco.add(new Avatar("MESTRE YODA", "https://waie.com.br/starwars/1-yoda-300x300.png"));
        }
        return (Avatar) mockupBanco;
    }

}




