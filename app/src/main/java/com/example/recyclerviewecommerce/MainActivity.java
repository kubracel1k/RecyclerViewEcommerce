 package com.example.recyclerviewecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<FilmLer> filmLerArrayList;
    private FilmAdapter adapter;
    private TabLayout tablayout;
    private ViewPager2 viewpager2;
    private ArrayList<Fragment> fragmentListesi=new ArrayList<>();
    private boolean deneme;
    private ArrayList<String> fragmentBaslikListesi=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        FilmLer f1=new FilmLer(0,"Puss in Boots:The Last Wish",29.99,"cizmelii");
        FilmLer f2=new FilmLer(1,"Stranger Things",39.99,"stranger");
        FilmLer f3=new FilmLer(2,"Vikings",39.99,"vikings");
        FilmLer f4=new FilmLer(3,"Whiplash",49.99,"whiplash");

        filmLerArrayList=new ArrayList<>();
        filmLerArrayList.add(f1);
        filmLerArrayList.add(f2);
        filmLerArrayList.add(f3);
        filmLerArrayList.add(f4);

        adapter=new FilmAdapter(this,filmLerArrayList);
        rv.setAdapter(adapter);

        tablayout=findViewById(R.id.tabLayout);
        viewpager2=findViewById(R.id.viewpager2);
        fragmentListesi.add(new FragmentBirinci());
        fragmentListesi.add(new FragmentIkinci());
        fragmentListesi.add(new FragmentUcuncu());
        MyViewPagerAdapter adapter1=new MyViewPagerAdapter(this);
        viewpager2.setAdapter(adapter1);
        fragmentBaslikListesi.add("Ana Sayfa");
        fragmentBaslikListesi.add("Favori");
        fragmentBaslikListesi.add("Sepet");

        new TabLayoutMediator(tablayout,viewpager2,
                (tab, position) -> tab.setText(fragmentBaslikListesi.get(position))).attach();
        tablayout.getTabAt(0).setIcon(R.drawable.baseline_home_24);
        tablayout.getTabAt(1).setIcon(R.drawable.baseline_favorite_24);
        tablayout.getTabAt(2).setIcon(R.drawable.baseline_shopping_basket_24);
    }
    private class MyViewPagerAdapter extends FragmentStateAdapter{

        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentListesi.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentListesi.size();
        }
    }
}