package com.example.starwars.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starwars.model.Filme;

import java.util.List;

public class FilmeViewModel extends ViewModel {
    private static final String TAG= "FilmeViewModel";

    // os dados para as Views
    private MutableLiveData<List<Filme>> filmes;


    public MutableLiveData<List<Filme>> getAllFilmes() {
        if (filmes == null) {
            filmes = new MutableLiveData<List<Filme>>();
            loadFilmes();

        }
        return filmes;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        this.filmes = null;

    }

    private void loadFilmes() {

        //avatars.postValue(AvatarRepository.getInstance().getAllAvatars());
    }
}
