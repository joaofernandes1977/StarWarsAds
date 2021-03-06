package com.example.starwars.activityview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

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
    public void rodarVideo(View view){
        Intent intent = new Intent(CardViewFilmes.this, PlayerVideo.class);
        startActivity(intent);
    }

    public void preparaFilme(){
        Filme filme;
        filme = new Filme("ROGUE ONE: UMA HIST??RIA STAR WARS", "2016", "Fic????o Cientifica", "2h:31", "A Alian??a Rebelde faz um movimento arriscado e rouba os  planos da Estrela da Morte, a arma definitiva de destrui????o do Imp??rio.",
                "15/12 br","Gareth Edwards\"","US$ 200 milh??es","Lucasfilm Ltd.", R.drawable.rogueone);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO IV: UMA NOVA ESPERAN??A", "1977", "Fic????o Cientifica", "2h:31", "A princesa Leia ?? mantida ref??m pelas for??as imperiais comandadas por Darth Vader. Luke Skywalker e o capit??o " +
                "Han Solo precisam libert??-la e restaurar a liberdade e a justi??a na gal??xia.",
                "18/11 br","George Lucas\"","775,8 milh??es","Lucasfilm Ltd.", R.drawable.umanovaesperaca);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO V: O IMP??RIO CONTRA-ATACA", "1980", "Fic????o Cientifica", "2h:40", "Yoda treina Luke Skywalker para ser um cavaleiro Jedi. Han Solo corteja a Princesa Leia enquanto Darth Vader retorna para combater as for??as rebeldes que tentam salvar a gal??xia." +
                "retorna para combater as for??as rebeldes que tentam salvar a gal??xia.",
                "04/02 br","Irvin Kershner\"","US$ 18 milh??es","Lucasfilm Ltd.", R.drawable.imperiocontraataca);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO I: A AMEA??A FANTASMA", "1999", "Fic????o Cientifica", "2h:16", "Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem trein??-lo para se tornar um Jedi. Mas o tempo ir?? revelar que as coisas nem sempre s??o o que aparentam ser.",
                "24/12 br","George Lucas\"","US$ 115 milh??es","Lucasfilm Ltd.", R.drawable.ameacafantasma);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO II: ATAQUE DOS CLONES", "2002", "Fic????o Cientifica", "2h:22", "Tentado por promessas de poder, Anakin Skywalker se aproxima de Darth Sidious e participa de um plano para acabar com os Cavaleiros Jedi." +
                "retorna para combater as for??as rebeldes que tentam salvar a gal??xia.",
                "16/05 br","George Lucas\"","US$ 115 milh??es","Lucasfilm Ltd.", R.drawable.ataquedosclones);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO III: A VINGAN??A DOS SITH", "2005", "Fic????o Cientifica", "2h:20", "As Guerras Cl??nicas est??o em pleno andamento e Anakin Skywalker mant??m um elo de lealdade com Palpatine, ao mesmo tempo em que luta para que seu casamento com Padm?? Amidala n??o seja afetado por esta situa????o. Seduzido por promessas de poder, Anakin se aproxima cada vez mais de Darth Sidious at?? se tornar o tem??vel Darth Vader. Juntos eles tramam um plano para aniquilar de uma vez por todas com os cavaleiros jedi.",
                "19/05 br","George Lucas\"","US$ 113 milh??es","Lucasfilm Ltd.", R.drawable.avingancadosith);
        filmes.add(filme);

        filme = new Filme("HAN SOLO: UMA HIST??RIA STAR WARS", "2018", "Fic????o Cientifica", "2h:15", "Em dificuldade financeira, o piloto Han Solo e sua namorada Qi'ra buscam trabalho. Eles colocam as m??os em uma subst??ncia valiosa, mas perigosa, e que acaba levando ?? persegui????o do Imp??rio e ?? separa????o entre os dois. Preocupado, Han usa toda a sua esperteza para se infiltrar em um plano arriscado, mas que pode render a oportunidade de voltar ?? terra natal e reencontrar a sua amada. No caminho, o piloto encontra parceiros importantes, como Chewbacca e Lando Calrissian.",
                "24/05 br","Ron Howard\"","US$ 392 milh??es","Lucasfilm Ltd.", R.drawable.umahistoriahan);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO VI: O RETORNO DO JEDI", "1983", "Fic????o Cientifica", "2h:11", "Luke Skywalker e seus amigos viajam para Tatooine e salvam seu amigo Han Solo do lorde do crime Jabba o Hutt. O Imp??rio Gal??tico come??ou a constru????o de uma segunda Estrela da Morte, visando aniquilar a Alian??a Rebelde, mas seu t??rmino est?? comprometido pela Frota Rebelde, que insiste em dar um fim ao Imp??rio. Neste meio tempo, Luke Skywalker luta para resgatar Vader, um ex-Jedi, de volta do lado sombrio da For??a.",
                "06/08 br","Richard Marquand\"","US$ 475,1 milh??es","Lucasfilm Ltd.", R.drawable.oretornodejedi);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO VII: O DESPERTAR DA FOR??A", "2015", "Fic????o Cientifica", "2h:16", "A queda de Darth Vader e do Imp??rio levou ao surgimento de uma nova for??a sombria: a Primeira Ordem. Eles procuram o jedi Luke Skywalker, desaparecido. A resist??ncia tenta desesperadamente encontr??-lo antes para salvar a gal??xia.",
                "17/12 br","J.J. Abrams\"","US$ 2,066 bilh??es","Lucasfilm Ltd.", R.drawable.despertardaforca);
        filmes.add(filme);
//FALTA DADOS
        filme = new Filme("EPIS??DIO VIII: OS ??LTIMOS JEDI", "2017", "Fic????o Cientifica", "2h:32", "A tranquila e solit??ria vida de Luke Skywalker sofre uma reviravolta quando ele conhece Rey, uma jovem que mostra fortes sinais da For??a. O desejo dela de aprender o estilo dos Jedi for??a Luke a tomar uma decis??o que mudar?? sua vida para sempre. Enquanto isso, Kylo Ren e o General Hux lideram a Primeira Ordem para um ataque total contra Leia e a Resist??ncia pela supremacia da gal??xia.",
                "14/12 br","Rian Johnson\"","US$ 1,333 bilh??es","Lucasfilm Ltd.", R.drawable.osultimosjedi);
        filmes.add(filme);

        filme = new Filme("EPIS??DIO IX: A ASCENS??O SKYWALKER", "2019", "Fic????o Cientifica", "2h:22", "Com o retorno do Imperador Palpatine, a Resist??ncia toma a frente da batalha. Treinando para ser uma completa Jedi, Rey se encontra em conflito com passado e futuro, e teme pelas respostas que pode conseguir com Kylo Ren.",
                "19/12 br","J.J. Abrams\"","US$ 300 milh??es","Lucasfilm Ltd.", R.drawable.aascensaosky);
        filmes.add(filme);
    }

    public void iniciacomponentes(){

        bt_voltar = findViewById(R.id.voltarprincipal2);
    }


}