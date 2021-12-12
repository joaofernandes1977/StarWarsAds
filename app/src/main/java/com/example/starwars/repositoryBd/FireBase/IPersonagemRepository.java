package com.example.starwars.repositoryBd.FireBase;

import android.content.Context;

import com.example.starwars.model.Avatar;
import com.example.starwars.model.Personagem;

import java.util.List;

public abstract class IPersonagemRepository {

    //implementação de Singleton
    protected static IPersonagemRepository repo;
    protected static Context context;

    public abstract List<Personagem> getAllPersonagens();
    public abstract Avatar getAvatar();
    public  abstract void gravaPersonagem(Personagem personagem);

    // recebe o context
    public static void setContext(Context contexto) {
        context = contexto;
    }


}