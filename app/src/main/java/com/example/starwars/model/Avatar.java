package com.example.starwars.model;

import android.widget.ImageView;

public class Avatar {
    String nome, url;

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

    public Avatar() {
    }

    public Avatar(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }
}


