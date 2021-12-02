package com.example.starwars.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;
import com.example.starwars.model.People;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {


    private List<People> dados3;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PeopleAdapter(List<People> posts) {
        this.dados3 = posts;
    }

    @NonNull
    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        People pessoa = dados3.get(position);

        TextView tv = holder.view.findViewById(R.id.nomePessoa);
        tv.setText(pessoa.getName());

        tv = holder.view.findViewById(R.id.aniverPessoa);
        tv.setText(pessoa.getHeight());

        TextView img = holder.view.findViewById(R.id.olhosPessoa);
        img.setText(pessoa.getUrl());

        ImageView iv = holder.view.findViewById(R.id.genderPessoa);
        Picasso.get().load(pessoa.getUrl()).into(iv);




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
