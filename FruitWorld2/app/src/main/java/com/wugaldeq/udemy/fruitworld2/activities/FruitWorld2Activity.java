package com.wugaldeq.udemy.fruitworld2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.wugaldeq.udemy.fruitworld2.R;
import com.wugaldeq.udemy.fruitworld2.adapters.FruitWorld2Adapter;
import com.wugaldeq.udemy.fruitworld2.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitWorld2Activity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private FruitWorld2Adapter fruitWorld2Adapter;

    private List<Fruit> fruits;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_world2);

        fruits = getAllFruits();

        RecyclerView recyclerView = findViewById(R.id.reciclerViewFruits);
        layoutManager = new LinearLayoutManager(this);
        fruitWorld2Adapter = new FruitWorld2Adapter(fruits, R.layout.recycler_card_view_fruit_item, this, new FruitWorld2Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit, int position) {
                fruit.setQuantityWithLimit(1);
                fruitWorld2Adapter.notifyItemChanged(position);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fruitWorld2Adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result;
        switch (item.getItemId()){
            case R.id.itemAddFruit:
                contador++;
                int position = fruitWorld2Adapter.getItemCount();
                fruits.add(new Fruit("Nueva Fruta "+contador,"No se sabe practicamente nada de esta fruta",R.drawable.plum_bg,R.mipmap.ic_plum,0));
                fruitWorld2Adapter.notifyItemInserted(position);
                layoutManager.scrollToPosition(position);
                result = true;
                break;
            default:
                result = super.onOptionsItemSelected(item);
                break;
        }
        return result;
    }

    private List<Fruit> getAllFruits() {
        List<Fruit> frutas = new ArrayList<>();
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
