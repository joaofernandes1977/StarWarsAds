package com.example.starwars.adapters;

import android.hardware.lights.LightState;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;
import com.example.starwars.model.Avatar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.MyViewHolder> {
    private  List<Avatar> lista;
    public AvatarAdapter(List<Avatar> listaAvatar) {
        this.lista = listaAvatar;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemAvatar = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_avatar, parent, false);

        return new MyViewHolder(itemAvatar);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Avatar avatar = lista.get(position);

        holder.nome.setText(avatar.getNome());

        Picasso.get().load(avatar.getUrl()).into(holder.avatar);


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nome;
        private ImageView avatar;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                nome = itemView.findViewById(R.id.nome_avatar);
                avatar = itemView.findViewById(R.id.avatar_img);

          }
    }
}
