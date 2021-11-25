package com.example.starwars.ui.desenvolvimento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.starwars.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DesenvolvimentoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesenvolvimentoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DesenvolvimentoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DesenvolvimentoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DesenvolvimentoFragment newInstance(String param1, String param2) {
        DesenvolvimentoFragment fragment = new DesenvolvimentoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String descricao =
                "Android Studio Arctic Fox | 2020.3.1 Patch 3\n"+
                "Linguagem: JAVA\n"+
                "***** Bibliotecas Utilizadas no APP *****\n" +
                "----------- build.gradle ----------- \n"+
                "    'com.google.firebase:firebase-bom:29.0.0'\n" +
                "    'com.google.firebase:firebase-auth'\n" +
                "    'com.google.firebase:firebase-firestore'\n" +
                "    'com.google.firebase:firebase-database'\n" +
                "    'com.squareup.picasso:picasso:2.71828'\n" +
                "    'androidx.recyclerview:recyclerview:1.2.1'\n" +
                "    'io.github.medyo:android-about-page:2.0.0'";


        return new AboutPage(getActivity())
                .setImage(R.drawable.logostar)
                .setDescription( descricao)
                .addEmail("joao.fernandez.hl@gmail.com", "Envie um e-mail")
                .addGitHub("Grupo1-ADS","GitHub - Grupo1")


                .create();
        //return inflater.inflate(R.layout.fragment_desenvolvimento, container, false);
    }
}