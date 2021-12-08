package com.example.starwars.adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;

import com.example.starwars.model.Planeta;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlanetaAdapter extends RecyclerView.Adapter<PlanetaAdapter.ViewHolder> {


    private List<Planeta> dados3;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PlanetaAdapter(List<Planeta> posts) {
        this.dados3 = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planeta_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Planeta planeta = dados3.get(position);

        TextView tv = holder.view.findViewById(R.id.planetaNome);
        tv.setText(planeta.getNome());

        tv = holder.view.findViewById(R.id.planetaDescricao);
        tv.setText(planeta.getDescricao());

       ImageView iv = holder.view.findViewById(R.id.imagePlaneta);
        Picasso.get().load(planeta.getUrl()).into(iv);


    }


    @Override
    public int getItemCount() {

        return dados3.size();
    }


}
