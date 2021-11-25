package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.starwars.PrincipalDrawerNav;
import com.example.starwars.R;
import com.example.starwars.adapters.FilmeAdapter;
import com.example.starwars.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CardViewFilmes extends AppCompatActivity {
    private RecyclerView recyclerFilme;
    private List<Filme> filmes = new ArrayList<>();
    private Button bt_voltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_filmes);
        recyclerFilme = findViewById(R.id.recyclerViewFilmes);
        getSupportActionBar().hide();
        iniciacomponentes();

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardViewFilmes.this, PrincipalDrawerNav.class);
                startActivity(intent);
            }
        });

        //layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //GRID LAYOUT - define em coluna e quantidade de colunas
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerFilme.setLayoutManager(layoutManager);

        //adapter
        this.preparaFilme();
        FilmeAdapter adapter = new FilmeAdapter(filmes);
        recyclerFilme.setAdapter(adapter);

    }

    public void preparaFilme(){
        Filme filme;
        filme = new Filme("ROGUE ONE: UMA HISTÓRIA STAR WARS", "2016", "Ficção Cientifica", "2h:31", "A Aliança Rebelde faz um movimento arriscado e rouba os  planos da Estrela da Morte, a arma definitiva de destruição do Império.",
                "15/12 br","Gareth Edwards\"","US$ 200 milhões","Lucasfilm Ltd.", R.drawable.rogueone);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO IV: UMA NOVA ESPERANÇA", "1977", "Ficção Cientifica", "2h:31", "A princesa Leia é mantida refém pelas forças imperiais comandadas por Darth Vader. Luke Skywalker e o capitão " +
                "Han Solo precisam libertá-la e restaurar a liberdade e a justiça na galáxia.",
                "18/11 br","George Lucas\"","775,8 milhões","Lucasfilm Ltd.", R.drawable.umanovaesperaca);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO V: O IMPÉRIO CONTRA-ATACA", "1980", "Ficção Cientifica", "2h:40", "Yoda treina Luke Skywalker para ser um cavaleiro Jedi. Han Solo corteja a Princesa Leia enquanto Darth Vader retorna para combater as forças rebeldes que tentam salvar a galáxia." +
                "retorna para combater as forças rebeldes que tentam salvar a galáxia.",
                "04/02 br","Irvin Kershner\"","US$ 18 milhões","Lucasfilm Ltd.", R.drawable.imperiocontraataca);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO I: A AMEAÇA FANTASMA", "1999", "Ficção Cientifica", "2h:16", "Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.",
                "24/12 br","George Lucas\"","US$ 115 milhões","Lucasfilm Ltd.", R.drawable.ameacafantasma);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO II: ATAQUE DOS CLONES", "2002", "Ficção Cientifica", "2h:22", "Tentado por promessas de poder, Anakin Skywalker se aproxima de Darth Sidious e participa de um plano para acabar com os Cavaleiros Jedi." +
                "retorna para combater as forças rebeldes que tentam salvar a galáxia.",
                "16/05 br","George Lucas\"","US$ 115 milhões","Lucasfilm Ltd.", R.drawable.ataquedosclones);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO III: A VINGANÇA DOS SITH", "2005", "Ficção Cientifica", "2h:20", "As Guerras Clônicas estão em pleno andamento e Anakin Skywalker mantém um elo de lealdade com Palpatine, ao mesmo tempo em que luta para que seu casamento com Padmé Amidala não seja afetado por esta situação. Seduzido por promessas de poder, Anakin se aproxima cada vez mais de Darth Sidious até se tornar o temível Darth Vader. Juntos eles tramam um plano para aniquilar de uma vez por todas com os cavaleiros jedi.",
                "19/05 br","George Lucas\"","US$ 113 milhões","Lucasfilm Ltd.", R.drawable.avingancadosith);
        filmes.add(filme);

        filme = new Filme("HAN SOLO: UMA HISTÓRIA STAR WARS", "2018", "Ficção Cientifica", "2h:15", "Em dificuldade financeira, o piloto Han Solo e sua namorada Qi'ra buscam trabalho. Eles colocam as mãos em uma substância valiosa, mas perigosa, e que acaba levando à perseguição do Império e à separação entre os dois. Preocupado, Han usa toda a sua esperteza para se infiltrar em um plano arriscado, mas que pode render a oportunidade de voltar à terra natal e reencontrar a sua amada. No caminho, o piloto encontra parceiros importantes, como Chewbacca e Lando Calrissian.",
                "24/05 br","Ron Howard\"","US$ 392 milhões","Lucasfilm Ltd.", R.drawable.umahistoriahan);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO VI: O RETORNO DO JEDI", "1983", "Ficção Cientifica", "2h:11", "Luke Skywalker e seus amigos viajam para Tatooine e salvam seu amigo Han Solo do lorde do crime Jabba o Hutt. O Império Galático começou a construção de uma segunda Estrela da Morte, visando aniquilar a Aliança Rebelde, mas seu término está comprometido pela Frota Rebelde, que insiste em dar um fim ao Império. Neste meio tempo, Luke Skywalker luta para resgatar Vader, um ex-Jedi, de volta do lado sombrio da Força.",
                "06/08 br","Richard Marquand\"","US$ 475,1 milhões","Lucasfilm Ltd.", R.drawable.oretornodejedi);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO VII: O DESPERTAR DA FORÇA", "2015", "Ficção Cientifica", "2h:16", "A queda de Darth Vader e do Império levou ao surgimento de uma nova força sombria: a Primeira Ordem. Eles procuram o jedi Luke Skywalker, desaparecido. A resistência tenta desesperadamente encontrá-lo antes para salvar a galáxia.",
                "17/12 br","J.J. Abrams\"","US$ 2,066 bilhões","Lucasfilm Ltd.", R.drawable.despertardaforca);
        filmes.add(filme);
//FALTA DADOS
        filme = new Filme("EPISÓDIO VIII: OS ÚLTIMOS JEDI", "2017", "Ficção Cientifica", "2h:32", "A tranquila e solitária vida de Luke Skywalker sofre uma reviravolta quando ele conhece Rey, uma jovem que mostra fortes sinais da Força. O desejo dela de aprender o estilo dos Jedi força Luke a tomar uma decisão que mudará sua vida para sempre. Enquanto isso, Kylo Ren e o General Hux lideram a Primeira Ordem para um ataque total contra Leia e a Resistência pela supremacia da galáxia.",
                "14/12 br","Rian Johnson\"","US$ 1,333 bilhões","Lucasfilm Ltd.", R.drawable.osultimosjedi);
        filmes.add(filme);

        filme = new Filme("EPISÓDIO IX: A ASCENSÃO SKYWALKER", "2019", "Ficção Cientifica", "2h:22", "Com o retorno do Imperador Palpatine, a Resistência toma a frente da batalha. Treinando para ser uma completa Jedi, Rey se encontra em conflito com passado e futuro, e teme pelas respostas que pode conseguir com Kylo Ren.",
                "19/12 br","J.J. Abrams\"","US$ 300 milhões","Lucasfilm Ltd.", R.drawable.aascensaosky);
        filmes.add(filme);
    }

    public void iniciacomponentes(){

        bt_voltar = findViewById(R.id.voltarprincipal2);
    }


}