package com.wugaldeq.udemy.fruitworld2.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wugaldeq.udemy.fruitworld2.R;
import com.wugaldeq.udemy.fruitworld2.adapters.FruitWorld2Adapter;
import com.wugaldeq.udemy.fruitworld2.model.Fruit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FruitWorld2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FruitWorld2Adapter fruitWorld2Adapter;

    private List<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_world2);

        fruits = getAllFruits();

        recyclerView = findViewById(R.id.reciclerViewFruits);
        layoutManager = new LinearLayoutManager(this);
        fruitWorld2Adapter = new FruitWorld2Adapter(fruits, R.layout.recycler_card_view_fruit_item, this, new FruitWorld2Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit, int position) {

            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fruitWorld2Adapter);
    }

    private List<Fruit> getAllFruits() {
        List<Fruit> frutas = new ArrayList<Fruit>();
        frutas.add(new Fruit("Frutilla","Fruto redondo carnoso y dulce de color rojo escarlata, con pequeñas semillas.",R.drawable.strawberry_bg,R.mipmap.ic_strawberry,0));
        frutas.add(new Fruit("Frambuesa","Fruto de sabor fuerte y dulce, parecida a la zarzamora pero más pequeña.",R.drawable.raspberry_bg,R.mipmap.ic_raspberry,0));
        frutas.add(new Fruit("Pera","Fruta jugos, carnosa y una de las más importantes producida en regiones templadas.",R.drawable.pear_bg,R.mipmap.ic_pear,0));
        frutas.add(new Fruit("Naranaja","Fruta cítrica, comestible, de cascara mas o menos gruesa y endurecida.",R.drawable.orange_bg,R.mipmap.ic_orange,0));
        frutas.add(new Fruit("Guinda","Fruto del guindo, comestible, pequeño y redondo, de color rojo muy vivo.",R.drawable.cherry_bg,R.mipmap.ic_cherry,0));
        frutas.add(new Fruit("Platano","El fruto es una falsa baya epígina de 7 a 30 cm de largo y hasta 5 de diámetro.",R.drawable.banana_bg,R.mipmap.ic_banana,0));
        frutas.add(new Fruit("Manzana","Fruto del manzano, comestible, piel fina, de color verde o rojo, carne blanca y jugosa.",R.drawable.apple_bg,R.mipmap.ic_apple,0));
        return frutas;
    }
}
