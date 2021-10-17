package com.example.starwars.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class User implements Parcelable {

    private String nome;
    private String email;

    private User( String nome, String email){
        this.nome = nome;
        this.email = email;

    }
    public User(JSONObject json){
        super();
        try {
            this.nome = json.getString("nome");
            this.email = json.getString("email");
        } catch ( JSONException e){
            e.printStackTrace();
        }

    }


    protected User(Parcel in) {
        nome = in.readString();
        email = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return nome;
    }
    public void setName(String name) {
        this.nome = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(email);
    }
}
