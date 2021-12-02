package com.example.starwars.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starwars.model.Avatar;
import com.example.starwars.repositoryBd.AvatarRepository;
import com.example.starwars.repositoryBd.FireBase.IAvatarRepository;

import java.util.List;

public class AvatarViewModel extends ViewModel {
    private static final String TAG= "AvatarViewModel";

    // os dados para as Views
    private MutableLiveData<List<Avatar>> avatars;
    private MutableLiveData<Avatar> avatar;
    private IAvatarRepository repository;

    public AvatarViewModel(){
        repository = AvatarRepository.getInstance();
    }


    public LiveData<List<Avatar>> getAllAvatars() {
        if (avatars == null) {
            avatars = new MutableLiveData<List<Avatar>>();
            loadAvatars();

        }
        return avatars;
    }



    public LiveData<Avatar> getAvatar() {

            avatar = new MutableLiveData<>(repository.getAvatar());

       return avatar;
    }

        @Override
        protected void onCleared() {
            super.onCleared();
            this.avatars = null;
            this.avatar = null;

        }


        private void loadAvatars() {

            avatars.postValue(AvatarRepository.getInstance().getAllAvatars());
        }

}
