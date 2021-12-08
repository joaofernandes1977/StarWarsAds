package com.example.starwars.adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;
import com.example.starwars.model.Personagem;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.ViewHolder> {


    private List<Personagem> dados3;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PersonagemAdapter(List<Personagem> posts) {
        this.dados3 = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.personagem_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personagem personagem = dados3.get(position);

        TextView tv = holder.view.findViewById(R.id.personagemId);
        tv.setText(personagem.getId());

        tv = holder.view.findViewById(R.id.sobrePersonagem);
        tv.setText(personagem.getTitle());

        //TextView img = holder.view.findViewById(R.id.urlCaminho);
        //img.setText(personagem.getUrl());

        ImageView iv = holder.view.findViewById(R.id.imagePersonagem);
        Picasso.get().load(personagem.getUrl()).into(iv);




        //PASSANDO A MESMA URL "IMAGEM"
        //Picasso.get().load("https://loja.uniritteronline.com.br/media/logo/stores/35/UNIRITTER.png").into(iv);

        //PASSANDO AS URLs DIFERENTES OBS: NÃO DA ERRO QUANDO COMPILA SO NÃO APARECE NENHUMA IMAGEM
        //ImageView iv = holder.view.findViewById(R.id.imagePhotos);
        //Picasso.get().load(String.valueOf(img)).into(iv);


    }


    @Override
    public int getItemCount() {

        return dados3.size();
    }


}
