package com.example.starwars.adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;

import com.example.starwars.model.Nave;
import com.example.starwars.model.Planeta;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NaveAdapter extends RecyclerView.Adapter<NaveAdapter.ViewHolder> {


    private List<Nave> dados3;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public NaveAdapter(List<Nave> posts) {
        this.dados3 = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nave_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nave nave = dados3.get(position);

        TextView tv = holder.view.findViewById(R.id.naveNome);
        tv.setText(nave.getNome());

        tv = holder.view.findViewById(R.id.naveDescricao);
        tv.setText(nave.getDescricao());

        ImageView iv = holder.view.findViewById(R.id.imageNave);
        Picasso.get().load(nave.getUrl()).into(iv);


    }


    @Override
    public int getItemCount() {

        return dados3.size();
    }


}
