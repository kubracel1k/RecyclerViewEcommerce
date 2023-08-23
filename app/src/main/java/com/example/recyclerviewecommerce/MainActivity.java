 package com.example.recyclerviewecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<FilmLer> filmLerArrayList;
    private FilmAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        FilmLer f1=new FilmLer(1,"Puss in Boots:The Last Wish",29.99,"cizmelii");
        FilmLer f2=new FilmLer(2,"Stranger Things",39.99,"stranger");
        FilmLer f3=new FilmLer(4,"Vikings",39.99,"vikings");
        FilmLer f4=new FilmLer(3,"Whiplash",49.99,"whiplash");

        filmLerArrayList=new ArrayList<>();
        filmLerArrayList.add(f1);
        filmLerArrayList.add(f2);
        filmLerArrayList.add(f3);
        filmLerArrayList.add(f4);

        adapter=new FilmAdapter(this,filmLerArrayList);
        rv.setAdapter(adapter);
    }
}