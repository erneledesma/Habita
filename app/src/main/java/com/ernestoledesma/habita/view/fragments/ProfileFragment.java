package com.ernestoledesma.habita.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.ernestoledesma.habita.R;
import com.ernestoledesma.habita.adapter.PictureAdapterRecyclerView;
import com.ernestoledesma.habita.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("",false,view);

        RecyclerView picturesRecycler = view.findViewById(R.id.picturesProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((getContext()));
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager((linearLayoutManager));

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buidPicture(), R.layout.cardview_property, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    // Creamos un metodo para que nos devuelva un arrayList de Propiedades
    public ArrayList<Picture> buidPicture(){
        ArrayList<Picture>pictures = new ArrayList<>();
        pictures.add( new Picture("https://decoratrix.estaticos.com.es/img/posts/2011/12/apartamento_toronto_cocina.jpg","Pablo MArtinez"," 2 km","3 favoritos"));
        pictures.add( new Picture("http://bi.gazeta.pl/im/6c/9c/13/z20564588IER,Biel-przelamano-czernia--szaroscia-i-blekitem-.jpg","Colon","900 mts","4 favoritos"));
        pictures.add( new Picture("http://www.baoxaydung.com.vn/stores/news_dataimages/hiep/052014/04/21/6cc5e3dd781009b677a8f983789f6d52.jpg","Centro","1km","1 favoritos"));

        return pictures;

    }



    public void showToolbar(String tittle, boolean upButton, View view){
        android.support.v7.widget.Toolbar toolbar =  view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
