package com.example.starwars.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.R;
import com.example.starwars.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> dadosUser;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
    public UserAdapter(List<User> users) { this.dadosUser = users;}

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_star_principal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = dadosUser.get(position);

        TextView nome = holder.view.findViewById(R.id.nome_usuario);
        nome.setText(user.getName());
        TextView email = holder.view.findViewById(R.id.nome_mail);
        email.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return dadosUser.size();
    }
}
