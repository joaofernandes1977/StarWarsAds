package com.example.starwars.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starwars.model.Avatar;
import com.example.starwars.repositoryBd.AvatarRepository;

import java.util.List;

public class AvatarViewModel extends ViewModel {
    private static final String TAG= "AvatarViewModel";

    // os dados para as Views
    private MutableLiveData<List<Avatar>> avatars;


    public LiveData<List<Avatar>> getAllAvatars() {
        if (avatars == null) {
            avatars = new MutableLiveData<List<Avatar>>();
            loadAvatars();

        }
        return avatars;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        this.avatars = null;

    }

    private void loadAvatars() {

       //avatars.postValue(AvatarRepository.getInstance().getAllAvatars());
    }


}
