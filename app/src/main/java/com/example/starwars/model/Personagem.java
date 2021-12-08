package com.example.starwars.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Personagem implements Parcelable {
    //todos
    private String nome;
    private String sobre;
    private String url;

    //users

    public Personagem(String id, String title, String url){
        this.nome = id;
        this.sobre = title;
        this.url = url;

    }
    public Personagem(JSONObject json) {
        super();
        try {
            this.nome = json.getString("nome");
            this.sobre = json.getString("sobre");
            this.url = json.getString("url");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Personagem(Parcel in) {
        nome = in.readString();
        sobre = in.readString();
        url = in.readString();
    }

    public static final Creator<Personagem> CREATOR = new Creator<Personagem>() {
        @Override
        public Personagem createFromParcel(Parcel in) {
            return new Personagem(in);
        }

        @Override
        public Personagem[] newArray(int size) {
            return new Personagem[size];
        }
    };

    @Override
    public String toString(){
        return "id: "+nome+"\n"+
                "Id usuario: "+url+"\n"+
                "Titulo:" + sobre+"\n-------------------\n";

    }



    public String getId() {
        return nome;
    }

    public void setId(String id) {
        this.nome = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getTitle() {
        return sobre;
    }

    public void setTitle(String title) {
        this.sobre = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personagem that = (Personagem) o;
        return nome == that.nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nome);
        parcel.writeString(this.sobre);
        parcel.writeString(this.url);
    }
}
