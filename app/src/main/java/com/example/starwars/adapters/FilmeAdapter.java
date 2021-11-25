package com.example.starwars.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;
import com.example.starwars.model.Filme;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.MyViewHolder> {

    private  List<Filme> filmes;
    public FilmeAdapter(List<Filme> listaFilmes) {
        this.filmes = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.filme_detalhe, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.nomeFilme.setText(filme.getNome());
        holder.textano.setText(filme.getAno());
        holder.textgenero.setText(filme.getGenero());
        holder.texttempoFilme.setText(filme.getTempoFilme());
        holder.textlancamento.setText(filme.getLancamento());
        holder.textdiretor.setText(filme.getDiretor());
        holder.textbilheteria.setText(filme.getBilheteria());
        holder.textprodutora.setText(filme.getProdutora());
        holder.texthistoria.setText(filme.getHistoria());
        holder.imageCard.setImageResource(filme.getImagem());
    }

    @Override
    public int getItemCount() {

        return filmes.size();
    }

    //private List<Filme> listafilme;

    //public  FilmeAdapter (List<Filme> lista) {this.listafilme = lista;}
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeFilme, textano, textgenero, texttempoFilme, texthistoria, textlancamento, textdiretor, textprodutora, textbilheteria;
        private ImageView imageCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeFilme = itemView.findViewById(R.id.nomeFilme);
            textano = itemView.findViewById(R.id.textAno);
            textgenero = itemView.findViewById(R.id.textGenero);
            texttempoFilme = itemView.findViewById(R.id.textTempo);
            texthistoria = itemView.findViewById(R.id.textHistoria);
            textlancamento = itemView.findViewById(R.id.textLancamento);
            textdiretor = itemView.findViewById(R.id.textDiretor);
            textprodutora = itemView.findViewById(R.id.textProdutora);
            textbilheteria = itemView.findViewById(R.id.textBilheteria);
            imageCard = itemView.findViewById(R.id.imageView);
        }
    }

}
