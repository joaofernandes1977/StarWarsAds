package com.example.starwars.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.starwars.R;
import com.example.starwars.activityview.StarPrincipal;
import com.example.starwars.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class HomeFragment extends Fragment {
    StarPrincipal starPrincipal = new StarPrincipal();
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FirebaseFirestore banco = FirebaseFirestore.getInstance();
        View v =  inflater.inflate(R.layout.activity_star_principal, container, false);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = banco.collection("Usuarios").document(userId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null){
                    TextView nomeUser = v.findViewById(R.id.nome_usuario);
                    TextView nomeEmail = v.findViewById(R.id.nome_mail);


                    nomeUser.setText(documentSnapshot.getString("nome"));
                    nomeEmail.setText(documentSnapshot.getString("email"));

                }
            }
        });
        return v;
    }
/*
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
*/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}