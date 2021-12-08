package com.example.starwars.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Nave implements Parcelable {
    //todos
    private String nome;
    private String descricao;
    private String url;

    //users

    public Nave(String nome, String descricao, String url){
        this.nome = nome;
        this.descricao = descricao;
        this.url = url;

    }
    public Nave(JSONObject json) {
        super();
        try {
            this.nome = json.getString("nome");
            this.descricao = json.getString("descricao");
            this.url = json.getString("url");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Nave(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        url = in.readString();
    }

    public static final Creator<Nave> CREATOR = new Creator<Nave>() {
        @Override
        public Nave createFromParcel(Parcel in) {
            return new Nave(in);
        }

        @Override
        public Nave[] newArray(int size) {
            return new Nave[size];
        }
    };

    @Override
    public String toString(){
        return "Nome: "+nome+"\n"+
                "Url: "+url+"\n"+
                "Descriçao:" + descricao+"\n-------------------\n";

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planeta that = (Planeta) o;
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
        parcel.writeString(this.descricao);
        parcel.writeString(this.url);
    }
}
