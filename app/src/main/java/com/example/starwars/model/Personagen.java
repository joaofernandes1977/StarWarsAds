package com.example.starwars.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Personagen implements Parcelable {
        String  nome, urlImage, especie, veiculo, historia;

    protected Personagen(Parcel in) {

        nome = in.readString();
        urlImage = in.readString();
        especie = in.readString();
        veiculo = in.readString();
        historia = in.readString();
    }

    public static final Creator<Personagen> CREATOR = new Creator<Personagen>() {
        @Override
        public Personagen createFromParcel(Parcel in) {
            return new Personagen(in);
        }

        @Override
        public Personagen[] newArray(int size) {
            return new Personagen[size];
        }
    };



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Personagen() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(nome);
        parcel.writeString(urlImage);
        parcel.writeString(especie);
        parcel.writeString(veiculo);
        parcel.writeString(historia);
    }
}
