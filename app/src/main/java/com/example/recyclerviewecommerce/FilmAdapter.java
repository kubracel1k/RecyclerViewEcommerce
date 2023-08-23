package com.example.recyclerviewecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTassarimNesneleriniTututucu>{
    private Context context;
    private List<FilmLer> fimlerList;

    public FilmAdapter(Context context, List<FilmLer> fimlerList) {
        this.context = context;
        this.fimlerList = fimlerList;
    }


    public class CardViewTassarimNesneleriniTututucu extends RecyclerView.ViewHolder{
        public ImageView imageViewFilmResim;
        public TextView textViewFilmBaslik;
        public TextView textViewFilmFiyat;
        public Button buttonSepeteEkle;

        public CardViewTassarimNesneleriniTututucu(@NonNull View itemView) {
            super(itemView);
            imageViewFilmResim=itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmBaslik=itemView.findViewById(R.id.textViewFilmBaslik);
            textViewFilmFiyat=itemView.findViewById(R.id.textViewFilmFiyat);
            buttonSepeteEkle=itemView.findViewById(R.id.buttonSepeteEkle);
        }
    }

    @NonNull
    @Override
    public CardViewTassarimNesneleriniTututucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//tanımlanan görseller hangi tasarımdan alınacak
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_film_layout,parent,false);
        return new CardViewTassarimNesneleriniTututucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTassarimNesneleriniTututucu holder, int position) {//liste içerisinden gelen nesnenin
        //içersindeki bilgileri tasarıma yerleştirmek gerek bununla yapılır.bu method satır satır çalışır
      final FilmLer filmLer=fimlerList.get(position);
        holder.textViewFilmBaslik.setText(filmLer.getFilmBaslik());
        holder.textViewFilmFiyat.setText(filmLer.getFilmFiyat()+" TL ");
        holder.imageViewFilmResim.setImageResource(context.getResources().
                getIdentifier(filmLer.getFilmBaslik(),"drawable",context.getPackageName()));
        holder.buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,filmLer.getFilmBaslik()+" sepete eklendi",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {//kaç card gösterilecek
        return fimlerList.size();
    }
}
