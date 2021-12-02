package com.example.starwars.repositoryBd.FireBase;

import android.content.Context;

import com.example.starwars.model.Avatar;

import java.util.List;

public abstract class IAvatarRepository {

        //implementação de Singleton
        protected static IAvatarRepository repo;
        protected static Context context;

        public abstract List<Avatar> getAllAvatars();
        public abstract Avatar getAvatar();
        public  abstract void gravaAvatar(Avatar avatar);

        // recebe o context
        public static void setContext(Context contexto) {
            context = contexto;
        }


}
