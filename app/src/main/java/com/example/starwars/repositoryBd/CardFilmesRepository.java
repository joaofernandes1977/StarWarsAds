package com.example.starwars.repositoryBd;

import com.example.starwars.R;
import com.example.starwars.model.Avatar;
import com.example.starwars.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CardFilmesRepository {
    private static final String TAG = "FilmeRepository";
    private List<Filme> mockupBanco;


    // construtor private para Singleton, ou seja ninguém consegue criar o repository
    private CardFilmesRepository() {
        super();
    }

    public List<Filme> getAllFilmes(){
        if (mockupBanco == null) {
            mockupBanco = new ArrayList<>();
        }
        if(mockupBanco.isEmpty()) {
            mockupBanco.add( new Filme("ROGUE ONE: UMA HISTÓRIA STAR WARS", "2016", "Ficção Cientifica", "2h:31", "A Aliança Rebelde faz um movimento arriscado e rouba os  planos da Estrela da Morte, a arma definitiva de destruição do Império.",
                    "15/12 br","Gareth Edwards\"","US$ 200 milhões","Lucasfilm Ltd.", R.drawable.rogueone));
            mockupBanco.add( new Filme("EPISÓDIO IV: UMA NOVA ESPERANÇA", "1977", "Ficção Cientifica", "2h:31", "A princesa Leia é mantida refém pelas forças imperiais comandadas por Darth Vader. Luke Skywalker e o capitão " +
                    "Han Solo precisam libertá-la e restaurar a liberdade e a justiça na galáxia.",
                    "18/11 br","George Lucas\"","775,8 milhões","Lucasfilm Ltd.", R.drawable.umanovaesperaca));

        }
        return mockupBanco;
    }
}
