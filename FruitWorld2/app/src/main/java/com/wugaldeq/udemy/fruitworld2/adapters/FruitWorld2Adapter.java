package com.wugaldeq.udemy.fruitworld2.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wugaldeq.udemy.fruitworld2.R;
import com.wugaldeq.udemy.fruitworld2.model.Fruit;

import java.util.List;

/**
 * Clase principal de la ejecución del programa
 * Created by wilfredo on 31-01-18.
 */

public class FruitWorld2Adapter extends RecyclerView.Adapter<FruitWorld2Adapter.ViewHolder>{

    private List<Fruit> fruits;
    private int layout;
    private Activity activity;
    private OnItemClickListener onItemClickListener;

    public FruitWorld2Adapter(List<Fruit> fruits, int layout, Activity activity, OnItemClickListener onItemClickListener) {
        this.fruits = fruits;
        this.layout = layout;
        this.activity = activity;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(fruits.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        private ImageView imgViewFruitBackGround;
        private TextView txViewNameFruit;
        private TextView txViewDescriptionFruit;
        private TextView txViewQuantityFruit;

        private ViewHolder(View itemView) {
            super(itemView);
            imgViewFruitBackGround = itemView.findViewById(R.id.imgViewFruitBackGround);
            txViewNameFruit = itemView.findViewById(R.id.txViewNameFruit);
            txViewDescriptionFruit = itemView.findViewById(R.id.txViewDescriptionFruit);
            txViewQuantityFruit = itemView.findViewById(R.id.txViewQuantityFruit);
            itemView.setOnCreateContextMenuListener(this);
        }

        private void bind(final Fruit fruit, final OnItemClickListener onItemClickListener){
            txViewNameFruit.setText(fruit.getNameFruit());
            txViewDescriptionFruit.setText(fruit.getDescriptionFruit());
            txViewQuantityFruit.setText(String.valueOf(fruit.getQuantity()));
            if(fruit.getQuantity() == Fruit.QUANTITY_LIMIT){
                txViewQuantityFruit.setTextColor(ContextCompat.getColor(activity, R.color.colorAlert));
                txViewQuantityFruit.setTypeface(null, Typeface.BOLD);
            } else {
                txViewQuantityFruit.setTextColor(ContextCompat.getColor(activity, R.color.defaultTextColor));
                txViewQuantityFruit.setTypeface(null, Typeface.NORMAL);
            }
            Picasso.with(activity).load(fruit.getImgBackGroundFruit()).fit().into(imgViewFruitBackGround);

            imgViewFruitBackGround.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(fruit,getAdapterPosition());
                }
            });
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            boolean result;

            switch (menuItem.getItemId()) {
                case R.id.deleteFruit:
                    fruits.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    result = true;
                    break;
                case R.id.resetQuantityFruit:
                    Fruit fruit = fruits.get(getAdapterPosition());
                    fruit.resetQuantity();
                    fruits.set(getAdapterPosition(),fruit);
                    notifyItemChanged(getAdapterPosition());
                    result = true;
                    break;
                default:
                    result = false;
            }
            return result;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Fruit fruitSelected = fruits.get(getAdapterPosition());
            contextMenu.setHeaderTitle(fruitSelected.getNameFruit());
            contextMenu.setHeaderIcon(fruitSelected.getImgIconFruit());

            MenuInflater menuInflater = activity.getMenuInflater();
            menuInflater.inflate(R.menu.context_menu_item_fruit,contextMenu);
            int i = 0;
            while (i < contextMenu.size()){
                contextMenu.getItem(i).setOnMenuItemClickListener(this);
                i++;
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Fruit fruit, int position);
    }
}
