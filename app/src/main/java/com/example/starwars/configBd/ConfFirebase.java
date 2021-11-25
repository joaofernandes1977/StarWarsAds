package com.example.starwars.configBd;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfFirebase {
    private static DatabaseReference database;
    private static FirebaseAuth auth;

    //retorna a instancia do FirebaseReference
    public static  DatabaseReference getFirebaseDatabase(){
        if (database == null){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return  database;
    }
    //retorna a instancia do FirebaseAuth
    public static  FirebaseAuth getFirebaseAuth(){
        if (auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return  auth;
    }

}
