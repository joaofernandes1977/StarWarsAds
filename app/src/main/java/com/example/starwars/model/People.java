package com.example.starwars.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class People implements Parcelable {


    //todos

    private String name;

    private String height;

    private String mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthYear;

    private String gender;

    private String homeworld;

    private List<String> films = null;

    private List<String> species = null;

    private List<String> vehicles = null;

    private List<String> starships = null;

    private String created;

    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public People(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender,

                  String homeworld, List<String> films, List<String> species, List<String> vehicles, List<String> starships, String created, String edited, String url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }
    public People(JSONObject json) {
        super();
        try {
            this.name = json.getString("name");
            this.birthYear = json.getString("birth_year");
            this.eyeColor = json.getString("eye_color");
            this.gender = json.getString("gender");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected People(Parcel in) {
        name = in.readString();
        birthYear = in.readString();
        eyeColor = in.readString();
        gender = in.readString();


    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public String toString(){
        return "nome: "+name+"\n"+
                "Aniversario: "+birthYear+"\n"+
                "CorOlhos:" + eyeColor+"\n-------------------\n"+
                "Gender:" + gender+"\n-------------------\n"
                ;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.birthYear);
        parcel.writeString(this.eyeColor);
        parcel.writeString(this.gender);
        parcel.writeString(this.hairColor);
        parcel.writeString(this.height);
        parcel.writeString(this.mass);
        parcel.writeString(this.skinColor);
        parcel.writeString(this.homeworld);
        parcel.writeString(String.valueOf(this.films));
        parcel.writeString(String.valueOf(this.species));
        parcel.writeString(String.valueOf(this.starships));
        parcel.writeString(String.valueOf(this.vehicles));
        parcel.writeString(this.created);
        parcel.writeString(this.edited);
        parcel.writeString(this.url);


    }
}


