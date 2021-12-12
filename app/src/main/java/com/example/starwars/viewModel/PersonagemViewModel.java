package com.example.starwars.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starwars.model.Filme;
import com.example.starwars.model.Personagem;

import java.util.List;

public class PersonagemViewModel extends ViewModel {
    private static final String TAG= "PersonagemViewModel";

    // os dados para as Views
    private MutableLiveData<List<Personagem>> personagens;


    public MutableLiveData<List<Personagem>> getAllPersonagem() {
        if (personagens == null) {
            personagens = new MutableLiveData<List<Personagem>>();
            loadPersonagens();

        }
        return personagens;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        this.personagens = null;

    }

    private void loadPersonagens() {

        //avatars.postValue(AvatarRepository.getInstance().getAllAvatars());
    }
}
