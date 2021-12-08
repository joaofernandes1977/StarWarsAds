package com.example.starwars.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;
import com.example.starwars.model.Personagen;

import java.util.List;

public class PersonagenAdapter extends RecyclerView.Adapter<PersonagenAdapter.MyViewHolder> {
    private List<Personagen> personagen;

    public PersonagenAdapter(List<Personagen> lista) {
        this.personagen = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.api_result_cadastro, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Personagen personagen = this.personagen.get( position);

    }

    @Override
    public int getItemCount() {
        return personagen.size();
    }

    //iner class
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, nome, urlImage, especie, veiculo, historia;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome_person);
            urlImage = itemView.findViewById(R.id.url_2);
            especie = itemView.findViewById(R.id.especie);
            veiculo = itemView.findViewById(R.id.veiculo);
            historia = itemView.findViewById(R.id.historia_4);
        }
    }

}