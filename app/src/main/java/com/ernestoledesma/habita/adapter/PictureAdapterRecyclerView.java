package com.ernestoledesma.habita.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ernestoledesma.habita.R;
import com.ernestoledesma.habita.model.Picture;
import com.ernestoledesma.habita.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecyclerView  extends RecyclerView.Adapter<PictureAdapterRecyclerView.PisctureViewHolder>{


    //Manejo los arreglos de pictures - tipo objetos picture
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity; // llamo al objeto para traer las imagenes

    //Genero el constructor


    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PisctureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PisctureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PisctureViewHolder holder, int position) {

        //Aqui trabajamos con la lista de objetos
        Picture picture = pictures.get(position);
        holder.userNameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText((picture.getLike_number()));

        //Modificamos el contexto, y llamamos a picture para insertar laas imagenes desde nuestra card
        Picasso.with(activity).load(picture.getPicture()).into(holder.property_card);

        //Aqui le pasamos los parametros de los detalles de las vistas para que sean clikeable las cards
        holder.property_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    // Creo mi clase inner
    public class PisctureViewHolder extends RecyclerView.ViewHolder{

        //encapsulamos
        private ImageView property_card;
        private TextView userNameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        //Creamos el constructor
        public PisctureViewHolder(View itemView) {
            super(itemView);

            // instanciamos las propiedades
            property_card = (ImageView) itemView.findViewById(R.id.property_card);
            userNameCard  = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
