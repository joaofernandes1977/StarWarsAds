package com.example.starwars.repositoryBd;



import com.example.starwars.model.Avatar;
import com.example.starwars.repositoryBd.FireBase.IAvatarRepository;
import com.example.starwars.viewModel.AvatarViewModel;

import java.util.ArrayList;
import java.util.List;

public class AvatarRepository extends IAvatarRepository {
    private static final String TAG = "AvatarRepository";
    private List<Avatar> mockupBanco1;
    private List<Avatar> mockupBanco = new ArrayList<>();


    // construtor private para Singleton, ou seja ninguém consegue criar o repository
    private AvatarRepository() {
        super();
    }

    public static IAvatarRepository getInstance() {
        if (repo == null) {
            repo = new AvatarRepository();
        }
        return repo;
    }


    public List<Avatar> getAllAvatars() {


        if(mockupBanco.isEmpty()) {
            mockupBanco.add( new Avatar("MESTRE YODA", "https://waie.com.br/starwars/1-yoda-300x300.png"));
            mockupBanco.add( new Avatar("DARTH VADER", "https://waie.com.br/starwars/2-darth_vader-300x300.png"));

            mockupBanco.add( new Avatar("ANAKIN", "https://waie.com.br/starwars/3-anakin-300x300.png"));

            mockupBanco.add( new Avatar("CHEWBACCA", "https://waie.com.br/starwars/5-chewbacca-300x300.png"));

            mockupBanco.add( new Avatar("LEIA", "https://waie.com.br/starwars/4-leia-1-300x300.png"));

            mockupBanco.add( new Avatar("R2D2", "https://waie.com.br/starwars/6-R2D2-300x300.png"));

            mockupBanco.add( new Avatar("OBI WAN", "https://waie.com.br/starwars/7-obi_wan_kenobi-300x300.png"));

            mockupBanco.add( new Avatar("JAR JAR", "https://waie.com.br/starwars/8-jar_jar-300x300.png"));

            mockupBanco.add( new Avatar("LUKE SKYWALKER", "https://waie.com.br/starwars/9-luke-300x300.png"));

            mockupBanco.add( new Avatar("PALPATINE", "https://waie.com.br/starwars/10-palpatine-1-300x300.png"));

            mockupBanco.add( new Avatar("HAN SOLO", "https://waie.com.br/starwars/11-han_solo-300x300.png"));

            mockupBanco.add( new Avatar("AMIDALA", "https://waie.com.br/starwars/12-amidala-300x300.png"));

            mockupBanco.add( new Avatar("BOBA", "https://waie.com.br/starwars/13-boba-300x300.png"));

            mockupBanco.add( new Avatar("C3PO", "https://waie.com.br/starwars/14-C3PO-300x300.png"));

            mockupBanco.add( new Avatar("DARTH MAUL", "https://waie.com.br/starwars/15-darth_maul-300x300.png"));

            mockupBanco.add( new Avatar("DARTH SIDIOUS", "https://waie.com.br/starwars/16-darth_sidious-1-300x300.png"));

            mockupBanco.add( new Avatar("DOOKU", "https://waie.com.br/starwars/17-dooku-300x300.png"));

            mockupBanco.add( new Avatar("FINN", "https://waie.com.br/starwars/18-finn-300x300.png"));

            mockupBanco.add( new Avatar("KYLO REN", "https://waie.com.br/starwars/19-kylo_ren-300x300.png"));

            mockupBanco.add( new Avatar("GENERAL HUX", "https://waie.com.br/starwars/20-general_hux-300x300.png"));

            mockupBanco.add( new Avatar("GENERAL TARKIN", "https://waie.com.br/starwars/21-general_tarkin-1-300x300.png"));

            mockupBanco.add( new Avatar("GRIEVOUS", "https://waie.com.br/starwars/22-grievous-300x300.png"));

            mockupBanco.add( new Avatar("ACKBAR", "https://waie.com.br/starwars/23-ackbar-300x300.png"));

            mockupBanco.add( new Avatar("JABBA", "https://waie.com.br/starwars/24-jabba-300x300.png"));

            mockupBanco.add( new Avatar("JANGO", "https://waie.com.br/starwars/25-jango-300x300.png"));

            mockupBanco.add( new Avatar("LANDO", "https://waie.com.br/starwars/26-lando-300x300.png"));

            mockupBanco.add( new Avatar("MACE", "https://waie.com.br/starwars/27-mace-300x300.png"));

            mockupBanco.add( new Avatar("PASHMA", "https://waie.com.br/starwars/28-pashma-300x300.png"));

            mockupBanco.add( new Avatar("DAMERON", "https://waie.com.br/starwars/29-poe_dameron-300x300.png"));

            mockupBanco.add( new Avatar("QUIN GON JINN", "https://waie.com.br/starwars/30-quin_gon_jinn-300x300.png"));

            mockupBanco.add( new Avatar("REY", "https://waie.com.br/starwars/31-rey-300x300.png"));

            mockupBanco.add( new Avatar("STORMTROOPER", "https://waie.com.br/starwars/32-stormtrooper-300x300.png"));

        }

        return mockupBanco;

    }



    public Avatar getAvatar() {
        //.isEmpty()
        if (mockupBanco == null) {
            mockupBanco.add(new Avatar("MESTRE YODA", "https://waie.com.br/starwars/1-yoda-300x300.png"));
        }
        return mockupBanco.get(0);
    }

    @Override
    public void gravaAvatar(Avatar avatar) {

    }

    public void getAllAvatar() {
        mockupBanco.add(new Avatar("MESTRE YODA", "https://waie.com.br/starwars/1-yoda-300x300.png"));
    }

}




