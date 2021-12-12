package com.example.starwars;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.starwars.viewModel.FilmeViewModel;
import com.google.android.material.navigation.NavigationView;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.starwars.databinding.ActivityPrincipalDrawerNavBinding;

public class PrincipalDrawerNav extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;
    private ActivityPrincipalDrawerNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AvatarViewModel viewModel = new ViewModelProvider(this).get(AvatarViewModel.class);
        FilmeViewModel viewModelfilme = new ViewModelProvider(this).get(FilmeViewModel.class);


        viewModelfilme.getAllFilmes().observe(this,filmes ->{});

        binding = ActivityPrincipalDrawerNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarPrincipalDrawerNav.toolbar);
        binding.appBarPrincipalDrawerNav.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviaEmail();

                /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

            }

        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
        R.id.nav_principal, R.id.nav_planetas, R.id.nav_listafilmes, R.id.nav_avatares, R.id.nav_trailer, R.id.nav_desenvolvimento, R.id.nav_agradecimento,
                R.id.nav_contato, R.id.nav_sair, R.id.nav_personagem)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal_drawer_nav);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //View v = findViewById(R.id.textNomeDr);
        //View v1 = findViewById(R.id.textEmailDr);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.principal_drawer_nav, menu);

        return true;
    }

    public void enviaEmail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Digite o destino!"});
        intent.putExtra(Intent.EXTRA_SUBJECT, new String[]{"Digite contato:"});
        intent.putExtra(Intent.EXTRA_TEXT, new String[]{"A força está com você!"});
        intent.setType("message/rfc822");
        intent.setType("image/*");
        startActivity(intent);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal_drawer_nav);


        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }





}